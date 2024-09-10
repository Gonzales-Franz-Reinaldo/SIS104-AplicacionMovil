package com.example.proyectokotlin.ejercicios

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectokotlin.R

class ComplejoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_complejo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonResolver = findViewById<Button>(R.id.buttonComplejos)

        buttonResolver.setOnClickListener{
            val valorAc = findViewById<EditText>(R.id.editTextA)
            val valorBc = findViewById<EditText>(R.id.editTextB)
            val valorCc = findViewById<EditText>(R.id.editTextC)
            val valorDc = findViewById<EditText>(R.id.editTextD)
            val complejo = Complejos(a = 0.0, b = 0.0, c = 0.0, d=0.0)
            val textViewComplejos = findViewById<TextView>(R.id.textViewResultadoComp)
            val inputAc = valorAc.text.toString()
            val inputBc = valorBc.text.toString()
            val inputCc = valorCc.text.toString()
            val inputDc = valorDc.text.toString()

            if (complejo.esNumeroValido(inputAc) && complejo.esNumeroValido(inputBc) && complejo.esNumeroValido(inputCc) && complejo.esNumeroValido(inputDc)) {
                // Convertir los valores a Double solo si son válidos
                val a = inputAc.toDouble()
                val b = inputBc.toDouble()
                val c = inputCc.toDouble()
                val d = inputDc.toDouble()

                val complejoR = Complejos(a, b, c, d)
                textViewComplejos.text= "Suma: "+complejoR.suma() + "\n " +
                        "Resta: "+complejoR.resta() + "\n " +
                        "Multiplicacion: "+complejoR.multiplicar() + "\n " +
                        "Division: "+complejoR.dividir()
            } else {
                // Mostrar mensaje de error si algún valor no es válido
                textViewComplejos.text = "Por favor, ingrese números válidos en todos los campos."
            }
        }
    }
}