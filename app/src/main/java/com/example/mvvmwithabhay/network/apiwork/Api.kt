package com.example.mvvmwithabhay.network.apiwork

import com.google.gson.JsonElement
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface Api {


    @GET
    @Headers("Accept: application/json")
   suspend fun getData(
        @Url url: String
    ): Response<JsonElement>

}