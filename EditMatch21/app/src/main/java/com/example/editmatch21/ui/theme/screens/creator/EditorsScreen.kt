package com.example.editmatch21.ui.theme.screens.creator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.editmatch21.ui.theme.composables.CardEditor
import com.example.editmatch21.ui.theme.composables.LinhaDivider
import com.example.editmatch21.ui.theme.composables.CardToProject
import com.example.editmatch21.ui.theme.composables.HeaderToCreator
import com.example.editmatch21.ui.theme.viewmodels.EditoresViewModel
@Composable
fun EditorsScreen(
    navigateToProjects: () -> Unit,
    navigateToEditors: () -> Unit,
    navigateToDetails: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToSend: () -> Unit,
    navigateToProfileEditorScreen: (Int) -> Unit
) {
    val viewModel: EditoresViewModel = viewModel()

    androidx.compose.runtime.LaunchedEffect(Unit) {
        viewModel.getEditores()
    }

    val editores by viewModel.editores.observeAsState(initial = emptyList())
    val isLoading by viewModel.isLoading.observeAsState(initial = false)
    val erroApi by viewModel.erroApi.observeAsState()
    val navController = rememberNavController()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header
            HeaderToCreator(
                "Editores",
                navigateToLogin = navigateToLogin,
                navigateToProjects = navigateToProjects,
                navigateToEditors = navigateToEditors,
                navigateToSend = navigateToSend
            )

            Spacer(modifier = Modifier.height(16.dp))

            when {
                isLoading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
                erroApi != null -> {
                    Text(
                        text = "Erro ao carregar editores: $erroApi",
                        color = Color.Red,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                editores.isNullOrEmpty() -> {
                    Text(
                        text = "Nenhum editor encontrado",
                        color = Color.Red,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                else -> {
                    editores.forEach { editor ->
                        val nome = editor.nome
                        val foto = editor.photoProfileLink
                        val id = editor.id
                        CardEditor(navController, id.toInt(), nome, foto, navigateToProfileEditorScreen)
                        LinhaDivider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

