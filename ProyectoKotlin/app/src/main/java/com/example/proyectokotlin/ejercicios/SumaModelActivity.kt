package com.example.proyectokotlin.ejercicios

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectokotlin.R

class SumaModelActivity : AppCompatActivity() {

    private val sumaViewModel: SumaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suma_model)

        val editTextA = findViewById<EditText>(R.id.editTextA)
        val editTextB = findViewById<EditText>(R.id.editTextB)
        val buttonSuma = findViewById<Button>(R.id.buttonCalcular)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        sumaViewModel.resultado.observe(this, { result ->
            textViewResultado.text = result
        })

        buttonSuma.setOnClickListener {
            val a = editTextA.text.toString().toIntOrNull()
            val b = editTextB.text.toString().toIntOrNull()

            if (a != null && b != null) {
                sumaViewModel.sumar(a, b)
            } else {
                textViewResultado.text = "Por favor, ingrese valores numéricos válidos."
            }
        }
    }
}
