package com.example.practicasparciales.WebService

//com.squareup.picasso:picasso
//
//io.reactivex.rxjava3:rxjava
//io.reactivex.rxjava3:rxandroid
//com.squareup.retrofit2:adapter-rxjava3
//
//com.squareup.retrofit2:retrofit
//com.squareup.retrofit2:converter-gson
//com.squareup.okhttp3:okhttp
//com.squareup.okhttp3:logging-interceptor

import retrofit2.http.GET
import retrofit2.Call


interface APIServices {
    @GET("products")

    fun listProducts() : Call<List<ProductDataCollectionItem>>
}