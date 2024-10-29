package com.example.practicasparciales.baseDatosSQLite

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personas")
data class Persona(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var nombre: String = "",
    var apellido: String = "",
    var edad: Int,
    var sexo: String = ""
)