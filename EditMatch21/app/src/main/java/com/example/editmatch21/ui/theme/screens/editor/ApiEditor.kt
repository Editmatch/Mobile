package com.example.editmatch21.ui.theme.screens.editor

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

// Aqui fica os ENDPOINTS
interface ApiEditor {

    @POST("/editores")
    suspend fun post(@Body novoEditor: Editor): Response<Editor>


}