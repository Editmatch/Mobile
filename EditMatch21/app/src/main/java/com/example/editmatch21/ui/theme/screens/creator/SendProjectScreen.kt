package com.example.editmatch21.ui.theme.screens.creator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.editmatch21.ui.theme.composables.Header
import com.example.editmatch21.ui.theme.composables.ProjectInfoField
import com.example.editmatch21.ui.theme.composables.VideoFilePicker

@Composable
fun SendProjectScreen(
    projectName: String,
    navigateToEditProfile: () -> Unit,
    navigateToLogin:() -> Unit,
    navigateToProjects: () -> Unit,
    navigateToWorks: () -> Unit,
    navigateToCarteira: () -> Unit,
) {
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Header(
            screenName = "Publicar Projeto",
            navigateToLogin = navigateToLogin,
            navigateToProfile = navigateToEditProfile,
            navigateToProjects = navigateToProjects,
            navigateToWorks = navigateToWorks,
            navigateToCarteira = navigateToCarteira
        )

        Spacer(modifier = Modifier.height(26.dp))

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            // Componente para selecionar e exibir o arquivo de vídeo
            VideoFilePicker()

            Spacer(modifier = Modifier.height(16.dp))

            // Campos de informações do projeto
            ProjectInfoField(label = "Nome do cliente", text = "Cliente XYZ")
            ProjectInfoField(label = "Título", text = "Projeto ABC")
            ProjectInfoField(label = "Descrição", text = "Descrição do projeto aqui...")
            ProjectInfoField(label = "Skills", text = "Habilidade 1, Habilidade 2, Habilidade 3")

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
                    Text(text = "Publicar")
                }
            }
        }
    }
}