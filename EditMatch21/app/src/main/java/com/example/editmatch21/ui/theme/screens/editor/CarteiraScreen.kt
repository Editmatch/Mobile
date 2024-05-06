package com.example.editmatch21.ui.theme.screens.editor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.editmatch21.ui.theme.composables.CardToCarteira
import com.example.editmatch21.ui.theme.composables.Header
import com.example.editmatch21.ui.theme.composables.Tabela

@Composable
fun Carteira(
    navigateToEditProfile: () -> Unit,
    navigateToLogin:() -> Unit,
    navigateToProjects: () -> Unit,
    navigateToWorks: () -> Unit,
    navigateToCarteira: () -> Unit
) {
    val navController = rememberNavController()
    // valores do banco de dados
    val valores = remember {
        listOf(
            listOf("03-05-2024", "Entrada", "R$ 30,00"),
            listOf("03-05-2024", "Saida", "R$ 10,00")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Header(
            screenName = "Carteira",
            modifier = Modifier,
            navigateToLogin = navigateToLogin,
            navigateToProfile = navigateToEditProfile,
            navigateToProjects = navigateToProjects,
            navigateToWorks = navigateToWorks,
            navigateToCarteira = navigateToCarteira
        )

        Spacer(modifier = Modifier.height(26.dp))

        Column {
            CardToCarteira()
            Tabela(valores = valores)
        }
    }
}