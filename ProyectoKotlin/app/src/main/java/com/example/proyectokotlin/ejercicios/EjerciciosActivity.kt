package com.example.proyectokotlin.ejercicios

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectokotlin.R

class EjerciciosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicios)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonEcuacion = findViewById<Button>(R.id.buttonEcuacion)
        val buttonComplejos = findViewById<Button>(R.id.buttonComplejos)
        val buttonSalirEjercicio = findViewById<Button>(R.id.salirEjercicios)
        val buttonSumaModelo = findViewById<Button>(R.id.buttonSumaModel)
        val buttonDivisionModel = findViewById<Button>(R.id.buttonDivisionModel)
        val buttonMultiplicacionModelo = findViewById<Button>(R.id.buttonMultiplicacionModel)


        buttonComplejos.setOnClickListener{
            val intent = Intent(this@EjerciciosActivity, ComplejoActivity::class.java)
            startActivity(intent)
        }
        buttonEcuacion.setOnClickListener{
            val intent = Intent(this@EjerciciosActivity, EcuacionActivity::class.java)
            startActivity(intent)
        }

        buttonSumaModelo.setOnClickListener{
            val intent = Intent(this@EjerciciosActivity, SumaModelActivity::class.java)
            startActivity(intent)
        }


        buttonMultiplicacionModelo.setOnClickListener{
            val intent = Intent(this@EjerciciosActivity, MultiplicacionModelActivity::class.java)
            startActivity(intent)
        }
        
        buttonDivisionModel.setOnClickListener{
            val intent = Intent(this@EjerciciosActivity, DivisionModelActivity::class.java)
            startActivity(intent)
        }

        buttonSalirEjercicio.setOnClickListener{
            finish()
        }
    }
}