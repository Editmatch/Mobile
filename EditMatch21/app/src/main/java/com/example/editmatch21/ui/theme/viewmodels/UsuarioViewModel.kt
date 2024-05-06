package com.example.editmatch21.ui.theme.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.editmatch21.ui.theme.entities.UsuarioLogin
import com.example.editmatch21.ui.theme.entities.UsuarioRegister
import com.example.editmatch21.ui.theme.retrofit.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel:ViewModel() {
    val erroApi = MutableLiveData<String>()
    private val api = RetrofitService.get()

    fun login(usuarioLogin: UsuarioLogin) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.post(usuarioLogin)
                if (response.isSuccessful) {
                    erroApi.postValue("")
                } else {
                    erroApi.postValue(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                erroApi.postValue(e.message)
            }
        }
    }

    fun register(usuarioRegister: UsuarioRegister) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.register(usuarioRegister)
                if (response.isSuccessful) {
                    erroApi.postValue("")
                } else {
                    erroApi.postValue(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                erroApi.postValue(e.message)
            }
        }
    }
}