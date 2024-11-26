package com.example.proyectokotlin.RxBorrar

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {
//    @GET("products")
//    fun getProducts(): Observable<List<Product>>


    @GET("disponibles")
    fun getPublicaciones(): Observable<List<Publicacions>>
}