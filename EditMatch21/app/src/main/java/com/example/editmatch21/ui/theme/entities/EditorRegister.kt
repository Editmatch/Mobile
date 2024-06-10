package com.example.editmatch21.ui.theme.entities

import java.time.LocalDate
import java.time.LocalDateTime

data class EditorRegister(
    var id: Int? = null,
    var name: String,
    var last_name: String,
    var rg: String? = null,
    var cpf: String? = null,
    var birth: LocalDate? = null,
    var gender: Int? = null,
    var desc_profile: String? = null,
    var dataEntrega: LocalDate? = null,
    var valorHora: Double,
    var chavePix: String,
    var created_at: LocalDateTime? = null,
    var updated_at: LocalDateTime? = null,
    var isEditor: Boolean,
    var email: String,
    var password: String,
    var photoProfileLink: String? = null,
    var skills: String? = null
)
