package com.example.editmatch21.ui.theme.screens.editor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.editmatch21.ui.theme.composables.Header
import com.example.editmatch21.ui.theme.composables.PortifolioProfile
import com.example.editmatch21.ui.theme.composables.ProfileHeader

@Composable
fun ProfileScreen(
    navigateToEditProfile: () -> Unit,
    navigateToLogin:() -> Unit,
    navigateToProjects: () -> Unit,
    navigateToWorks: () -> Unit,
    navigateToCarteira: () -> Unit
) {
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Header(
            screenName = "Perfil",
            navigateToLogin = navigateToLogin,
            navigateToProfile = navigateToEditProfile,
            navigateToProjects = navigateToProjects,
            navigateToWorks = navigateToWorks,
            navigateToCarteira = navigateToCarteira
        )

        Spacer(modifier = Modifier.height(26.dp))

        ProfileHeader(navigateToEditProfile)

        Spacer(modifier = Modifier.height(16.dp))

        PortifolioProfile()
    }
}

