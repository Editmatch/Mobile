package com.example.editmatch21.ui.theme.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.editmatch21.ui.theme.entities.OrderDetailsClient
import com.example.editmatch21.ui.theme.entities.OrderDetailsEditor
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

    val orderDetail = MutableLiveData<OrderDetailsEditor>()
    fun getOrderDetail(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.orderDetail(id)
                if (response.isSuccessful) {
                    orderDetail.postValue(response.body())
                } else {
                    erroApi.postValue(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                erroApi.postValue(e.message)
            }
        }
    }

    val orderById = MutableLiveData<OrderDetailsClient>()
    fun getOrderById(id: Int){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.getOrderById(id)
                if (response.isSuccessful) {
                    orderById.postValue(response.body());
                } else {
                    erroApi.postValue(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                erroApi.postValue(e.message)
            }
        }
    }
}