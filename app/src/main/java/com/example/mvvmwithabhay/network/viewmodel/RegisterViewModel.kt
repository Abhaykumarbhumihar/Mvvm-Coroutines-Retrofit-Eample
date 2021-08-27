package com.example.mvvmwithabhay.network.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmwithabhay.network.apiwork.ApiException
import com.example.mvvmwithabhay.network.corotinesfile.Coroutines


class RegisterViewModel : ViewModel() {
     val uiState = MutableLiveData<RequestHandle<String>>()

    fun postData(url: String): LiveData<RequestHandle<String>> {
        Coroutines.mainfun {
            uiState.value = RequestHandle.loading("loading")
            try {
                var response = Repositery().getData(url)
                response.let {
                    uiState.value = RequestHandle.success(url, it.toString())
                }
            } catch (e: ApiException) {
                uiState.value = RequestHandle.error(url, e.message!!)
            }
        }
        return uiState
    }
}