package com.example.editmatch21.ui.theme.entities

data class UsuarioLogin(
    var email: String,
    var senha: String,
    val userId: String? = null // Adiciona a propriedade id
)
