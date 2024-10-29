package com.example.practicasparciales.baseDatosSQLite

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.persistableBundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicasparciales.R

class BaseDatosActivity : AppCompatActivity() {

    lateinit var dbHelper: DBHelper

    lateinit var editTextId: EditText
    lateinit var editTextNombre: EditText
    lateinit var editTextApellido: EditText
    lateinit var editTextEdad : EditText
    lateinit var editTextSexo : EditText

    lateinit var buttonAgregar: Button
    lateinit var buttonListar: Button
    lateinit var buttonEditar: Button
    lateinit var buttonEliminar: Button

    lateinit var textViewResultado : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_base_datos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        dbHelper = DBHelper(this)
        editTextId = findViewById(R.id.editTextId)
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextApellido = findViewById(R.id.editTextApellido)
        editTextEdad = findViewById(R.id.editTextEdad)
        editTextSexo = findViewById(R.id.editTextSexo)

        buttonListar = findViewById(R.id.buttonListar)
        buttonAgregar = findViewById(R.id.buttonAgregar)
        buttonEditar = findViewById(R.id.buttonEditar)
        buttonEliminar = findViewById(R.id.buttonEliminar)

        textViewResultado = findViewById(R.id.textViewResultado)

        buttonAgregar.setOnClickListener {
            agregarPersona()
        }

        buttonListar.setOnClickListener {
            listarPersonas()
        }

        buttonEditar.setOnClickListener {
            editarPersona()
        }

        buttonEliminar.setOnClickListener {
            eliminarPersona()
        }
    }



    fun agregarPersona(){
        val nombre = editTextNombre.text.toString()
        val apellido = editTextApellido.text.toString()
        val edad = editTextEdad.text.toString().toInt()
        val sexo = editTextSexo.text.toString()

        val persona = Persona(0, nombre, apellido, edad, sexo)
        dbHelper.insertarPersona(persona)

        textViewResultado.text =  "Persona agregada"
    }


    fun listarPersonas(){
        val personas = dbHelper.obtenerPersonas()

        val resultado = StringBuilder()

        for(persona in personas){
            resultado.append("ID: ${persona.id}\n")
            resultado.append("Nombre: ${persona.nombre}\n")
            resultado.append("Apellido: ${persona.apellido}\n")
            resultado.append("Edad: ${persona.edad}\n")
            resultado.append("Sexo: ${persona.sexo}\n")
            resultado.append("\n")
        }

//        el resultado mostrar en consola
        println(resultado.toString())
        textViewResultado.text = resultado.toString()
    }


    fun editarPersona(){
        val id = editTextId.text.toString().toInt()
        val nombre = editTextNombre.text.toString()
        val apellido = editTextApellido.text.toString()
        val edad = editTextEdad.text.toString().toInt()
        val sexo = editTextSexo.text.toString()

        if(id != null){
            val persona = Persona(id, nombre, apellido, edad, sexo)

            val filasActualizadas = dbHelper.editarPersona(persona)

            if(filasActualizadas > 0){
                textViewResultado.text = "Persona actualizada"
            }else{
                textViewResultado.text = "No se pudo actualizar la persona"
            }
        }else{
            textViewResultado.text = "ID no válido"
        }
    }

    fun eliminarPersona(){
        val id = editTextId.text.toString().toInt()

        if(id != null){
            val filaEliminadas = dbHelper.eliminarPersona(id)
            if(filaEliminadas > 0){
                textViewResultado.text = "Persona eliminada"
            }else{
                textViewResultado.text = "No se pudo eliminar la persona"
            }
        }else{
            textViewResultado.text = "ID no válido"
        }
    }
}