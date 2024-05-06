package com.example.editmatch21.ui.theme.screens.editor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val BASE_URL = "http://52.6.25.134/api"

    fun getEditorService(): ApiEditor {
        val editor =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiEditor::class.java)
        return editor
    }
}