// ProjectDetailsScreen
package com.example.editmatch21.ui.theme.screens.editor

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.editmatch21.ui.theme.composables.Header
import com.example.editmatch21.ui.theme.composables.ProjectInfoField
import com.example.editmatch21.ui.theme.composables.VideoFilePicker
import com.example.editmatch21.ui.theme.viewmodels.OrderViewModel

@Composable
fun ProjectDetailsScreen(
    projectName: String,
    navigateToEditProfile: () -> Unit,
    navigateToLogin:() -> Unit,
    navigateToProjects: () -> Unit,
    navigateToWorks: () -> Unit,
    navigateToCarteira: () -> Unit,
) {
    val viewModel: OrderViewModel = viewModel()
    val orderDetail by viewModel.orderDetail.observeAsState()

    LaunchedEffect(key1 = projectName) {
        viewModel.getOrderDetail(projectName.toInt())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Header(
            screenName = "Detalhes do projeto",
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
            VideoFilePicker()

            Spacer(modifier = Modifier.height(16.dp))

            ProjectInfoField(label = "Nome do cliente", text = orderDetail?.nome ?: "Cliente XYZ")
            ProjectInfoField(label = "Título", text = orderDetail?.title ?: "Projeto ABC")
            ProjectInfoField(label = "Descrição", text = orderDetail?.desc ?: "Descrição do projeto aqui...")
            ProjectInfoField(label = "Skills", text = orderDetail?.skills ?: "Habilidade 1, Habilidade 2, Habilidade 3")

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Lógica para download do projeto */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Download")
                }

                Spacer(modifier = Modifier.width(16.dp))

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
