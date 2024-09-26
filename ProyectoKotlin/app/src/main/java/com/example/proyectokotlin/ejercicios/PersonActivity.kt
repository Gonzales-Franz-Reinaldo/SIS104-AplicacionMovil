package com.example.proyectokotlin.ejercicios

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.proyectokotlin.R

class PersonActivity : AppCompatActivity() {

    private val personViewModel : PersonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_person)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val editTextName : EditText = findViewById(R.id.editTextName)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val buttonPerson = findViewById<Button>(R.id.buttonPerson)
        val textViewPerson = findViewById<TextView>(R.id.textViewPerson)

        personViewModel.person.observe(this, Observer{
            result ->
            textViewPerson.text = "Name: ${result.name} Email: ${result.email}"
        })

        buttonPerson.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()

            personViewModel.apdatePeron(name, email)
        }

    }
}