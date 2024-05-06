package com.example.editmatch21.ui.theme.screens.editor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.editmatch21.ui.theme.composables.ButtonLoginCadastro
import com.example.editmatch21.ui.theme.composables.InfoInput
import com.example.editmatch21.ui.theme.composables.Redirecionamento
import com.example.editmatch21.ui.theme.composables.TextoDescritivo
import com.example.editmatch21.ui.theme.entities.UsuarioRegister
import com.example.editmatch21.ui.theme.viewmodels.UsuarioViewModel

@Composable
fun RegisterVideoEditorScreen(
    navigateToLogin: () -> Unit
) {
    val usuarioViewModel: UsuarioViewModel = viewModel()

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var chavePix by remember { mutableStateOf("") }

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
            TextoDescritivo(texto = "Cadastro de Editor de Vídeo")

            InfoInput(
                value = nome,
                onValueChange = { nome = it },
                textoLabel = "Nome",
                textoPlaceholder = "Edit Match"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = email,
                onValueChange = { email = it },
                textoLabel = "E-mail",
                textoPlaceholder = "exemplo@email.com"
            )
    // Cria uma instância do ViewModel

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = senha,
                onValueChange = { senha = it },
                textoLabel = "Senha",
                textoPlaceholder = "Digite a senha"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = confirmarSenha,
                onValueChange = { confirmarSenha = it },
                textoLabel = "Confirmar senha",
                textoPlaceholder = "Digite a senha novamente"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = chavePix,
                onValueChange = { chavePix = it },
                textoLabel = "Chave Pix",
                textoPlaceholder = "Digite a chave pix"
            )

            Spacer(modifier = Modifier.height(16.dp))

            Redirecionamento(
                onClick = { navigateToLogin() },
                textoPergunta = "Já possui conta?",
                textoAction = "Entrar"
            )

            Spacer(modifier = Modifier.height(16.dp))

            ButtonLoginCadastro(onClick = {
                if (senha == confirmarSenha) {
                    val usuarioRegister = UsuarioRegister(nome, email, senha)
                    usuarioViewModel.register(usuarioRegister)
                } else {
                    println("A senha e a confirmação da senha não são iguais")
                }
            }, texto = "Cadastrar")
        }
    }
}
