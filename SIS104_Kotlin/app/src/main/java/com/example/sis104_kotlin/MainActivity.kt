package com.example.sis104_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sis104_kotlin.basedatos.BaseDatosActivity
import com.example.sis104_kotlin.ejercicios.EjercicioActivity
import com.example.sis104_kotlin.examen.ExamenActivity
import com.example.sis104_kotlin.graficos.GraficoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonBaseDatos = findViewById<Button>(R.id.buttonBaseDatos)
        val buttonEjercicios = findViewById<Button>(R.id.buttonEjercicios)
        val buttonExamen = findViewById<Button>(R.id.buttonExamen)
        val buttonGrafico = findViewById<Button>(R.id.buttonGraficos)
        val buttonSalir = findViewById<Button>(R.id.button_Salir)


//        buttonBaseDatos.setOnClickListener{
//            val intent = Intent(this@MainActivity, BaseDatosActivity::class.java)
//            startActivity(intent)
//            true
//        }

        buttonEjercicios.setOnClickListener {
            val intent = Intent(this@MainActivity, EjercicioActivity::class.java)
            startActivity(intent)
        }


        buttonExamen.setOnLongClickListener {
            val intent = Intent(this@MainActivity, ExamenActivity::class.java)
            startActivity(intent)
            true
        }

        buttonGrafico.setOnLongClickListener {
            val intent = Intent(this@MainActivity, GraficoActivity::class.java)
            startActivity(intent)
            true
        }

        buttonSalir.setOnLongClickListener {
            finish()
            true
        }

    }
}