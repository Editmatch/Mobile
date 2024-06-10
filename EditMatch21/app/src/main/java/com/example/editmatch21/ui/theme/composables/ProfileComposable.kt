package com.example.editmatch21.ui.theme.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.editmatch21.R
import com.example.editmatch21.ui.theme.entities.Editores
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ProfileHeader(navigateToEditProfile: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray) // Light background for the profile header
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Fernando Silva",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Sou um editor com experiências em vídeos curtos",
            style = TextStyle(fontSize = 16.sp, color = Color.Black),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextButton(onClick = navigateToEditProfile) {
            Text(text = "Editar perfil", color = Color.Blue)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(modifier = Modifier.fillMaxWidth(), color = Color.Gray, thickness = 1.dp)
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
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )
        Text(text = text, color = Color.Black)
    }
}

@Composable
fun PortifolioProfile(editor: Editores, navigateToHirePage: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Profile Header Section
        ProfileHeaderSection(
            profileImage = if (editor.photoProfileLink.isNullOrEmpty()) painterResource(id = R.drawable.baseline_account_circle_24) else rememberImagePainter(editor.photoProfileLink),
            userName = editor.nome,
            valorHora = editor.valorHora
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Action Buttons
        ProfileActionButtons(
            navigateToHirePage = navigateToHirePage
        )

        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
fun ProfileHeaderSection(
    profileImage: Painter,
    userName: String,
    valorHora: Double
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = profileImage,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = userName, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "0", fontWeight = FontWeight.Bold, color = Color.Black)
                Text(text = "Vídeos editados", fontSize = 12.sp, color = Color.Black)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "$valorHora", fontWeight = FontWeight.Bold, color = Color.Black)
                Text(text = "Valor hora", fontSize = 12.sp, color = Color.Black)
            }
        }
    }
}

@Composable
fun ProfileActionButtons(
    navigateToHirePage: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = navigateToHirePage,
            colors = ButtonDefaults.buttonColors(Color.Blue),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Contratar", color = Color.White)
        }
    }
}

@Composable
fun ProfileDescription(
    description: List<String>
) {
    Column {
        description.forEach {
            Text(text = it, fontSize = 14.sp, color = Color.Red)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
