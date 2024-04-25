package com.example.editmatch21.ui.theme.screens.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.editmatch21.ui.theme.composables.Header
import com.example.editmatch21.ui.theme.composables.LinhaDivider
import com.example.editmatch21.ui.theme.composables.CardToProject

@Composable
fun ProjectsScreen(
    navigateToProfile: () -> Unit,
    navigateToDetails: (String) -> Unit, // Adiciona uma função de navegação para os detalhes do projeto
    navigateToLogin: () -> Unit,
    navigateToProjects: () -> Unit,
    navigateToWorks: () -> Unit,
    navigateToCarteira: () -> Unit
) {
    val navController = rememberNavController()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header
            Header("Projetos",
                modifier = Modifier,
                navigateToLogin = {navigateToLogin()},
                navigateToProfile = {navigateToProfile()},
                navigateToProjects = {navigateToProjects()},
                navigateToWorks = {navigateToWorks()},
                navigateToCarteira = {navigateToCarteira()}
            )

            Spacer(modifier = Modifier.height(16.dp))

            CardToProject("Memes do neymar", "2")
            LinhaDivider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
            CardToProject("Streming GTA5","30")
            LinhaDivider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
            CardToProject("Maquiagem TikTok", "1")
            LinhaDivider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
            CardToProject("Corte PDP", "4")
            LinhaDivider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
            CardToProject("Trailer em português", "3")
            LinhaDivider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
            CardToProject("Anúncio para o Instagram", "0.25")
            LinhaDivider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
            CardToProject("Música", "3.56")
            LinhaDivider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
            CardToProject("Música", "4.47")
        }
    }
}