package com.example.editmatch21.ui.theme.screens.creator

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.editmatch21.ui.theme.composables.HeaderToCreator
import com.example.editmatch21.ui.theme.viewmodels.UploadViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

@Composable
fun SendProjectScreen(
    screenName: String,
    navigateToLogin: () -> Unit,
    navigateToSend: () -> Unit,
    navigateToProjects: () -> Unit,
    navigateToEditors: () -> Unit
) {
    val viewModel: UploadViewModel = viewModel()
    val context = LocalContext.current
    var tituloProjeto by remember { mutableStateOf("") }
    var descricaoProjeto by remember { mutableStateOf("") }
    var skillsProjeto by remember { mutableStateOf("") }
    var videoUri by remember { mutableStateOf<Uri?>(null) }
    var videoLink by remember { mutableStateOf("") }
    var logMessages by remember { mutableStateOf(listOf<String>()) }

    // Recupera o ID do usuário dos SharedPreferences
    val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val userId = sharedPref.getString("user_id", null)

    val videoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        videoUri = uri
        uri?.let {
            val file = getFileFromUri(context, uri)
            if (file != null && file.exists()) {
                val logMessage = "Vídeo selecionado: ${file.path}"
                logMessages = logMessages + logMessage
                Log.d("SendProjectScreen", logMessage)
                viewModel.uploadVideo(tituloProjeto, uri, file)
            } else {
                val logMessage = "Erro: arquivo não existe."
                logMessages = logMessages + logMessage
                Log.e("SendProjectScreen", logMessage)
            }
        }
    }

    val uploadStatus by viewModel.uploadStatus.observeAsState()
    val uploadError by viewModel.uploadError.observeAsState()

    LaunchedEffect(uploadStatus) {
        uploadStatus?.let {
            logMessages = logMessages + it
            videoLink = it
        }
    }

    LaunchedEffect(uploadError) {
        uploadError?.let {
            logMessages = logMessages + it
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        HeaderToCreator(
            screenName = "Publicar Projeto",
            navigateToLogin = navigateToLogin,
            navigateToSend = navigateToSend,
            navigateToProjects = navigateToProjects,
            navigateToEditors = navigateToEditors,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Novo pedido")
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = tituloProjeto,
                onValueChange = { tituloProjeto = it },
                label = { Text("Título") }
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = descricaoProjeto,
                onValueChange = { descricaoProjeto = it },
                label = { Text("Descrição") }
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = skillsProjeto,
                onValueChange = { skillsProjeto = it },
                label = { Text("Skills (separadas por vírgula)") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val logMessage = "Botão 'Publicar' clicado"
                    logMessages = logMessages + logMessage
                    Log.d("SendProjectScreen", logMessage)
                    if (videoLink.isNotEmpty() && userId != null) {
                        val skillsList = skillsProjeto.split(",").map { it.trim() }
                        val sendLogMessage = "Enviando projeto: $tituloProjeto, $descricaoProjeto, $skillsList, $videoLink"
                        logMessages = logMessages + sendLogMessage
                        Log.d("SendProjectScreen", sendLogMessage)
                        viewModel.sendProjectData(userId, tituloProjeto, descricaoProjeto, skillsList, videoLink)
                    } else {
                        val errorLogMessage = "Erro: Video link ou User ID está vazio."
                        logMessages = logMessages + errorLogMessage
                        viewModel.updateUploadError(errorLogMessage)
                        Log.e("SendProjectScreen", errorLogMessage)
                    }
                },
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text(text = "Publicar")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val logMessage = "Botão 'Selecionar Vídeo' clicado"
                    logMessages = logMessages + logMessage
                    Log.d("SendProjectScreen", logMessage)
                    videoPickerLauncher.launch("video/*")
                },
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text(text = "Selecionar Vídeo")
            }

            videoUri?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Vídeo selecionado: ${it.path}")
            }

            uploadStatus?.let {
                Text(text = it)
            }

            uploadError?.let {
                Text(text = it)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text("Logs:")
                logMessages.forEach { logMessage ->
                    Text(text = logMessage)
                }
            }
        }
    }
}

fun getFileFromUri(context: Context, uri: Uri): File? {
    val contentResolver = context.contentResolver
    val fileName = getFileName(contentResolver, uri)
    val file = File(context.cacheDir, fileName)
    try {
        val inputStream = contentResolver.openInputStream(uri) ?: return null
        val outputStream = FileOutputStream(file)
        inputStream.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }
        return file
    } catch (e: Exception) {
        Log.e("SendProjectScreen", "Erro ao converter URI para arquivo: ${e.message}")
        return null
    }
}

fun getFileName(contentResolver: ContentResolver, uri: Uri): String {
    var name = ""
    val returnCursor = contentResolver.query(uri, null, null, null, null)
    returnCursor?.use {
        val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        it.moveToFirst()
        name = it.getString(nameIndex)
    }
    return name
}
