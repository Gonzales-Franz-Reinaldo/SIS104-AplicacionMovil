package com.example.practicasparciales.SegundoParcial

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Punto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun puntoDao(): PuntoDao
}