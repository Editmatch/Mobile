package com.example.editmatch21.ui.theme.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.editmatch21.ui.theme.entities.Editores
import com.example.editmatch21.ui.theme.retrofit.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditoresViewModel : ViewModel() {
    val erroApi = MutableLiveData<String>()
    private val api = RetrofitService.get()

    val editores = MutableLiveData<List<Editores>>()
    val editor = MutableLiveData<Editores>();
    val isLoading = MutableLiveData<Boolean>()

    fun getEditores() {
        isLoading.postValue(true)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d("EditoresViewModel", "Chamando a API")
                val response = api.listarEditores()
                if (response.isSuccessful) {
                    Log.d("EditoresViewModel", "Resposta da API recebida com sucesso")
                    editores.postValue(response.body())
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("EditoresViewModel", "Erro na resposta da API: $errorBody")
                    erroApi.postValue(errorBody)
                }
            } catch (e: Exception) {
                Log.e("EditoresViewModel", "Exceção na chamada da API: ${e.message}", e)
                erroApi.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }

    fun getEditorById(id: Int) {
        isLoading.postValue(true)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                Log.d("EditoresViewModel", "Chamando a API")
                val response = api.editorDetail(id)
                if (response.isSuccessful) {
                    Log.d("EditoresViewModel", "Resposta da API recebida com sucesso")
                    editor.postValue(response.body());
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("EditoresViewModel", "Erro na resposta da API: $errorBody")
                    erroApi.postValue(errorBody)
                }
            } catch (e: Exception) {
                Log.e("EditoresViewModel", "Exceção na chamada da API: ${e.message}", e)
                erroApi.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }
}
