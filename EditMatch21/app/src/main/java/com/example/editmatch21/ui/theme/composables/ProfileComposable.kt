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

@Composable
fun ProfileHeader(navigateToEditProfile: () -> Unit) {
    Spacer(modifier = Modifier.width(16.dp))
    Column {

    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.baseline_account_circle_24),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(94.dp)
                    .clip(CircleShape)
            )

            TextButton(onClick = navigateToEditProfile) {
                Text(text = "Editar perfil")
            }

        }


        Spacer(modifier = Modifier.width(20.dp))

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

@Composable
fun PortifolioProfile(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_view_module_24),
            contentDescription = "menu"
        )
    }

    Spacer(modifier = Modifier.size(15.dp))

    LinhaDivider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())

    // Conteúdo do perfil (publicações, etc.)
    // Adicione aqui o conteúdo do perfil conforme necessário
}