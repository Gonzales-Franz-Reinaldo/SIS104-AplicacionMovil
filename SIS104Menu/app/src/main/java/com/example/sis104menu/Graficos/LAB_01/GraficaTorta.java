package com.example.sis104menu.Graficos.LAB_01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class GraficaTorta extends View {
    private static final String TAG = "GraficaTorta";

    private final int[] porcentajes = {75, 85, 40};

    private final int[] colores = {Color.GREEN, Color.BLUE, Color.RED};

    public GraficaTorta(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        barra(canvas);
    }


    public void barra(Canvas canvas) {
        // Configurar la pintura para la gráfica circular
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);


        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();

        Log.d(TAG, "Ancho: " + ancho + " Alto: " + alto);

        // definimos el centro y radio del círculo
        float centroX = ancho / 2;
        float centroY = alto / 2;
        float radio = Math.min(ancho, alto) / 3;


        float anguloInicio = 0;


        for (int i = 0; i < porcentajes.length; i++) {
            // Calcular el ángulo que corresponde al porcentaje actual
            float anguloBarrido = (porcentajes[i] / 200.0f) * 360;

            // Dibujar la sección del gráfico circular
            paint.setColor(colores[i % colores.length]);
            canvas.drawArc(centroX - radio, centroY - radio, centroX + radio, centroY + radio,
                    anguloInicio, anguloBarrido, true, paint);

//            actualizamos el angulo de inicio para la siguiente sección
            anguloInicio += anguloBarrido;
        }
    }
}
