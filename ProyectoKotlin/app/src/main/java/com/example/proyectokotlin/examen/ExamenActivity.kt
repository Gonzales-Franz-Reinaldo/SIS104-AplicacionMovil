package com.example.proyectokotlin.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectokotlin.R
import com.example.proyectokotlin.ejercicios.EjerciciosActivity
import com.example.proyectokotlin.graficos.Barnsley

class ExamenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_examen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val buttonExamen1 = findViewById<Button>(R.id.Ejercicio1)
        val buttonExamen2 = findViewById<Button>(R.id.Ejercicio2)
        val buttonExamen3 = findViewById<Button>(R.id.Ejercicio3)
        val buttonExamen4 = findViewById<Button>(R.id.Ejercicio4)


        buttonExamen1.setOnClickListener{
            val intent = Intent(this@ExamenActivity, Ejercicio1Activity::class.java)
            startActivity(intent)
        }

        buttonExamen2.setOnClickListener{
            val intent = Intent(this@ExamenActivity, Ejercicio2Activity::class.java)
            startActivity(intent)
        }

        buttonExamen3.setOnClickListener {
            // Tamaño deseado (por ejemplo, 10000, pero será ajustado si es mayor que la pantalla)
//            val triangleSize = 10000f
//            setContentView(TrianguloView(this, triangleSize))
            val intent = Intent(this@ExamenActivity, Ejercicio3Activity::class.java)
            startActivity(intent)
        }



        buttonExamen4.setOnClickListener{
            val intent = Intent(this@ExamenActivity, Ejercicio4Activity::class.java)
            startActivity(intent)
        }
    }
}