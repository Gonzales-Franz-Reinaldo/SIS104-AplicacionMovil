package com.example.proyectokotlin.graficos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectokotlin.R
import com.example.sis104menu.Graficos.SierpinskiTriangle

class GraficosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_graficos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonGrafico2D = findViewById<Button>(R.id.buttonGrafico2D)
        val buttonFractalTrianguloSierpinski = findViewById<Button>(R.id.buttonFractalTrianguloSierpinski)
        val buttonFractalBarsley = findViewById<Button>(R.id.buttonFractalBarsley)
        val button_SalirFractal = findViewById<Button>(R.id.button_SalirFractal)


        buttonGrafico2D.setOnClickListener{
//            setContentView(Grafico2D(this))
//            setContentView(Cantor(this))
            setContentView(Koch(this))
        }

        buttonFractalTrianguloSierpinski.setOnClickListener{
              setContentView(SierpinskiTriangle(this))
        }

        buttonFractalBarsley.setOnClickListener{
            setContentView(Barnsley(this))
        }

        button_SalirFractal.setOnClickListener{
            finish()
        }
    }
}