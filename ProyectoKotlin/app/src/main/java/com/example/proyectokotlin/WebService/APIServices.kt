package com.example.proyectokotlin.WebService

import retrofit2.Call
import retrofit2.http.GET

interface APIServices {
    @GET("albums")
    fun listAlbums(): Call<List<AlbumDataCollectionItem>>
}