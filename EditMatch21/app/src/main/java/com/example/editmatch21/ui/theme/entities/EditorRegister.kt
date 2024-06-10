package com.example.editmatch21.ui.theme.entities

data class EditorRegister(
    var name: String,
    var last_name: String,
    var email: String,
    var password: String,
    var chavePix: String?,
    var skills: List<String>,
    var valorHora: Double?,
    var isEditor: Boolean = true,
)
