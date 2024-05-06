package com.example.editmatch21.ui.theme.screens.editor

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditorViewModel: ViewModel() {
    private val _editorCriado = MutableLiveData<Boolean>()
    val editorCriado: LiveData<Boolean>
        get() = _editorCriado

    val erroApi = MutableLiveData("")
    private val apiEditor = ApiService.getEditorService()

    fun criar(novoEditor: Editor) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val post = apiEditor.post(novoEditor)
                if (post.isSuccessful) {
                    _editorCriado.postValue(true) // Indica que o editor foi criado com sucesso
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