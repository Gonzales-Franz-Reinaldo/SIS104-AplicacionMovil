package com.example.sis104_kotlin.ejercicios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sis104_kotlin.R

class EjercicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonEcuacion = findViewById<Button>(R.id.buttonEcuacion)
        val buttonComplejos = findViewById<Button>(R.id.buttonComplejos)
        val buttonEjercicioSalir = findViewById<Button>(R.id.buttonEjercicioSalir)

        buttonEcuacion.setOnClickListener {
            val intent = Intent(this@EjercicioActivity, EcuacionActivity::class.java)
            startActivity(intent)
        }

        buttonComplejos.setOnClickListener {
            val intent = Intent(this@EjercicioActivity, ComplejoActivity::class.java)
            startActivity(intent)
        }

        buttonEjercicioSalir.setOnClickListener {
            finish()
        }
    }
}