package com.example.editmatch21.ui.theme.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.editmatch21.R
import com.example.editmatch21.ui.theme.composables.ButtonLoginCadastro
import com.example.editmatch21.ui.theme.composables.InfoInput
import com.example.editmatch21.ui.theme.composables.LogoImage
import com.example.editmatch21.ui.theme.composables.Redirecionamento
import com.example.editmatch21.ui.theme.composables.TextoDescritivo
import com.example.editmatch21.ui.theme.entities.UsuarioLogin
import com.example.editmatch21.ui.theme.viewmodels.UsuarioViewModel

@Composable
fun LoginScreen(
    navigateToRegister: () -> Unit,
    navigateToProject: () -> Unit
) {
    val viewModel: UsuarioViewModel = viewModel()
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

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
            LogoImage(
                painter = painterResource(id = R.mipmap.logo),
                contentDescription = "Logo",
                width = 100.dp,
                height = 100.dp
            )

            Spacer(modifier = Modifier.height(36.dp))

            TextoDescritivo(texto = "Faça o login na sua conta")

            Spacer(modifier = Modifier.height(1.dp))

            InfoInput(
                value = email,
                onValueChange = { email = it },
                textoLabel = "E-mail",
                textoPlaceholder = "exemplo@email.com"
            )

            Spacer(modifier = Modifier.height(16.dp))

            InfoInput(
                value = senha,
                onValueChange = { senha = it },
                textoLabel = "Senha",
                textoPlaceholder = "Digite sua senha"
            )

            Spacer(modifier = Modifier.height(16.dp))

            Redirecionamento(
                onClick = { navigateToRegister() },
                textoPergunta = "Não possui conta?",
                textoAction = "Cadastre-se"
            )

            Spacer(modifier = Modifier.height(16.dp))

            val loginSuccessful = viewModel.loginResult.observeAsState(initial = false)
            val userId = viewModel.userId.observeAsState()

            ButtonLoginCadastro(onClick = {
                viewModel.login(UsuarioLogin(email, senha))
            }, texto = "Entrar")

            if (loginSuccessful.value) {
                userId.value?.let {
                    val context = LocalContext.current
                    val sharedPref = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
                    with(sharedPref.edit()) {
                        putString("user_id", it)
                        apply()
                    }
                    navigateToProject()
                }
            }
        }
    }
}
