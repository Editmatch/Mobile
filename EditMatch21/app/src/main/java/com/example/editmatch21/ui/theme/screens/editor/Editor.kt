package com.example.editmatch21.ui.theme.screens.editor

import android.location.Address
import java.time.LocalDate
import java.time.LocalDateTime

data class Editor(
    var id:Int? = null,
    val nome: String = "",
    val lastName: String? = null,
    val isEditor: Boolean? = null,
    val email: String = "",
    val password: String = "",
    val descProfile: String? = null,
    val valorHora: Double? = null,
    val chavePix: String? = null,
    val skills: List<String>? = null
)

