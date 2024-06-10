package com.example.editmatch21.ui.theme.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.editmatch21.ui.theme.entities.UsuarioLogin
import com.example.editmatch21.ui.theme.entities.UsuarioRegister
import com.example.editmatch21.ui.theme.retrofit.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsuarioViewModel: ViewModel() {
    val erroApi = MutableLiveData<String>()
    private val api = RetrofitService.get()

    val loginResult = MutableLiveData<Boolean>()
    val userId = MutableLiveData<String?>()

    fun login(usuarioLogin: UsuarioLogin) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.post(usuarioLogin)
                if (response.isSuccessful) {
                    erroApi.postValue("")
                    val user = response.body()
                    userId.postValue(user?.userId)
                    loginResult.postValue(true)
                } else {
                    erroApi.postValue(response.errorBody()?.string())
                    loginResult.postValue(false)
                }
            } catch (e: Exception) {
                erroApi.postValue(e.message)
                loginResult.postValue(false)
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
