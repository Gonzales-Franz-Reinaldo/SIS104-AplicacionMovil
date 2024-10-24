package com.example.proyectokotlin.WebService

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectokotlin.R

class AlbumAdapter(private val albumList: List<AlbumDataCollectionItem>) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userIdTextView: TextView = itemView.findViewById(R.id.textViewUserId)
        val idTextView: TextView = itemView.findViewById(R.id.textViewId)
        val titleTextView: TextView = itemView.findViewById(R.id.textViewUserTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_item, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albumList[position]
        holder.userIdTextView.text = "User ID: ${album.userId}"
        holder.idTextView.text = "ID: ${album.id}"
        holder.titleTextView.text = "Title: ${album.title}"
    }

    override fun getItemCount() = albumList.size
}