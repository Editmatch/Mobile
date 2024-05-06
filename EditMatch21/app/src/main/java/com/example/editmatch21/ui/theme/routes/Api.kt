package com.example.editmatch21.ui.theme.routes

import com.example.editmatch21.ui.theme.entities.UsuarioLogin
import com.example.editmatch21.ui.theme.entities.UsuarioRegister
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {
    /*
    Para que possamos usar o Retrofit com Coroutines:
    1 - As funções de mapeamento dos EndPoints devem ser "suspend"
    2 - O retorno das funções deve ser Response<???>
     */
    @Headers("Content-Type: application/json")
    @POST("usuarios/login")
    suspend fun post(@Body login:UsuarioLogin): Response<UsuarioLogin>

    @POST("usuarios/cadastro")
    suspend fun register(@Body login:UsuarioRegister): Response<UsuarioRegister>

}