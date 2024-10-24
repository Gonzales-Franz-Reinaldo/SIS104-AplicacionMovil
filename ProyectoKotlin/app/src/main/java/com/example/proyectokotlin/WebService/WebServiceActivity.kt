// WebServiceActivity.kt
package com.example.proyectokotlin.WebService

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectokotlin.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WebServiceActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var albumAdapter: AlbumAdapter
    private val albumList = mutableListOf<AlbumDataCollectionItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_service)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val buttonConsumir = findViewById<Button>(R.id.buttonConsumir)
        buttonConsumir.setOnClickListener {
            getData()
        }
    }

    private fun getData() {
        val apiService = Rest.getRestEngine().create(APIServices::class.java)
        val result: Call<List<AlbumDataCollectionItem>> = apiService.listAlbums()

        result.enqueue(object : Callback<List<AlbumDataCollectionItem>> {
            override fun onResponse(
                call: Call<List<AlbumDataCollectionItem>>,
                response: Response<List<AlbumDataCollectionItem>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        albumList.clear()
                        albumList.addAll(it)
                        albumAdapter = AlbumAdapter(albumList)
                        recyclerView.adapter = albumAdapter
                        Toast.makeText(this@WebServiceActivity, "Respuesta exitosa", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@WebServiceActivity, "Respuesta pero sin datos", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<AlbumDataCollectionItem>>, t: Throwable) {
                Toast.makeText(this@WebServiceActivity, "Error de Server", Toast.LENGTH_SHORT).show()
            }
        })
    }
}




//package com.example.proyectokotlin.WebService
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.example.proyectokotlin.R
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class WebServiceActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//
//        setContentView(R.layout.activity_web_service)
////        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
////            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
////            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
////            insets
////        }
//
//        val buttonConsumir = findViewById<Button>(R.id.buttonConsumir)
//
//        buttonConsumir.setOnClickListener {
//            getData()
//        }
//    }
//
//    private fun getData() {
//        val apiService = Rest.getRestEngine().create(APIServices::class.java)
//        val result: Call<List<AlbumDataCollectionItem>> = apiService.listAlbums()
//
//        result.enqueue(object : Callback<List<AlbumDataCollectionItem>> {
//            override fun onResponse(
//                p0: Call<List<AlbumDataCollectionItem>>,
//                p1: Response<List<AlbumDataCollectionItem>>
//            ) {
//                if (p1.isSuccessful) {
//                    Toast.makeText(this@WebServiceActivity, "Respuesta exitosa", Toast.LENGTH_SHORT)
//                        .show()
//                } else {
//                    Toast.makeText(
//                        this@WebServiceActivity,
//                        "Respuesta pero sin datos",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//
//            override fun onFailure(p0: Call<List<AlbumDataCollectionItem>>, p1: Throwable) {
//                Toast.makeText(this@WebServiceActivity, "Error de Server", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        })
//    }
//
//}