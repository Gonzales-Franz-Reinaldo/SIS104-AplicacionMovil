
package com.example.sis104menu.Graficos.LAB_01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class LineaGrafica extends View {
    private static final String TAG = "DadosGrafica";

    // Porcentajes a graficar
    private final int[] porcentajes = {75, 85, 40};

    // Colores para cada barra
    private final int[] colores = {Color.GREEN, Color.BLUE, Color.RED};

    public LineaGrafica(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        barra(canvas);
    }


    public void barra(Canvas canvas) {
//        eleijmos fondo negro
        canvas.drawColor(Color.BLACK);


        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        Paint linePaint = new Paint();
        linePaint.setColor(Color.WHITE);
        linePaint.setStrokeWidth(5);

        // Dimensiones del canvas
        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();

        Log.d(TAG, "Ancho: " + ancho + " Alto: " + alto);


        paint.setColor(Color.WHITE);
        canvas.drawLine(0, alto, ancho, alto, paint);
        canvas.drawLine(ancho / 4, 0, ancho / 4, alto, paint);


        int numBarras = porcentajes.length;
        int anchoTotalDisponible = ancho - 2 * (ancho / 4);
        int anchoBarra = anchoTotalDisponible / numBarras;
        int espacioEntreBarras = anchoBarra / 4;

//        guardmos las posiciones de los puntos
        float[] puntosX = new float[numBarras];
        float[] puntosY = new float[numBarras];

        for (int i = 0; i < numBarras; i++) {

            // aquí calcular la altura de la barra basada en el porcentaje
            float alturaBarra = (porcentajes[i] / 100.0f) * alto;


            float izquierda = (ancho - (numBarras * (anchoBarra + espacioEntreBarras))) / 2 + i * (anchoBarra + espacioEntreBarras);
            float derecha = izquierda + anchoBarra;
            float arriba = alto - alturaBarra;
            float abajo = alto;


            paint.setColor(colores[i % colores.length]);
            canvas.drawRect(izquierda, arriba, derecha, abajo, paint);


            float puntoX = (izquierda + derecha) / 2;
            float puntoY = arriba;

//            aqui definimos el color del punto
            paint.setColor(Color.CYAN);

//            defimos el puto
            canvas.drawCircle(puntoX, puntoY, 10, paint);

//            guardamos las posiciones
            puntosX[i] = puntoX;
            puntosY[i] = puntoY;
        }

//        dibujamos los punto para que se conecten
        for (int i = 0; i < numBarras - 1; i++) {
            canvas.drawLine(puntosX[i], puntosY[i], puntosX[i + 1], puntosY[i + 1], linePaint);
        }
    }
}
