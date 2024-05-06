package com.example.editmatch21.ui.theme.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.editmatch21.ui.theme.entities.OrderEditor
import com.example.editmatch21.ui.theme.retrofit.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrderViewModel:ViewModel() {
    val erroApi = MutableLiveData<String>()
    private val api = RetrofitService.get()

    val orders = MutableLiveData<List<OrderEditor>>()

    fun getOrders() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.orders()
                if (response.isSuccessful) {
                    orders.postValue(response.body())
                } else {
                    erroApi.postValue(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                erroApi.postValue(e.message)
            }
        }
    }

}