package com.example.proyectokotlin.wsSIS104borrar

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {
    @GET("products")
    fun getAllProducts(): Call<List<Product>>

    @GET("products/{id}")
    fun getProductById(@Path("id") productId: Int): Call<Product>

    @POST("products")
    fun createProduct(@Body product: Product): Call<Product>

    @PATCH("products/{id}")
    fun updateProduct(@Path("id") productId: Int, @Body product: Product): Call<Product>

    @DELETE("products/{id}")
    fun deleteProduct(@Path("id") productId: Int):Call<Void>
}