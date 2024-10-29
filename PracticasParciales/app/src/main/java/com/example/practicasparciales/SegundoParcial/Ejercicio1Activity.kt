package com.example.practicasparciales.SegundoParcial

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.practicasparciales.R
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Ejercicio1Activity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var repository: PuntoRepository
    private lateinit var textViewResultados: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonSincronizar = findViewById<Button>(R.id.buttonSincronizar)

        // Inicializar la base de datos y el repositorio
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "puntos_database.db").build()

        repository = PuntoRepository(db)
        textViewResultados = findViewById(R.id.textViewResultados)

        buttonSincronizar.setOnClickListener {
            lifecycleScope.launch {
                repository.sincronizarDatos()
                mostrarDatos()
            }
        }

    }

    private suspend fun mostrarDatos() {
        val puntos = db.puntoDao().obtenerPuntos()
        withContext(Dispatchers.Main) {
            textViewResultados.text = puntos.joinToString(separator = "\n") {
                "ID: ${it.id}, x1: ${it.x1}, y1: ${it.y1}, x2: ${it.x2}, y2: ${it.y2}, Distancia: ${it.distancia}"
            }
        }
    }
}
