package com.example.practicasparciales.WebService

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicasparciales.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebServiceActivity : AppCompatActivity() {

    private  lateinit var recyclerView: RecyclerView
    private lateinit var albunAdapter : ProductAdapter
    private val productList = mutableListOf<ProductDataCollectionItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_service)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val buttonConsumir = findViewById<Button>(R.id.buttonConsumir)

        buttonConsumir.setOnClickListener {
            getData()
        }
    }

    private fun getData(){
        val apiService = REST.getRestEngine().create(APIServices::class.java)
        val result : Call<List<ProductDataCollectionItem>> = apiService.listProducts()

        result.enqueue(object : Callback<List<ProductDataCollectionItem>> {
            override fun onResponse(
                call : Call<List<ProductDataCollectionItem>>,
                response: Response<List<ProductDataCollectionItem>>
            ){
                if(response.isSuccessful){
                    response.body()?.let {
                        productList.clear()
                        productList.addAll(it)
                        albunAdapter = ProductAdapter(productList)
                        recyclerView.adapter = albunAdapter
                        Toast.makeText(this@WebServiceActivity, "Respuesta exitosa", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this@WebServiceActivity, "Respuesta pero sin datos", Toast.LENGTH_SHORT).show()
                }
            }

            override  fun onFailure(call: Call<List<ProductDataCollectionItem>>, t: Throwable){
                Toast.makeText(this@WebServiceActivity, "Error de Server", Toast.LENGTH_SHORT).show()
            }
        })
    }
}