package com.example.mvvmwithabhay.network.viewmodel

import com.example.mvvmwithabhay.network.apiwork.CommonRequest
import com.example.mvvmwithabhay.network.apiwork.WebService
import com.google.gson.JsonElement


class Repositery : CommonRequest() {


    suspend fun getData(url: String): JsonElement {
        return handleRequest {
            WebService().api.getData(url)
        }
    }


}