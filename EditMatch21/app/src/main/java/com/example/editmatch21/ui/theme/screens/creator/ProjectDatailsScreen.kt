package com.example.editmatch21.ui.theme.screens.creator

import android.content.Context
import android.os.Environment
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.editmatch21.ui.theme.composables.HeaderToCreator
import com.example.editmatch21.ui.theme.composables.ProjectInfoField
import com.example.editmatch21.ui.theme.composables.VideoFilePicker
import com.example.editmatch21.ui.theme.viewmodels.OrderViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

@Composable
fun ProjectDetailsClientScreen(
    projectName: String,
    orderID: String,
    navigateToLogin: () -> Unit,
    navigateToSend: () -> Unit,
    navigateToEditors: () -> Unit,
    navigateToProjects: () -> Unit
) {
    val navController = rememberNavController()
    val viewModel: OrderViewModel = viewModel()
    val orderDetails by viewModel.orderById.observeAsState()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    // Chamar a função para buscar os detalhes do pedido quando a tela é carregada
    LaunchedEffect(orderID) {
        viewModel.getOrderById(orderID.toInt())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        HeaderToCreator(
            screenName = "Detalhes do projeto",
            navigateToLogin = navigateToLogin,
            navigateToProjects = navigateToProjects,
            navigateToEditors = navigateToEditors,
            navigateToSend = navigateToSend
        )

        Spacer(modifier = Modifier.height(26.dp))

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            // Componente para selecionar e exibir o arquivo de vídeo
            VideoFilePicker()

            Spacer(modifier = Modifier.height(16.dp))

            // Exibir um indicador de carregamento enquanto os dados são carregados
            if (orderDetails == null) {
                Text(text = "Carregando...")
            } else {
                // Campos de informações do projeto
                ProjectInfoField(label = "Nome do cliente", text = orderDetails?.nome ?: "N/A")
                ProjectInfoField(label = "Título", text = orderDetails?.title ?: "N/A")
                ProjectInfoField(label = "Descrição", text = orderDetails?.desc ?: "N/A")
                ProjectInfoField(label = "Skills", text = orderDetails?.skills ?: "N/A")

                Spacer(modifier = Modifier.height(16.dp))

                // Botões de ação
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Botão de download
                    Button(
                        onClick = {
                            orderDetails?.link?.let { link ->
                                coroutineScope.launch {
                                    downloadFile(context, link) { success, message ->
                                        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                                    }
                                }
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Download")
                    }

                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
    }
}

suspend fun downloadFile(context: Context, fileUrl: String, onDownloadComplete: (Boolean, String) -> Unit) {
    withContext(Dispatchers.IO) {
        try {
            val client = OkHttpClient()
            val request = Request.Builder().url(fileUrl).build()
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val writtenToDisk = writeResponseBodyToDisk(context, response.body!!)
                withContext(Dispatchers.Main) {
                    onDownloadComplete(writtenToDisk, if (writtenToDisk) "Download completo" else "Erro ao salvar o arquivo")
                }
            } else {
                withContext(Dispatchers.Main) {
                    onDownloadComplete(false, "Erro ao baixar o arquivo")
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                onDownloadComplete(false, e.message ?: "Erro desconhecido")
            }
        }
    }
}

private fun writeResponseBodyToDisk(context: Context, body: okhttp3.ResponseBody): Boolean {
    return try {
        val file = File(
            context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),
            "downloaded_file"
        )
        var inputStream: InputStream? = null
        var outputStream: OutputStream? = null
        try {
            val fileReader = ByteArray(4096)
            val fileSize = body.contentLength()
            var fileSizeDownloaded: Long = 0
            inputStream = body.byteStream()
            outputStream = FileOutputStream(file)
            while (true) {
                val read = inputStream.read(fileReader)
                if (read == -1) {
                    break
                }
                outputStream.write(fileReader, 0, read)
                fileSizeDownloaded += read.toLong()
            }
            outputStream.flush()
            true
        } catch (e: Exception) {
            false
        } finally {
            inputStream?.close()
            outputStream?.close()
        }
    } catch (e: Exception) {
        false
    }
}
