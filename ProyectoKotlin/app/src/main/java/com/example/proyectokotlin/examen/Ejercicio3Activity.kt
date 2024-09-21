package com.example.proyectokotlin.examen

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectokotlin.R

class Ejercicio3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextNumero = findViewById<EditText>(R.id.editTextNumero)
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcularGrafica)


        buttonCalcular.setOnClickListener {
            val numero = editTextNumero.text.toString().toInt()
            setContentView(TrianguloView(this, numero))
        }
    }
}