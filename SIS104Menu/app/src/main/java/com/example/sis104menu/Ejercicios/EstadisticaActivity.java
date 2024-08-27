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

public class EstadisticaActivity extends AppCompatActivity {
    EditText editTextCaja1, editTextCaja2, editTextCaja3;
    TextView textViewGrafico;
    Button button_ResultadoEstadistica, button_SalirEstadisca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_estadistica);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextCaja1 = findViewById(R.id.editTextCaja1);
        editTextCaja2 = findViewById(R.id.editTextCaja2);
        editTextCaja3 = findViewById(R.id.editTextCaja3);
        textViewGrafico = findViewById(R.id.textViewGrafico);
        button_ResultadoEstadistica = findViewById(R.id.button_ResultadoEstadistica);
        button_SalirEstadisca = findViewById(R.id.button_SalirEstadistica);


        button_ResultadoEstadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numero1 =  Integer.parseInt(editTextCaja1.getText().toString());
                int numero2 =  Integer.parseInt(editTextCaja2.getText().toString());
                int numero3 =  Integer.parseInt(editTextCaja3.getText().toString());

                Estadistica estadistica = new Estadistica(numero1, numero2, numero3);
                textViewGrafico.setText(estadistica.Grafico());
            }
        });

        button_SalirEstadisca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}