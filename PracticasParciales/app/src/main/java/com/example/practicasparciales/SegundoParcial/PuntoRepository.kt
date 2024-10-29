package com.example.practicasparciales.SegundoParcial

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PuntoRepository(private val db: AppDatabase) {

    suspend fun sincronizarDatos() {
        withContext(Dispatchers.IO) {
            val jsonPuntos = ApiService.obtenerPuntos()
            jsonPuntos?.let {
                val type = Types.newParameterizedType(List::class.java, Punto::class.java)
                val puntosRemotos = Moshi.Builder().build()
                    .adapter<List<Punto>>(type)
                    .fromJson(it)

                val puntosConDistancia = puntosRemotos?.map { punto ->
                    val distancia = calcularDistancia(punto.x1, punto.y1, punto.x2, punto.y2)
                    Punto(punto.id, punto.x1, punto.y1, punto.x2, punto.y2, distancia)
                }

                puntosConDistancia?.let { db.puntoDao().insertarPuntos(it) }
            }
        }
    }

    private fun calcularDistancia(x1: Double, y1: Double, x2: Double, y2: Double): Double {
        return Math.sqrt(Math.pow((x2 - x1), 2.0) + Math.pow((y2 - y1), 2.0))
    }
}
