package com.example.proyectokotlin.basedatos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectokotlin.R

class BaseDatosActivity : AppCompatActivity() {

    lateinit var dbHelper: DBHelper

    lateinit var editTextId: EditText
    lateinit var editTextNombre: EditText
    lateinit var editTextDescripcion: EditText
    lateinit var textViewResultado : TextView

    lateinit var buttonAgregar: Button
    lateinit var buttonListar: Button
    lateinit var buttonEditar: Button
    lateinit var buttonEliminar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_base_datos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //        PARA LA BASE DE DATOS
        dbHelper = DBHelper(this)
        editTextId = findViewById(R.id.editTextId)
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextDescripcion = findViewById(R.id.editTextDescripcion)
        buttonAgregar = findViewById(R.id.buttonAgregar)
        buttonListar = findViewById(R.id.buttonListar)
        textViewResultado = findViewById(R.id.textViewResultado)
        buttonEditar = findViewById(R.id.buttonEditar)
        buttonEliminar = findViewById(R.id.buttonEliminar)


        buttonAgregar.setOnClickListener{
            agregarLugar()
        }
        buttonListar.setOnClickListener{
            listarLugar()
        }
        buttonEditar.setOnClickListener{
            editarLugar()
        }
        buttonEliminar.setOnClickListener{
            eliminarLugar()
        }

    }



    fun agregarLugar(){
        val nombre = editTextNombre.text.toString()
        val descripcion = editTextDescripcion.text.toString()
        val lugar = Lugar(0, nombre, descripcion)
        dbHelper.insertarLugar(lugar)
        textViewResultado.text = "Lugar agregado correctamente"
    }
    fun listarLugar(){
        val lugares = dbHelper.obtenerLugares()
        val stringBuilder = StringBuilder()

        for (lugar in lugares) {
            stringBuilder.append("ID: ${lugar.id}\n")
            stringBuilder.append("Nombre: ${lugar.nombre}\n")
            stringBuilder.append("Descripción: ${lugar.descripcion}\n")
            stringBuilder.append("\n")
        }
        textViewResultado.text = stringBuilder.toString()

    }

    fun editarLugar() {
        val id = editTextId.text.toString().toIntOrNull()
        val nombre = editTextNombre.text.toString()
        val descripcion = editTextDescripcion.text.toString()

        if (id != null) {
            val lugar = Lugar(id, nombre, descripcion)
            val filasActualizadas = dbHelper.editarLugar(lugar)
            if (filasActualizadas > 0) {
                textViewResultado.text = "Lugar actualizado correctamente"
            } else {
                textViewResultado.text = "No se pudo actualizar el lugar"
            }
        } else {
            textViewResultado.text = "Por favor, ingrese un ID válido"
        }
    }


    fun eliminarLugar() {
        val id = editTextId.text.toString().toIntOrNull()

        if (id != null) {
            val filasEliminadas = dbHelper.eliminarLugar(id)
            if (filasEliminadas > 0) {
                textViewResultado.text = "Lugar eliminado correctamente"
            } else {
                textViewResultado.text = "No se pudo eliminar el lugar"
            }
        } else {
            textViewResultado.text = "Por favor, ingrese un ID válido"
        }
    }
}