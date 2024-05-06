package com.example.editmatch21.ui.theme.screens.creator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.editmatch21.ui.theme.screens.editor.ApiService
import com.example.editmatch21.ui.theme.screens.editor.Editor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CriadorViewModel: ViewModel() {
    private val _criadorCriado = MutableLiveData<Boolean>()
    val criadorCriado: LiveData<Boolean>
        get() = _criadorCriado

    val erroApi = MutableLiveData("")
    private val apiCriador = ApiServiceCriador.getCriadorService()

    fun criar(novoCriador: Criador) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val post = apiCriador.post(novoCriador)
                if (post.isSuccessful) {
                    _criadorCriado.postValue(true) // Indica que o editor foi criado com sucesso
                    erroApi.postValue("")
                } else {
                    erroApi.postValue(post.errorBody()?.string() ?: "Erro ao criar editor")
                }
            } catch (e: Exception) {
                Log.e("api", "Falha ao criar! ${e.message}")
                erroApi.postValue(e.message)
            }
        }
    }
}
