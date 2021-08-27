package com.example.mvvmwithabhay.network.apiwork

import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class CommonRequest {
    suspend fun <T> handleRequest(call: suspend () -> Response<T>): T {
        var response = call.invoke()

        if (response.isSuccessful) {
            return response.body()!!
        } else {
            var error = response.errorBody()?.string()
            var message = StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                } catch (e: JSONException) {
                }
                message.append("\n")
            }
            throw ApiException(message.toString())
        }
    }
}




