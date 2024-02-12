package com.example.cardinfofinder.util

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

class Networkconnectivity(c: Context) {

    fun isNetworkAvailable(c: Context): Boolean {
        val connectivityManager =
            c.getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        val s = connectivityManager.activeNetworkInfo
        if (s != null && s.isConnected) {
            Toast.makeText(c, "Network Active", Toast.LENGTH_SHORT)
                .show()
            return true
        }

        Toast.makeText(c, "No Network connection", Toast.LENGTH_SHORT)
            .show()
        return false
    }
}