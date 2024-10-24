package com.example.proyectokotlin.basedatos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DAOLugar {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertarLugar(lugar: Lugar)
    @Query("SELECT * FROM lugares")
    suspend fun obtenerLugares(): MutableList<Lugar>

    @Query("UPDATE lugares SET nombre = :nombre, descripcion = :descripcion, latitud = :latitud, longitud = :longitud WHERE id = :id")
    suspend fun actualizarLugar(id: Int, nombre: String, descripcion: String, latitud: Double, longitud: Double)

    @Delete
    suspend fun borrarLugar(lugar: Lugar)

}