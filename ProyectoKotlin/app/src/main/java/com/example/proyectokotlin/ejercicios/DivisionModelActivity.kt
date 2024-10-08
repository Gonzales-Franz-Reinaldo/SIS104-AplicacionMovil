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
import com.example.proyectokotlin.R

class DivisionModelActivity : AppCompatActivity() {

    private val divisionViewModel: DivisionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_division_model)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextA = findViewById<EditText>(R.id.editTextA)
        val editTextB = findViewById<EditText>(R.id.editTextB)
        val buttonDivision = findViewById<Button>(R.id.buttonCalcular)
        val textViewDivision= findViewById<TextView>(R.id.textViewResultado)


        divisionViewModel.resultado.observe(this) { result ->
            textViewDivision.text = result
        }


        buttonDivision.setOnClickListener {
            val a = editTextA.text.toString().toIntOrNull()
            val b = editTextB.text.toString().toIntOrNull()

            if (a != null && b != null) {
                divisionViewModel.dividir(a, b)
            } else {
                textViewDivision.text = getString(R.string.error_input_invalido)
            }
            // Limpiar el foco de los EditText
            editTextA.clearFocus()
            editTextB.clearFocus()
        }
    }
}