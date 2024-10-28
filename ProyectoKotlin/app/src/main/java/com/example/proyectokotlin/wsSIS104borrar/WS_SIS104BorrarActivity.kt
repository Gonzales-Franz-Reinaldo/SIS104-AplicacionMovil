package com.example.proyectokotlin.wsSIS104borrar

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectokotlin.R
import com.example.proyectokotlin.databinding.ActivityWsSis104BorrarBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WS_SIS104BorrarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWsSis104BorrarBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ws_sis104_borrar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val productId = findViewById<EditText>(R.id.productId)
        val productName = findViewById<EditText>(R.id.productoName)
        val productPrice = findViewById<EditText>(R.id.productoPrice)
        val productDescription = findViewById<EditText>(R.id.productoDescription)

        val btnCrear = findViewById<Button>(R.id.btnCrear)
        val btnActualizar = findViewById<Button>(R.id.btnActualizar)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)

        val btnObtener = findViewById<Button>(R.id.btnObtener)
        val btnListar = findViewById<Button>(R.id.btnListar)

        val textViewResultado = findViewById<TextView>(R.id.textViewProductos)


        btnCrear.setOnClickListener {
            val product = Product(
                product_id = 0,  // ID se asigna en el servidor
                name = productName.text.toString(),
                price = productPrice.text.toString().toDouble(),
                description = productDescription.text.toString()
            )
            createProduct(product)
        }

        btnActualizar.setOnClickListener {
            val id = productId.text.toString().toInt()

            val product = Product(
                product_id = id,
                name = productName.text.toString(),
                price = productPrice.text.toString().toDouble(),
                description = productDescription.text.toString()
            )
            updateProduct(id, product)
        }

        btnEliminar.setOnClickListener {
            val productId = productId.text.toString().toInt()
            deleteProduct(productId)
        }


        btnListar.setOnClickListener {
            getAllData()
        }

        btnObtener.setOnClickListener {
            val productId = productId.text.toString().toInt()
            getProductById(productId)
        }
    }


    private fun getAllData() {
        RetrofitInstance.api.getAllProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    Log.d("WS_SIS104BorrarActivity", "Productos obtenidos: $products")
//                    mostrar los products en el textViewResultado
                    val textViewResultado = findViewById<TextView>(R.id.textViewProductos)
                    textViewResultado.text = products.toString()

                } else {
                    Log.d("WS_SIS104BorrarActivity", "Error al obtener productos: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("WS_SIS104BorrarActivity", "Error al obtener productos: ${t.message}")
            }
        })
    }

    // Método para crear un producto
    private fun createProduct(product: Product) {
        RetrofitInstance.api.createProduct(product).enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {
                    Log.d("WS_SIS104BorrarActivity", "Producto creado: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.d("WS_SIS104BorrarActivity", "Error al crear producto: ${t.message}")
            }
        })
    }


    // Método para actualizar un producto
    private fun updateProduct(productId: Int, product: Product) {
        RetrofitInstance.api.updateProduct(productId, product).enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {
                    Log.d("WS_SIS104BorrarActivity", "Producto actualizado: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.d("WS_SIS104BorrarActivity", "Error al actualizar producto: ${t.message}")
            }
        })

    }

    // Método para eliminar un producto
    private fun deleteProduct(productId: Int) {
        RetrofitInstance.api.deleteProduct(productId).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Log.d("WS_SIS104BorrarActivity", "Producto eliminado")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.d("WS_SIS104BorrarActivity", "Error al eliminar producto: ${t.message}")
            }
        })
    }

    // Método para obtener un producto por ID
    private fun getProductById(productId: Int) {
        RetrofitInstance.api.getProductById(productId).enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {
                    val product = response.body()
                    Log.d("WS_SIS104BorrarActivity", "Producto obtenido: $product")
//                    mostrar el product en el textViewResultado
                    val textViewResultado = findViewById<TextView>(R.id.textViewProductos)
                    textViewResultado.text = product.toString()
                } else {
                    Log.d("WS_SIS104BorrarActivity", "Error al obtener producto: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.d("WS_SIS104BorrarActivity", "Error al obtener producto: ${t.message}")
            }
        })
    }

}



