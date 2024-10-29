package com.example.practicasparciales.WebService

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicasparciales.R

class ProductAdapter(private val productList : List<ProductDataCollectionItem>) :
    RecyclerView.Adapter<ProductAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idTextView: TextView = itemView.findViewById(R.id.textViewProductId)
        val titleTextView: TextView = itemView.findViewById(R.id.textViewProductTitle)
        val priceTextView: TextView = itemView.findViewById(R.id.textViewProductPrice)
        val descriptionTextView: TextView = itemView.findViewById(R.id.textViewProductDescription)
        val categoryTextView: TextView = itemView.findViewById(R.id.textViewProductCategory)
        val imageTextView: TextView = itemView.findViewById(R.id.textViewProductImage)
        val ratingTextView: TextView = itemView.findViewById(R.id.textViewProductRating)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return AlbumViewHolder(view)
    }

    // ProductAdapter.kt
    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = productList[position]
        holder.idTextView.text = "ID: ${album.id}"
        holder.titleTextView.text = "Title: ${album.title}"
        holder.priceTextView.text = "Price: ${album.price}"
        holder.descriptionTextView.text = "Description: ${album.description}"
        holder.categoryTextView.text = "Category: ${album.category}"
        holder.imageTextView.text = "Image URL: ${album.image}"
//        holder.ratingTextView.text = "Rating: ${album.rating.rate} (${album.rating.count} reviews)"
    }


    override fun getItemCount() = productList.size
}