package com.example.proyectokotlin.RxBorrar

data class Publicacions(
    val id_publicacion: Int,
    val id_usuario: Int,
    val id_mascota: Int,
    val titulo: String,
    val descripcion: String,
    val tipo_publicacion: String,
    val fecha_publicacion: String,  // Puedes usar String si el formato es "yyyy-MM-dd" o usar `Date` si prefieres
    val estado: String
)
