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

class Ejercicio1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valorA = findViewById<EditText>(R.id.valorA)
        val valorB = findViewById<EditText>(R.id.valorB)

        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)

        // Obtener los TextViews de cada fila del GridLayout
        val labelsFila1 = listOf(
            findViewById<TextView>(R.id.label1_1),
            findViewById<TextView>(R.id.label1_2),
            findViewById<TextView>(R.id.label1_3),
            findViewById<TextView>(R.id.label1_4)
        )

        val labelsFila2 = listOf(
            findViewById<TextView>(R.id.label2_1),
            findViewById<TextView>(R.id.label2_2),
            findViewById<TextView>(R.id.label2_3),
            findViewById<TextView>(R.id.label2_4)
        )

        val labelsFila3 = listOf(
            findViewById<TextView>(R.id.label3_1),
            findViewById<TextView>(R.id.label3_2),
            findViewById<TextView>(R.id.label3_3),
            findViewById<TextView>(R.id.label3_4)
        )

        val labelsFila4 = listOf(
            findViewById<TextView>(R.id.label4_1),
            findViewById<TextView>(R.id.label4_2),
            findViewById<TextView>(R.id.label4_3),
            findViewById<TextView>(R.id.label4_4)
        )

        buttonCalcular.setOnClickListener {
            val a = valorA.text.toString().toInt()
            val b = valorB.text.toString().toInt()

            val suma = Suma(a, b)
            val resultado = suma.sumarConAcarreo()

            // Mostrar los resultados en los cuadritos
            for (i in resultado[0].split(" ").indices) {
                labelsFila2[i].text = resultado[0].split(" ")[i] // valorA
                labelsFila3[i].text = resultado[1].split(" ")[i] // valorB
                labelsFila1[i].text = resultado[2].split(" ")[i] // acarreo
                labelsFila4[i].text = resultado[3].split(" ")[i] // resultado final
            }
        }
    }
}