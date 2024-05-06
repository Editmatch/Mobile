package com.example.editmatch21.ui.theme.screens.creator

import com.example.editmatch21.ui.theme.screens.editor.Editor
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiCriador {
    @POST("/clientes")
    suspend fun post(@Body novoCriador: Criador): Response<Criador>
}