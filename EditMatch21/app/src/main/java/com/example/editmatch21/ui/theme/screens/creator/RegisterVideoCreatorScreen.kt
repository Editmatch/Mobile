package com.example.editmatch21.ui.theme.screens.creator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.editmatch21.ui.theme.composables.ButtonLoginCadastro
import com.example.editmatch21.ui.theme.composables.InfoInput
import com.example.editmatch21.ui.theme.composables.Redirecionamento
import com.example.editmatch21.ui.theme.composables.TextoDescritivo

@Composable
fun RegisterVideoCreatorScreen(
    navigateToLogin: () -> Unit,
) {
    val nome = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    val confirmarSenha = remember { mutableStateOf("") }

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
            TextoDescritivo(texto = "Cadastro de Criador de Vídeo")

            InfoInput(
                value = nome.value,
                onValueChange = {nome.value = it},
                textoLabel = "Nome",
                textoPlaceholder = "Edit Match"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = email.value,
                onValueChange = {email.value = it},
                textoLabel = "E-mail",
                textoPlaceholder = "exemplo@email.com"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = senha.value,
                onValueChange = {senha.value = it},
                textoLabel = "Senha",
                textoPlaceholder = "Digite a senha"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = confirmarSenha.value,
                onValueChange = {confirmarSenha.value = it},
                textoLabel = "Confirmar sneha",
                textoPlaceholder = "Digite a senha novamente"
            )

            Spacer(modifier = Modifier.height(16.dp))

            Redirecionamento(
                onClick = { navigateToLogin() },
                textoPergunta = "Já possui conta?",
                textoAction = "Entrar"
            )

            Spacer(modifier = Modifier.height(16.dp))

            ButtonLoginCadastro(onClick = { }, texto = "Cadastrar")
        }
    }
}