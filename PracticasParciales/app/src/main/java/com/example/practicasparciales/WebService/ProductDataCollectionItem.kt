package com.example.practicasparciales.WebService

import android.media.Rating

data class ProductDataCollectionItem(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
)



