package com.example.proyectokotlin.ejercicios

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.proyectokotlin.R

class CalculadoraActivity : AppCompatActivity() {
    private val viewModel : CalculadoraViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val buttonCalculadora = findViewById<Button>(R.id.buttonCalculadora)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        viewModel.resultado.observe(this, Observer {
            result -> textViewResultado.text = result
        })

        buttonCalculadora.setOnClickListener {
            val num1 = editTextNumber1.text.toString().toDouble()
            val num2 = editTextNumber2.text.toString().toDouble()
            viewModel.calcular(num1, num2)
        }
    }
}