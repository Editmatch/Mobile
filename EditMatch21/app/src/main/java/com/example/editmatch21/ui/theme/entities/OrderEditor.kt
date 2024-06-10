package com.example.editmatch21.ui.theme.entities

import com.google.gson.Gson
import java.io.Serializable

val gson = Gson()

data class OrderEditor(
    var nome: String,
    var title: String,
    var desc: String,
    var skills: String,
    var status: String,
    var link: String,
    var orderId: Int,
    var editorId: Int,
): Serializable
