package com.example.myapplication.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class NetworkUtils  @Inject constructor(private val context: Context) {

    @SuppressLint("ServiceCast")
    fun isNetworkConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo?.isConnected == true
    }
}