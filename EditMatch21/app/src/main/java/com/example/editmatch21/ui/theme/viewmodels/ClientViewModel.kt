package com.example.editmatch21.ui.theme.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.editmatch21.ui.theme.entities.ClientRegister
import com.example.editmatch21.ui.theme.entities.EditorRegister
import com.example.editmatch21.ui.theme.entities.Editores
import com.example.editmatch21.ui.theme.retrofit.RetrofitService
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClientViewModel : ViewModel() {
    val erroApi = MutableLiveData<String>()
    private val api = RetrofitService.get()
    val registroBemSucedido = MutableLiveData<Boolean>()

    fun registerClient(clientRegister: ClientRegister) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val jsonEditorRegister = Gson().toJson(clientRegister)
                Log.d("RegisterVideoEditorScreen", "Dados enviados: $jsonEditorRegister")
                val response = api.registerClient(clientRegister)
                Log.d("RegisterVideoEditorScreen", "Resposta da API: ${response.code()} ${response.message()} ${response.errorBody()?.string()}")
                if (response.isSuccessful) {
                    erroApi.postValue("")
                    registroBemSucedido.postValue(true)
                } else {
                    erroApi.postValue(response.errorBody()?.string())
                    registroBemSucedido.postValue(false)
                }
            } catch (e: Exception) {
                Log.e("RegisterVideoEditorScreen", "Exceção capturada: $e")
                erroApi.postValue(e.message)
            }
        }
    }


}
