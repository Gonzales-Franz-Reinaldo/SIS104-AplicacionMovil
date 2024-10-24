package com.example.proyectokotlin.basedatos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.proyectokotlin.R
import kotlinx.coroutines.launch

class RoomActivity : AppCompatActivity() {

    var listaLugares = mutableListOf<Lugar>()
    lateinit var room: BaseDatos

    lateinit var editTextId: EditText
    lateinit var editTextNombre: EditText
    lateinit var editTextDescripcion: EditText
    lateinit var editTextLatitud: EditText
    lateinit var editTextLongitud: EditText
    lateinit var buttonGuardar : Button
    lateinit var buttonListar : Button
    lateinit var buttonActualizar : Button
    lateinit var buttonBorrar : Button
    lateinit var buttonMapa: Button
    lateinit var textViewResultado : TextView

    lateinit var buttonVerMapas : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_room)


        room = Room.databaseBuilder(this, BaseDatos::class.java, "lugares").build()

        editTextId = findViewById(R.id.editTextId)
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextDescripcion = findViewById(R.id.editTextDescripcion)
        editTextLatitud = findViewById(R.id.editTextLatitud)
        editTextLongitud = findViewById(R.id.editTextLongitud)
        buttonGuardar = findViewById(R.id.buttonGuardar)
        buttonListar = findViewById(R.id.buttonListar)
        buttonActualizar = findViewById(R.id.buttonActualizar)
        buttonBorrar = findViewById(R.id.buttonBorrar)
        textViewResultado = findViewById(R.id.textViewResultado)
        buttonMapa = findViewById(R.id.buttonMapa)

        buttonVerMapas = findViewById(R.id.buttonVerMapas)

        buttonGuardar.setOnClickListener {
            val lugar = Lugar(
                editTextId.text.toString().toInt(),
                editTextNombre.text.toString(),
                editTextDescripcion.text.toString(),
                editTextLatitud.text.toString().toDouble(),
                editTextLongitud.text.toString().toDouble()
            )
            agregarLugar(room, lugar)
        }

        buttonListar.setOnClickListener {
            listarLugares(room)
        }


        buttonMapa.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java).apply {
                putExtra("nombre", editTextNombre.text.toString())
                putExtra("descripcion", editTextDescripcion.text.toString())
                putExtra("latitud", editTextLatitud.text.toString().toDouble())
                putExtra("longitud", editTextLongitud.text.toString().toDouble())
            }
            startActivity(intent)
        }


//        para mostrar todos los puntos de los lugares registrados en el mapa
        buttonVerMapas.setOnClickListener {
            lifecycleScope.launch {
                // Obtener todos los lugares de la base de datos
                listaLugares = room.daoLugar().obtenerLugares()

                // Crear un Intent y pasar la lista de lugares
                val intent = Intent(this@RoomActivity, MapsActivity::class.java).apply {
                    putParcelableArrayListExtra("lugares", ArrayList(listaLugares))
                }
                startActivity(intent)
            }
        }


        buttonActualizar.setOnClickListener {
            val lugarId = editTextId.text.toString().toInt()
            val lugarNombre = editTextNombre.text.toString()
            val lugarDescripcion = editTextDescripcion.text.toString()
            val lugarLatitud = editTextLatitud.text.toString().toDouble()
            val lugarLongitud = editTextLongitud.text.toString().toDouble()

            actualizarLugar(room, lugarId, lugarNombre, lugarDescripcion, lugarLatitud, lugarLongitud)
        }


        buttonBorrar.setOnClickListener {
            val lugarId = editTextId.text.toString().toInt()

            // Buscar el lugar por ID y eliminarlo
            eliminarLugar(room, lugarId)
        }


    }

//    EJEMPLO A INTRODUCIR EN LA MAPA
//    ID: 1
//    Nombre: "Sucre"
//    Descripcion: "Casa de la Libertad"
//    Latitud: -19.035
//    Longitud: -65.262

    fun agregarLugar(room: BaseDatos, lugar: Lugar) {

        lifecycleScope.launch {
            room.daoLugar().insertarLugar(lugar)
            textViewResultado.text = "Lugar guardado"
        }
    }

//    Ver mapas varios puntos en MapsActivity.kt con un For
    fun listarLugares(room: BaseDatos) {

        lifecycleScope.launch {
            listaLugares = room.daoLugar().obtenerLugares()
            textViewResultado.text = listaLugares.toString()
        }
    }

    fun actualizarLugar(room: BaseDatos, id: Int, nombre: String, descripcion: String, latitud: Double, longitud: Double) {
        lifecycleScope.launch {
            room.daoLugar().actualizarLugar(id, nombre, descripcion, latitud, longitud)
            textViewResultado.text = "Lugar actualizado"
        }
    }

    fun eliminarLugar(room: BaseDatos, id: Int) {
        lifecycleScope.launch {
            // Buscar el lugar por ID
            val lugar = listaLugares.find { it.id == id }
            lugar?.let {
                room.daoLugar().borrarLugar(it)
                textViewResultado.text = "Lugar eliminado"
            } ?: run {
                textViewResultado.text = "Lugar no encontrado"
            }
        }
    }

}