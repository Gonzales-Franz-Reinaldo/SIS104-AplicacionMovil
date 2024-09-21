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

class Ejercicio4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val texto = findViewById<EditText>(R.id.texto)
        val buttonValidar = findViewById<Button>(R.id.buttonValidar)
        val label1 = findViewById<TextView>(R.id.label1)
        val label2 = findViewById<TextView>(R.id.label2)

        buttonValidar.setOnClickListener {
            val textoIngresado = texto.text.toString()

            // Texto corregido con la primera letra de cada palabra en mayúscula
            val textoCorregido = textoIngresado.split(" ").joinToString(" ") { palabra ->
                palabra.lowercase().replaceFirstChar { it.uppercaseChar() }
            }

            // Verifica si el texto ingresado ya está correctamente capitalizado
            if (textoIngresado == textoCorregido) {
                // El texto ya está correctamente capitalizado
                label1.text = textoIngresado
                label2.text = "Correcto"
            } else {
                // El texto no está capitalizado correctamente
                label1.text = "Corregido: $textoCorregido"
                label2.text = "Error"
            }
        }
    }
}
