package com.example.proyectokotlin.examen

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectokotlin.R

class Ejercicio2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valor1 = findViewById<EditText>(R.id.valorA)
        val valor2 = findViewById<EditText>(R.id.valorB)
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)
        val resultado = findViewById<TextView>(R.id.label1)


        buttonCalcular.setOnClickListener {
            val a = valor1.text.toString().toDoubleOrNull() ?: 0.0
            val b = valor2.text.toString().toDoubleOrNull() ?: 0.0

            // Llamada a la clase de suma recursiva
            val sumaRecursiva = SumaRecursiva()
            val resultadoSuma = sumaRecursiva.sumar(a, b)

            // Mostrar el resultado en el label1
            resultado.text = "Resultado: $resultadoSuma"
        }
    }
}