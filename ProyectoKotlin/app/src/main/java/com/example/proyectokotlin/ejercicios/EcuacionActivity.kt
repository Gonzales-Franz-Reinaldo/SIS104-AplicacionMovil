package com.example.proyectokotlin.ejercicios

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectokotlin.R
import org.w3c.dom.Text

class EcuacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ecuacoin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonSolucionecuacion = findViewById<Button>(R.id.button_SolucionEcuacion)

        buttonSolucionecuacion.setOnClickListener{
            val valorA = findViewById<EditText>(R.id.editTexta)
            val valorB = findViewById<EditText>(R.id.editTextb)
            val valorC = findViewById<EditText>(R.id.editTextc)
            val ecuacion = Ecuacion(a = 0.0, b = 0.0, c = 0.0)
            val textViewe = findViewById<TextView>(R.id.textView_Resultado)
//            var a = valorA.text.toString().toDouble()
//            var b = valorB.text.toString().toDouble()
//            var c = valorC.text.toString().toDouble()
//            val ecuacion = Ecuacion(a,b,c)
//            textViewe.text = ecuacion.Raices()
//            Toast.makeText(this, ecuacion.Raices(), Toast.LENGTH_SHORT).show()
            val inputA = valorA.text.toString()
            val inputB = valorB.text.toString()
            val inputC = valorC.text.toString()

            if (ecuacion.esNumeroValido(inputA) && ecuacion.esNumeroValido(inputB) && ecuacion.esNumeroValido(inputC)) {
                // Convertir los valores a Double solo si son válidos
                val a = inputA.toDouble()
                val b = inputB.toDouble()
                val c = inputC.toDouble()

                val ecuacionr = Ecuacion(a, b, c)
                textViewe.text = ecuacionr.Raices()
            } else {
                // Mostrar mensaje de error si algún valor no es válido
                textViewe.text = "Por favor, ingrese números válidos en todos los campos."
            }
        }
    }
}