package com.example.sis104menu.Graficos.LAB_01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class DadosGrafica extends View {
    private static final String TAG = "DadosGrafica";

//    declaramos los porcentajes
    private final int[] porcentajes = {75, 85, 40};

//    creamos los colores
    private final int[] colores = {Color.GREEN, Color.BLUE, Color.RED};

    public DadosGrafica(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        barra(canvas);
    }


    public void barra(Canvas canvas) {


        canvas.drawColor(Color.BLACK);


        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(50);


        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();

        Log.d(TAG, "Ancho: " + ancho + " Alto: " + alto);


        paint.setColor(Color.WHITE);
        canvas.drawLine(0, alto, ancho, alto, paint);
        canvas.drawLine(ancho / 4, 0, ancho / 4, alto, paint);

        // dibujamos  las barras y los porcentajes
        int numBarras = porcentajes.length;
        int anchoTotalDisponible = ancho - 2 * (ancho / 4);
        int anchoBarra = anchoTotalDisponible / numBarras;
        int espacioEntreBarras = anchoBarra / 4;

        for (int i = 0; i < numBarras; i++) {

            float alturaBarra = (porcentajes[i] / 100.0f) * alto;

//            float izquierda = (ancho - (numBarras * (anchoBarra + espacioEntreBarras))) / 2 + i * (anchoBarra + espacioEntreBarras);
//            float derecha = izquierda + anchoBarra;
//            float arriba = alto - alturaBarra;
//            float abajo = alto;

            float izquierda = (ancho - (numBarras * (anchoBarra + espacioEntreBarras))) / 2 + i * (anchoBarra + espacioEntreBarras);
            float derecha = izquierda + anchoBarra;
            float arriba = alto - alturaBarra;
            float abajo = alto;


            paint.setColor(colores[i % colores.length]);
            canvas.drawRect(izquierda, arriba, derecha, abajo, paint);


//            dibujamos los porcentajes
            String porcentajeTexto = porcentajes[i] + "%";
            float textX = izquierda + (anchoBarra / 2) - (textPaint.measureText(porcentajeTexto) / 2);
            float textY = arriba - 20;  // Posicionar un poco encima de la barra
            canvas.drawText(porcentajeTexto, textX, textY, textPaint);
        }
    }
}
