package com.example.sis104menu.Graficos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sis104menu.Graficos.LAB_01.DadosActivity;
import com.example.sis104menu.Graficos.LAB_01.GraficaTortaActivity;
import com.example.sis104menu.Graficos.LAB_01.LineaGraficaActivity;
import com.example.sis104menu.R;

public class GraficoActivity extends AppCompatActivity {
    Button button_Graficos2d, button_GraficosFractal, button_SalirGrafico;

    Button button_GraficaDado, button_LineaGrafico, button_GraficaTorta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grafico);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button_Graficos2d = findViewById(R.id.button_Graficos2d);
        button_GraficosFractal = findViewById(R.id.button_GraficosFractal);
        button_SalirGrafico = findViewById(R.id.button_GraficosSalir);

        button_Graficos2d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GraficoActivity.this, Grafico2dActivity.class);
                startActivity(intent);
            }
        });

        button_GraficosFractal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





//        PARTE DEL LABORATORIO
        button_GraficaDado = findViewById(R.id.button_GraficaDado);
        button_LineaGrafico = findViewById(R.id.button_LineaGrafico);
        button_GraficaTorta = findViewById(R.id.button_GraficaTorta);

        button_GraficaDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GraficoActivity.this, DadosActivity.class);
                startActivity(intent);
            }
        });

        button_LineaGrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GraficoActivity.this, LineaGraficaActivity.class);
                startActivity(intent);
            }
        });

        button_GraficaTorta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GraficoActivity.this, GraficaTortaActivity.class);
                startActivity(intent);
            }
        });




        button_SalirGrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}