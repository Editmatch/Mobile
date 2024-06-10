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
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class UploadViewModel : ViewModel() {
    private val _uploadStatus = MutableLiveData<String>()
    val uploadStatus: LiveData<String> = _uploadStatus

    private val _uploadError = MutableLiveData<String>()
    val uploadError: LiveData<String> = _uploadError

    private val _videoLink = MutableLiveData<String>()
    val videoLink: LiveData<String> = _videoLink

    private val apiService = RetrofitService.get()

    fun uploadVideo(title: String, uri: Uri, file: File) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val logMessage = "Iniciando upload de vídeo: ${file.name}"
                Log.d("UploadViewModel", logMessage)
                _uploadStatus.postValue(logMessage)

                // Criar RequestBody para o título
                val titlePart = title.toRequestBody("text/plain".toMediaTypeOrNull())

                // Criar RequestBody para o arquivo
                val requestFile = file.asRequestBody("video/*".toMediaTypeOrNull())
                val filePart = MultipartBody.Part.createFormData("file", file.name, requestFile)

                // Enviar ambos no MultipartBody
                val response = apiService.uploadVideo(filePart, titlePart)

                if (response.isSuccessful) {
                    val successMessage = "Upload bem-sucedido"
                    Log.d("UploadViewModel", successMessage)
                    _uploadStatus.postValue(response.body()?.link ?: successMessage)
                } else {
                    val errorMessage = "Erro no upload: ${response.message()}"
                    Log.e("UploadViewModel", errorMessage)
                    _uploadError.postValue(errorMessage)
                }
            } catch (e: Exception) {
                val exceptionMessage = "Exceção durante o upload: ${e.message}"
                Log.e("UploadViewModel", exceptionMessage)
                _uploadError.postValue(exceptionMessage)
            }
        }
    }



    fun sendProjectData(userId: String, tituloProjeto: String, descricaoProjeto: String, skillsProjeto: List<String>, videoLink: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val logMessage = "Enviando dados do projeto: $tituloProjeto"
                Log.d("UploadViewModel", logMessage)
                _uploadStatus.postValue(logMessage)
                val data = ProjectData(userId.toInt(), tituloProjeto, descricaoProjeto, skillsProjeto, videoLink)
                val response = apiService.sendProjectData(data)

                if (response.isSuccessful) {
                    val successMessage = "Projeto enviado com sucesso"
                    Log.d("UploadViewModel", successMessage)
                    _uploadStatus.postValue(successMessage)
                } else {
                    val errorMessage = "Erro ao enviar projeto: ${response.message()}"
                    Log.e("UploadViewModel", errorMessage)
                    _uploadError.postValue(errorMessage)
                }
            } catch (e: Exception) {
                val exceptionMessage = "Exceção durante o envio do projeto: ${e.message}"
                Log.e("UploadViewModel", exceptionMessage)
                _uploadError.postValue(exceptionMessage)
            }
        }
    }

    fun updateUploadError(error: String) {
        _uploadError.postValue(error)
    }
}
