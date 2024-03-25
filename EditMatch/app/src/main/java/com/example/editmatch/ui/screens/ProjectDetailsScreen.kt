package com.example.editmatch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.editmatch.R

@Composable
fun ProjectDetailsScreen(projectName: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Nome do projeto
        Text(
            text = projectName,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Imagem do projeto
        Image(
            painter = painterResource(id = R.mipmap.instagram),
            contentDescription = "Capa do vídeo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        // Preço sugerido
        Text(
            text = "Preço sugerido: R$ 10,00",
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Informações do vídeo
        Text(
            text = "Informações do vídeo:",
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = 4.dp)
        )

        // Duração do vídeo
        Text(
            text = "Duração: 10 minutos",
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.padding(bottom = 4.dp)
        )

        // Trilha sonora
        Text(
            text = "Trilha sonora: Nome da trilha",
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.padding(bottom = 4.dp)
        )

        // Mais informações
        Text(
            text = "Mais informações:",
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = 4.dp)
        )

        // Informações adicionais sobre o projeto
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit, vestibulum vel, faucibus id, pulvinar vitae, ipsum.",
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}