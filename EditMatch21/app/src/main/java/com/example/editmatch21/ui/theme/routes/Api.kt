package com.example.editmatch21.ui.theme.routes

import com.example.editmatch21.ui.theme.entities.ClientRegister
import com.example.editmatch21.ui.theme.entities.EditorRegister
import com.example.editmatch21.ui.theme.entities.Editores
import com.example.editmatch21.ui.theme.entities.OrderDetailsClient
import com.example.editmatch21.ui.theme.entities.OrderDetailsEditor
import com.example.editmatch21.ui.theme.entities.OrderEditor
import com.example.editmatch21.ui.theme.entities.UsuarioLogin
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @Headers("Content-Type: application/json")
    @POST("usuarios/login")
    suspend fun post(@Body login: UsuarioLogin): Response<UsuarioLogin>

    @GET("usuarios/listar-editor")
    suspend fun listarEditores(): Response<List<Editores>>

    @Headers("Content-Type: application/json")
    @POST("editores")
    suspend fun registerEditor(@Body editor: EditorRegister): Response<EditorRegister>

    @Headers("Content-Type: application/json")
    @POST("clientes")
    suspend fun registerClient(@Body client: ClientRegister): Response<ClientRegister>

    @Multipart
    @POST("s3/storage")
    suspend fun uploadVideo(
        @Part file: MultipartBody.Part,
        @Part("title") title: RequestBody
    ): Response<ResponseBody>


    @POST("orders")
    suspend fun sendProjectData(@Body data: ProjectData): Response<Void>

    @GET("orders/{id}")
    suspend fun getOrderById(@Path("id") id:Int): Response<OrderDetailsClient>

    @GET("editores/{id}")
    suspend fun editorDetail(@Path("id") id: Int): Response<Editores>

    @GET("orders/disponivel")
    suspend fun orders(): Response<List<OrderEditor>>

    @GET("orders/{id}")
    suspend fun orderDetail(@Path("id") id: Int): Response<OrderDetailsEditor>
}

data class UploadResponse(
    val link: String
)

data class ProjectData(
    val clientFinal: Int,
    val title: String,
    val Describle: String,
    val skills: List<String>,
    val link: String
)