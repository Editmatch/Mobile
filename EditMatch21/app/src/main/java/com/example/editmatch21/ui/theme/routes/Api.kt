package sptech.projeto08c

import com.example.editmatch21.ui.theme.entities.UsuarioLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    /*
    Para que possamos usar o Retrofit com Coroutines:
    1 - As funções de mapeamento dos EndPoints devem ser "suspend"
    2 - O retorno das funções deve ser Response<???>
     */
    @POST("/login")
    suspend fun post(@Body login:UsuarioLogin): Response<UsuarioLogin>

}