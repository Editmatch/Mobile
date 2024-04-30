package com.example.editmatch21.ui.theme.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sptech.projeto08c.Api

object RetrofitService {

    const val BASE_URL = "https://localhost:8080/api"

    fun get(): Api {
        val client =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)

        return client
    }

}