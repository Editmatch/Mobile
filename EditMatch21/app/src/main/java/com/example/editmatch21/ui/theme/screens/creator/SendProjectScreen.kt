package com.example.editmatch21.ui.theme.screens.creator

import android.content.Context
import android.net.Uri
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

    // Recupera o ID do usuário dos SharedPreferences
    val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val userId = sharedPref.getString("user_id", null)

    val videoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        videoUri = uri
        uri?.let {
            val file = File(uri.path)
            viewModel.uploadVideo(uri, file)
        }
    }

    val uploadStatus by viewModel.uploadStatus.observeAsState()
    val uploadError by viewModel.uploadError.observeAsState()

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
                    if (videoLink.isNotEmpty() && userId != null) {
                        val skillsList = skillsProjeto.split(",").map { it.trim() }
                        viewModel.sendProjectData(userId, tituloProjeto, descricaoProjeto, skillsList, videoLink)
                    } else {
                        viewModel.updateUploadError("Video link ou User ID está vazio.")
                    }
                },
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text(text = "Publicar")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { videoPickerLauncher.launch("video/*") },
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
                videoLink = it
            }

            uploadError?.let {
                Text(text = it)
            }
        }
    }
}