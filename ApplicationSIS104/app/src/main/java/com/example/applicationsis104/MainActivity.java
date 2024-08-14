package com.example.applicationsis104;

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

public class MainActivity extends AppCompatActivity {
    EditText valorA, valorB, valorC, valorD;
    Button buttonComplejo;
    TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        valorA = findViewById(R.id.valorA);
        valorB = findViewById(R.id.valorB);
        valorC = findViewById(R.id.valorC);
        valorD = findViewById(R.id.valorD);

        buttonComplejo = findViewById(R.id.buttonComplejo);
        textViewResultado = findViewById(R.id.textResultado);

        buttonComplejo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String a = valorA.getText().toString();
                String b = valorB.getText().toString();
                String c = valorA.getText().toString();
                String d = valorB.getText().toString();

//                if(equals(Double.parseDouble(a)) == true && equals(Double.parseDouble(b)) == true &&
//                        equals(Double.parseDouble(c)) == true && equals(Double.parseDouble(d)) == true){
//                    Double num_a = Double.parseDouble(a);
//                    Double num_b = Double.parseDouble(b);
//                    Double num_c = Double.parseDouble(c);
//                    Double num_d = Double.parseDouble(d);
//
//                    Complejos complejos = new Complejos(num_a, num_b, num_c, num_d);
//                }

                try {

                    Double num_a = Double.parseDouble(a);
                    Double num_b = Double.parseDouble(b);
                    Double num_c = Double.parseDouble(c);
                    Double num_d = Double.parseDouble(d);

                    Complejos complejos = new Complejos(num_a, num_b, num_c, num_d);

                    textViewResultado.setText(
                            "La suma del complejo es: " + complejos.suma() + "\n" +
                            "La resta del complejo es: " + complejos.resta() + "\n" +
                            "La multiplicación del complejo es: " + complejos.multiplicacion() + "\n" +
                            "La división del complejo es: " + complejos.division() + "\n"
                    );
                } catch (NumberFormatException error){
                    textViewResultado.setText("Datos inválidos, Ingresa números válidos.");
                }


            }
        });
    }


}