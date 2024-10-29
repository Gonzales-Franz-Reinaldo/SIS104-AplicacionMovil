package com.example.practicasparciales

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicasparciales.SegundoParcial.Ejercicio1Activity
import com.example.practicasparciales.WebService.WebServiceActivity
import com.example.practicasparciales.baseDatosSQLite.BaseDatosActivity

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
        val buttonWebService = findViewById<Button>(R.id.buttonWebService)
        val buttonParcia2 = findViewById<Button>(R.id.buttonParcia2)

        buttonBaseDatos.setOnClickListener {
            val intent = Intent(this@MainActivity, BaseDatosActivity::class.java)
            startActivity(intent)
        }

        buttonWebService.setOnClickListener {
            val intent = Intent(this@MainActivity, WebServiceActivity::class.java)
            startActivity(intent)
        }

        buttonParcia2.setOnClickListener {
            val intent = Intent(this@MainActivity, Ejercicio1Activity::class.java)
            startActivity(intent)
        }

    }
}