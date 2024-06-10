package com.example.editmatch21.ui.theme.screens.editor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.editmatch21.ui.theme.composables.ButtonLoginCadastro
import com.example.editmatch21.ui.theme.composables.InfoInput
import com.example.editmatch21.ui.theme.composables.Redirecionamento
import com.example.editmatch21.ui.theme.composables.TextoDescritivo
import com.example.editmatch21.ui.theme.entities.ClientRegister
import com.example.editmatch21.ui.theme.viewmodels.ClientViewModel


@Composable
fun InfoInput(
    value: String,
    onValueChange: (String) -> Unit,
    textoLabel: String,
    textoPlaceholder: String,
    visualTransformation: VisualTransformation
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(textoLabel) },
        placeholder = { Text(textoPlaceholder) },
        visualTransformation = visualTransformation,
        modifier = Modifier.background(color = Color.White)
    )
}

@Composable
fun RegisterVideoEditorScreen(
    navigateToLogin: () -> Unit,
) {
    val nome = remember { mutableStateOf("") }
    val last_name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    val confirmarSenha = remember { mutableStateOf("") }

    val viewModel: ClientViewModel = viewModel()
    val registroBemSucedido = viewModel.registroBemSucedido.observeAsState()



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
                value = nome.value,
                onValueChange = {nome.value = it},
                textoLabel = "Nome",
                textoPlaceholder = "Nome*"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = last_name.value,
                onValueChange = {last_name.value = it},
                textoLabel = "Sobrenome",
                textoPlaceholder = "Sobrenome*"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = email.value,
                onValueChange = {email.value = it},
                textoLabel = "E-mail",
                textoPlaceholder = "E-mail*"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = senha.value,
                onValueChange = {senha.value = it},
                textoLabel = "Senha",
                textoPlaceholder = "Senha*",
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = confirmarSenha.value,
                onValueChange = {confirmarSenha.value = it},
                textoLabel = "Confirmar senha",
                textoPlaceholder = "Confirmar senha*",
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Redirecionamento(
                onClick = { navigateToLogin() },
                textoPergunta = "Já possui conta?",
                textoAction = "Entrar"
            )

            Spacer(modifier = Modifier.height(16.dp))

            ButtonLoginCadastro(onClick = {
                val skillsList = listOf<String>()
                viewModel.registerClient(ClientRegister(nome.value, last_name.value, email.value, senha.value, "11974135372", skillsList, 1.0, true))
            }, texto = "Cadastrar")

            if (registroBemSucedido.value == true) {
                Text("Registro bem-sucedido!")
                navigateToLogin()
            }else if (registroBemSucedido.value == false) {
                Text("Erro no registro!")
            }
        }
    }
}
