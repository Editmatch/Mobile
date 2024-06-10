package com.example.editmatch21.ui.theme.screens.creator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.editmatch21.ui.theme.composables.HeaderToCreator
import com.example.editmatch21.ui.theme.composables.ProjectInfoField
import com.example.editmatch21.ui.theme.composables.VideoFilePicker
import com.example.editmatch21.ui.theme.viewmodels.OrderViewModel

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
                        onClick = { /* Lógica para download do projeto */ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Download")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    // Botão para pegar o projeto
                    Button(
                        onClick = { /* Lógica para pegar o projeto */ },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Pegar Projeto")
                    }
                }
            }
        }
    }
}
