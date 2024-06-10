package com.example.editmatch21.ui.theme.viewmodels

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.editmatch21.ui.theme.retrofit.RetrofitService
import com.example.editmatch21.ui.theme.routes.ProjectData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class UploadViewModel : ViewModel() {
    private val _uploadStatus = MutableLiveData<String>()
    val uploadStatus: LiveData<String> = _uploadStatus

    private val _uploadError = MutableLiveData<String>()
    val uploadError: LiveData<String> = _uploadError

    private val _videoLink = MutableLiveData<String>()
    val videoLink: LiveData<String> = _videoLink

    private val apiService = RetrofitService.get()

    fun uploadVideo(uri: Uri, file: File) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d("UploadViewModel", "Iniciando upload de vídeo: ${file.name}")
                val requestFile = file.asRequestBody("video/*".toMediaTypeOrNull())
                val body = MultipartBody.Part.createFormData("file", file.name, requestFile)
                val response = apiService.uploadVideo(body)

                if (response.isSuccessful) {
                    Log.d("UploadViewModel", "Upload bem-sucedido")
                    _videoLink.postValue(response.body()?.link)
                } else {
                    Log.e("UploadViewModel", "Erro no upload: ${response.message()}")
                    _uploadError.postValue("Erro no upload: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("UploadViewModel", "Exceção durante o upload", e)
                _uploadError.postValue("Erro: ${e.message}")
            }
        }
    }

    fun sendProjectData(userId: String, tituloProjeto: String, descricaoProjeto: String, skillsProjeto: List<String>, videoLink: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d("UploadViewModel", "Enviando dados do projeto: $tituloProjeto")
                val data = ProjectData(userId.toInt(), tituloProjeto, descricaoProjeto, skillsProjeto, videoLink)
                val response = apiService.sendProjectData(data)

                if (response.isSuccessful) {
                    Log.d("UploadViewModel", "Projeto enviado com sucesso")
                    _uploadStatus.postValue("Projeto enviado com sucesso!")
                } else {
                    Log.e("UploadViewModel", "Erro ao enviar projeto: ${response.message()}")
                    _uploadError.postValue("Erro ao enviar projeto: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("UploadViewModel", "Exceção durante o envio do projeto", e)
                _uploadError.postValue("Erro: ${e.message}")
            }
        }
    }

    fun updateUploadError(error: String) {
        _uploadError.postValue(error)
    }
}
