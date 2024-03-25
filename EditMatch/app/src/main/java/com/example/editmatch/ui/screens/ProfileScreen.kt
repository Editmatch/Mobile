package com.example.editmatch.ui.screens

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.TagFaces
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.editmatch.R

@Composable
fun ProfileScreen(navigateToEditProfile: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ProfileHeader(navigateToEditProfile)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ProfileOptionItem(icon = Icons.Filled.GridOn, text = "Portfólio")
        }

        // Conteúdo do perfil (publicações, etc.)
        // Adicione aqui o conteúdo do perfil conforme necessário
    }
}

@Composable
fun ProfileHeader(navigateToEditProfile: () -> Unit) {
    Spacer(modifier = Modifier.width(16.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.mipmap.perfil),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(94.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(30.dp))

        Column {
            Text(
                text = "Fernando Silva",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            )

            Spacer(modifier = Modifier.size(15.dp))
            Text(
                text = "Sou um editor com experiências em vídeos curtos ",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.fillMaxWidth()
            )
            TextButton(onClick = navigateToEditProfile) {
                Text(text = "Editar perfil")
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ProfileOptionItem(icon: ImageVector, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(text = text)
    }
}