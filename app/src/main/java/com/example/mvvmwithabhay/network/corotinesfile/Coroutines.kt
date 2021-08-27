package com.example.mvvmwithabhay.network.corotinesfile

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Coroutines {
    fun mainfun(work: suspend (() -> Unit)) = CoroutineScope(Dispatchers.Main).launch {
        work()
    }
}