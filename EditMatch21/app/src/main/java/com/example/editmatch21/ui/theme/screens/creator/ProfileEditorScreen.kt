package com.example.editmatch21.ui.theme.screens.creator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.editmatch21.ui.theme.composables.Header
import com.example.editmatch21.ui.theme.composables.HeaderToCreator
import com.example.editmatch21.ui.theme.composables.PortifolioProfile
import com.example.editmatch21.ui.theme.composables.ProfileHeader
import com.example.editmatch21.ui.theme.viewmodels.EditoresViewModel

@Composable
fun ProfileEditorScreen(
    editorId: Int,
    navigateToLogin: () -> Unit,
    navigateToProjects: () -> Unit,
    navigateToEditors: () -> Unit,
    navigateToSend: () -> Unit,
    navigateToHirePage: () -> Unit
) {
    val viewModel: EditoresViewModel = viewModel()

    androidx.compose.runtime.LaunchedEffect(editorId) {
        viewModel.getEditorById(editorId)
    }

    val editor by viewModel.editor.observeAsState();

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        HeaderToCreator(
            screenName = "Perfil",
            navigateToLogin = navigateToLogin,
            navigateToProjects = navigateToProjects,
            navigateToEditors = navigateToEditors,
            navigateToSend = navigateToSend
        )

        Spacer(modifier = Modifier.height(26.dp))

        Spacer(modifier = Modifier.height(16.dp))

        editor?.let { PortifolioProfile(it, navigateToHirePage) }
    }
}

