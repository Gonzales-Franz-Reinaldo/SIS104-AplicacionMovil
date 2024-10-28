package com.example.proyectokotlin.wsSIS104borrar

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://192.168.1.3:3000"  // Cambia a la URL de tu API

    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    val api: APIService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client) // Usa el cliente que tiene el interceptor
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}