package com.example.editmatch.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterAdditionalInfoScreen(
    navigateToLogin: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Informações Adicionais",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Campo de habilidades
            OutlinedTextField(
                value = "", // Pode adicionar um estado para o valor das habilidades
                onValueChange = { /* Atualize o estado do valor das habilidades */ },
                label = { Text("Habilidades") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de chave Pix
            OutlinedTextField(
                value = "", // Pode adicionar um estado para o valor da chave Pix
                onValueChange = { /* Atualize o estado do valor da chave Pix */ },
                label = { Text("Chave Pix") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de valor da hora trabalhada
            OutlinedTextField(
                value = "", // Pode adicionar um estado para o valor da hora trabalhada
                onValueChange = { /* Atualize o estado do valor da hora trabalhada */ },
                label = { Text("Valor da Hora Trabalhada") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Texto "Já possui uma conta? Entrar"
            Text(
                text = "Já possui uma conta? Entrar",
                color = Color.Black,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { navigateToLogin() }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão de cadastrar
            Button(
                onClick = { navigateToLogin() }, // Aqui você pode adicionar lógica para o cadastro
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Cadastrar")
            }
        }
    }
}