package com.example.sis104menu.Graficos.LAB_01;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sis104menu.Graficos.Grafico2d;
import com.example.sis104menu.Graficos.Grafico2dActivity;
import com.example.sis104menu.R;

public class GraficaTortaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_grafica_torta);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

//        setContentView(new Grafico2d(GraficaTortaActivity.this));
        setContentView(new GraficaTorta(GraficaTortaActivity.this));
    }
}