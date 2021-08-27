package com.example.mvvmwithabhay.network.apiwork

import com.google.gson.GsonBuilder
import com.rv.user.chatkort.commonthing.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WebService {

    var api: Api

    init {
        val okHttpClient = OkHttpClient().newBuilder()
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
        val gson = GsonBuilder().setLenient().create()
        var retrofit = Retrofit.Builder().baseUrl(AppConstants.BASEURL)
            .addConverterFactory(
                GsonConverterFactory.create(gson)
            ).client(okHttpClient).build()
        api = retrofit.create(Api::class.java)
    }
}