package com.example.proyectokotlin.RxBorrar

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectokotlin.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RxBorrarActivity : AppCompatActivity() {

    private lateinit var textViewResultado: TextView
    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rx_borrar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textViewResultado = findViewById(R.id.textViewResultado)

//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://192.168.151.79:3000/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory.create())
//            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.151.79:8000/api/mascotas/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
//        observarDatos(apiService)
        observarPublicaciones(apiService)
    }

//    private fun observarDatos(apiService: ApiService) {
//        val observable = Observable.interval(0, 10, TimeUnit.SECONDS)
//            .flatMap { apiService.getProducts() }
//            .distinctUntilChanged()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//
//        val disposable = observable.subscribe(
//            { listaDatos ->
//                val mensajes = listaDatos.joinToString("\n") { dato ->
//                    "ID: ${dato.product_id}, Nombre: ${dato.name}, Precio: ${dato.price}, Descripción: ${dato.description}"
//                }
//                textViewResultado.text = mensajes
//            },
//            { error ->
//                textViewResultado.text = "Error: ${error.message}"
//            }
//        )
//        disposables.add(disposable)
//    }


    private fun observarPublicaciones(apiService: ApiService) {
        val observable = Observable.interval(0, 10, TimeUnit.SECONDS)
            .flatMap { apiService.getPublicaciones() } // Método que devuelve Observable<List<Publicacion>>
            .distinctUntilChanged()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        val disposable = observable.subscribe(
            { listaPublicaciones ->
                val mensajes = listaPublicaciones.joinToString("\n") { publicacion ->
                    """
                ID Publicación: ${publicacion.id_publicacion}
                ID Usuario: ${publicacion.id_usuario}
                ID Mascota: ${publicacion.id_mascota}
                Título: ${publicacion.titulo}
                Descripción: ${publicacion.descripcion}
                Tipo Publicación: ${publicacion.tipo_publicacion}
                Fecha Publicación: ${publicacion.fecha_publicacion}
                Estado: ${publicacion.estado}
                """.trimIndent()
                }
                textViewResultado.text = mensajes
            },
            { error ->
                textViewResultado.text = "Error: ${error.message}"
            }
        )
        disposables.add(disposable)
    }


    override fun onDestroy() {
        super.onDestroy()
        disposables.clear()
    }
}
