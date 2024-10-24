package com.example.proyectokotlin.basedatos

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Lugar::class], version = 1, exportSchema = false)

abstract class BaseDatos : RoomDatabase() {
    abstract fun daoLugar(): DAOLugar
}