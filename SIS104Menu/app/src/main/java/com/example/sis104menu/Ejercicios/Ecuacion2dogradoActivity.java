package com.example.sis104menu.Ejercicios;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sis104menu.R;

public class Ecuacion2dogradoActivity extends AppCompatActivity {

    EditText editTextA, editTextB, editTextC;
    Button button_SolucionEcuacion;
    Button button_Salir;
    TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ecuacion2dogrado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);

        button_SolucionEcuacion = findViewById(R.id.button_SolucionEcuacion);

        button_Salir  = findViewById(R.id.button_SalirEcuacio);
        textViewResultado =  findViewById(R.id.textViewResultado);

        button_SolucionEcuacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double a = Double.parseDouble(editTextA.getText().toString());
                Double b = Double.parseDouble(editTextB.getText().toString());
                Double c = Double.parseDouble(editTextC.getText().toString());

                Ecuacion ecuacion = new Ecuacion(a,b,c);

                textViewResultado.setText(ecuacion.Raices());
            }
        });

        button_Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}