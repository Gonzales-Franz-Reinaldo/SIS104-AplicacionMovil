package com.example.practicasparciales.SegundoParcial

import okhttp3.OkHttpClient
import okhttp3.Request

object ApiService {

    private val client = OkHttpClient()

    fun obtenerPuntos(): String? {
        return try {
            val request = Request.Builder()
                .url("http://192.168.1.3:3000/api/puntos")
                .build()

            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    response.body?.string()
                } else {
                    null
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}