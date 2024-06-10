package com.example.editmatch21.ui.theme.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.Button
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
import com.example.editmatch21.ui.theme.entities.Editores
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberImagePainter

@Composable
fun ProfileHeader(navigateToEditProfile: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Fernando Silva",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black),
        )
        Spacer(modifier = Modifier.size(10.dp))
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(94.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = "Sou um editor com experiências em vídeos curtos ",
            style = TextStyle(fontSize = 16.sp, color = Color.Black),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(15.dp))
        Divider(modifier = Modifier.fillMaxWidth())
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = editor.nome, color = Color.Red)
            if (editor.photoProfileLink.isNullOrEmpty()) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_view_module_24),
                    contentDescription = "menu"
                )
            } else {
                Image(
                    painter = rememberImagePainter(editor.photoProfileLink),
                    contentDescription = null,
                    modifier = Modifier.size(128.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.size(15.dp))

        Text(text = "Valor Hora:", style = TextStyle(color = Color.Red))
        Text(text = "R$ ${editor.valorHora}", style = TextStyle(color = Color.Red))

        Spacer(modifier = Modifier.size(15.dp))

        Button(onClick = navigateToHirePage) {
            Text(text = "Contratar", color = Color.White)
        }

        Spacer(modifier = Modifier.size(15.dp))

        LinhaDivider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.size(15.dp))
    }
}
