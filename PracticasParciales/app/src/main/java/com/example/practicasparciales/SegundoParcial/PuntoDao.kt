package com.example.practicasparciales.SegundoParcial

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PuntoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarPuntos(puntos: List<Punto>)

    @Query("SELECT * FROM puntos")
    suspend fun obtenerPuntos(): List<Punto>
}
