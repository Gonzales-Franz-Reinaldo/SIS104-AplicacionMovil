package com.example.proyectokotlin

import android.content.ClipDescription
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectokotlin.RxBorrar.RxBorrarActivity
import com.example.proyectokotlin.WebService.WebServiceActivity
import com.example.proyectokotlin.basedatos.BaseDatosActivity
import com.example.proyectokotlin.basedatos.DBHelper
import com.example.proyectokotlin.basedatos.Lugar
import com.example.proyectokotlin.basedatos.RoomActivity
import com.example.proyectokotlin.ejercicios.EjerciciosActivity
import com.example.proyectokotlin.ejercicios.PersonActivity
import com.example.proyectokotlin.examen.ExamenActivity
import com.example.proyectokotlin.graficos.GraficosActivity
import com.example.proyectokotlin.wsSIS104borrar.WS_SIS104BorrarActivity

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
        val buttonGraficos = findViewById<Button>(R.id.buttonGraficos)
        val buttonSalir = findViewById<Button>(R.id.buttonSalir)
        val buttonExamen = findViewById<Button>(R.id.buttonExamen)
        val buttonPerson = findViewById<Button>(R.id.buttonPerson)
        val buttonBdRoom = findViewById<Button>(R.id.buttonBdRoom)
        val buttonWebService= findViewById<Button>(R.id.buttonWebService)
        val buttonRxBorrar = findViewById<Button>(R.id.buttonRxBorrar)

        val buttonWSsis104Borrar = findViewById<Button>(R.id.buttonWSsis104Borrar)



        buttonBaseDatos.setOnClickListener{
            val intent = Intent(this@MainActivity, BaseDatosActivity::class.java)
            startActivity(intent)
        }
        buttonEjercicios.setOnClickListener{
            val intent = Intent(this@MainActivity, EjerciciosActivity::class.java)
            startActivity(intent)
        }

        buttonGraficos.setOnClickListener{
            val intent = Intent(this@MainActivity, GraficosActivity::class.java)
            startActivity(intent)
        }
        buttonExamen.setOnClickListener{
            val intent = Intent(this@MainActivity, ExamenActivity::class.java)
            startActivity(intent)
        }

        buttonPerson.setOnClickListener{
            val intent = Intent(this@MainActivity, PersonActivity::class.java)
            startActivity(intent)
        }

        buttonBdRoom.setOnClickListener{
            val intent = Intent(this@MainActivity, RoomActivity::class.java)
            startActivity(intent)
        }

        buttonWebService.setOnClickListener{
            val intent = Intent(this@MainActivity, WebServiceActivity::class.java)
            startActivity(intent)
        }

        buttonWSsis104Borrar.setOnClickListener{
            val intent = Intent(this@MainActivity, WS_SIS104BorrarActivity::class.java)
            startActivity(intent)
        }

        buttonRxBorrar.setOnClickListener{
            val intent = Intent(this@MainActivity, RxBorrarActivity::class.java)
            startActivity(intent)
        }

        buttonSalir.setOnClickListener{
            finish()
        }
    }


}
