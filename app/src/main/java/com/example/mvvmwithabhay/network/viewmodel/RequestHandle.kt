package com.example.mvvmwithabhay.network.viewmodel

import com.example.mvvmwithabhay.network.Status

data class RequestHandle<out T>(val status: Status, val message: String?, val data: T?) {

    companion object {
        fun <T> success(apiEndurl: String, data: T?): RequestHandle<T> {
            return RequestHandle(Status.SUCCESS, apiEndurl, data)
        }

        fun <T> error(apiEndurl: String, data: T?): RequestHandle<T> {
            return RequestHandle(Status.ERROR, apiEndurl, data)
        }

        fun <T> loading(data: T?): RequestHandle<T> {
            return RequestHandle(Status.LOADING, "loading", data)
        }

    }

}