package com.example.editmatch21.ui.theme.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.editmatch21.ui.theme.routes.Api

object RetrofitService {

    const val BASE_URL = "https://editmatch.ddns.net/api/"

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