package com.example.practicasparciales.SegundoParcial

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "puntos")
data class Punto(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var x1: Double,
    var y1: Double,
    var x2: Double,
    var y2: Double,
    val distancia: Double
)