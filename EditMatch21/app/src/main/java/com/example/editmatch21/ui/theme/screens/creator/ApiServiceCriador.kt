package com.example.editmatch21.ui.theme.screens.creator

import com.example.editmatch21.ui.theme.screens.editor.ApiEditor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceCriador {
    val BASE_URL = "http://52.6.25.134/api"

    fun getCriadorService(): ApiCriador {
        val criador =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiCriador::class.java)
        return criador
    }
}