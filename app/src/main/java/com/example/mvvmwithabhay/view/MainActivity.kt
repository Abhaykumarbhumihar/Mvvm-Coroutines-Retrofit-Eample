package com.example.mvvmwithabhay.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmwithabhay.R
import com.example.mvvmwithabhay.network.viewmodel.RegisterViewModel
import com.example.mvvmwithabhay.network.Status

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        setupObserver()
    }

    private fun setupObserver() {
        mainViewModel.postData("entries").observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    //Show Loader
                    mainViewModel.uiState.value
                    /*TODO it.message will help you when you need to hit multiple api at same time
                    *  it will give you name of end url of api & it.data will give you api response*/
                    it.message
                    it.data?.let {
                        //hide loader
                        //TODO here you will get data of api
                        Log.w("SUCCESS", it)
                    }
                }

                Status.LOADING -> {
                    //Show Loader
                    Log.w("LOADDER", "SHOW LOADDER")
                }

                Status.ERROR -> {
                    //hide loader
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}