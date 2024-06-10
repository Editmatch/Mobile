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

    private val _projectStatus = MutableLiveData<String>()
    val projectStatus: LiveData<String> = _projectStatus

    private val _videoLink = MutableLiveData<String>()
    val videoLink: LiveData<String> = _videoLink

    private val apiService = RetrofitService.get()

    fun uploadVideo(title: String, uri: Uri, file: File) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val titlePart = title.toRequestBody("text/plain".toMediaTypeOrNull())
                val requestFile = file.asRequestBody("video/*".toMediaTypeOrNull())
                val filePart = MultipartBody.Part.createFormData("file", file.name, requestFile)

                val response = apiService.uploadVideo(filePart, titlePart)

                if (response.isSuccessful) {
                    val videoLink = response.body()?.string() ?: ""
                    _uploadStatus.postValue(videoLink)
                    _videoLink.postValue(videoLink)
                } else {
                    val errorMessage = "Erro no upload: ${response.message()}"
                    _uploadError.postValue(errorMessage)
                }
            } catch (e: Exception) {
                val exceptionMessage = "Exceção durante o upload: ${e.message}"
                _uploadError.postValue(exceptionMessage)
            }
        }
    }

    fun sendProjectData(userId: String, tituloProjeto: String, descricaoProjeto: String, skillsProjeto: List<String>, videoLink: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = ProjectData(userId.toInt(), tituloProjeto, descricaoProjeto, skillsProjeto, videoLink)
                val response = apiService.sendProjectData(data)

                if (response.isSuccessful) {
                    val successMessage = "Projeto enviado com sucesso"
                    _projectStatus.postValue(successMessage)
                } else {
                    val errorMessage = "Erro ao enviar projeto: ${response.message()}"
                    _uploadError.postValue(errorMessage)
                }
            } catch (e: Exception) {
                val exceptionMessage = "Exceção durante o envio do projeto: ${e.message}"
                _uploadError.postValue(exceptionMessage)
            }
        }
    }

    fun updateUploadError(error: String) {
        _uploadError.postValue(error)
    }
}
