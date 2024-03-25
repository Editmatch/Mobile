package com.example.editmatch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.editmatch.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    navigateToProjects: () -> Unit,
    navigateToProfile: () -> Unit,
    navigateToDetails: (String) -> Unit // Adiciona uma função de navegação para os detalhes do projeto
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Header()

        // Linha com opções de navegação
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(
                onClick = { /* Navegar para a página inicial */ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Página Inicial", style = TextStyle(fontSize = 16.sp))
            }
            TextButton(
                onClick = { navigateToProjects() },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Projetos", style = TextStyle(fontSize = 16.sp))
            }
            TextButton(
                onClick = { navigateToProfile() },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Perfil", style = TextStyle(fontSize = 16.sp))
            }
        }

        // Carrossel de projetos (mocado)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Projetos",
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        ProjectCarousel(navigateToDetails) // Passa a função de navegação para o carrossel de projetos
    }
}

@Composable
fun Header() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Logo
        Box(
            modifier = Modifier
                .size(78.dp)
                .background(Color.White)
        ){
            Image(
                painter = painterResource(id = R.mipmap.logo), // Substitua R.drawable.logo pela referência à sua imagem de logo
                contentDescription = "Logo",
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Campo de busca
        OutlinedTextField(
            value = TextFieldValue(),
            onValueChange = { /* Atualize o estado do valor do campo de busca */ },
            placeholder = { Text("Buscar projetos") },
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Botão de busca
        Image(
            painter = painterResource(id = R.mipmap.search),
            contentDescription = "Procurar",
            Modifier
                .clickable { }
                .size(28.dp)
        )
    }
}

@Composable
fun ProjectCarousel(navigateToDetails: (String) -> Unit) {
    val projects = listOf("Projeto 1", "Projeto 2", "Projeto 3", "Projeto 4", "Projeto 5")

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(projects) { project ->
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .clickable { navigateToDetails(project) } // Torna o item clicável
            ) {

                Image(
                    painter = painterResource(id = R.mipmap.instagram ),
                    contentDescription = "Capa do vídeo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

