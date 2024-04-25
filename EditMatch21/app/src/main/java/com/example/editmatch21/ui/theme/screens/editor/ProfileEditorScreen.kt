package com.example.editmatch21.ui.theme.screens.editor

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.editmatch21.R
import com.example.editmatch21.ui.theme.composables.Header
import com.example.editmatch21.ui.theme.composables.LinhaDivider
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Header(
            screenName = "Perfil",
            modifier = Modifier,
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

