package com.example.sis104_kotlin.ejercicios

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sis104_kotlin.R

//class EcuacionActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_ecuacion)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//        val buttonSolucionEcuacion = findViewById<Button>(R.id.buttonSolucionEcuacion)
////    val buttonSolucionEcuacion = findViewById<Button>(R.id.buttonSolucionEcuacion)
//        val textViewEcuacion = findViewById<TextView>(R.id.textViewEcuacion)
//
//        buttonSolucionEcuacion.setOnClickListener {
//            val valorA = findViewById<EditText>(R.id.editTextA)
//            val valorB = findViewById<EditText>(R.id.editTextB)
//            val valorC = findViewById<EditText>(R.id.editTextC)
//
//            var a = valorA.text.toString().toDouble()
//            var b = valorA.text.toString().toDouble()
//            var c = valorA.text.toString().toDouble()
//
//            val ecuacion = Ecuacion(a, b, c)
//
//            textViewEcuacion.text = ecuacion.Raices()
//
//            Toast.makeText(this, ecuacion.Raices(), Toast.LENGTH_SHORT).show()
//        }
//    }
//
//
//}



class EcuacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ecuacion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonSolucionEcuacion = findViewById<Button>(R.id.buttonSolucionEcuacion)
        val textViewEcuacion = findViewById<TextView>(R.id.textViewEcuacion)

        buttonSolucionEcuacion.setOnClickListener {
            val valorA = findViewById<EditText>(R.id.editTextA)
            val valorB = findViewById<EditText>(R.id.editTextB)
            val valorC = findViewById<EditText>(R.id.editTextC)

            // Verificar si el campo A está vacío o no es un número válido
            val a = valorA.text.toString().toDoubleOrNull()
            if (valorA.text.isEmpty()) {
                Toast.makeText(this, "Error: El campo A está vacío", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (a == null) {
                Toast.makeText(this, "Error: El valor de A no es un número válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Verificar si el campo B está vacío o no es un número válido
            val b = valorB.text.toString().toDoubleOrNull()
            if (valorB.text.isEmpty()) {
                Toast.makeText(this, "Error: El campo B está vacío", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (b == null) {
                Toast.makeText(this, "Error: El valor de B no es un número válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Verificar si el campo C está vacío o no es un número válido
            val c = valorC.text.toString().toDoubleOrNull()
            if (valorC.text.isEmpty()) {
                Toast.makeText(this, "Error: El campo C está vacío", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (c == null) {
                Toast.makeText(this, "Error: El valor de C no es un número válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Si todos los valores son válidos, crear la ecuación y mostrar las raíces
            val ecuacion = Ecuacion(a, b, c)
            textViewEcuacion.text = ecuacion.Raices()

            // Mostrar resultado en un Toast (opcional)
            Toast.makeText(this, ecuacion.Raices(), Toast.LENGTH_SHORT).show()
        }
    }
}

