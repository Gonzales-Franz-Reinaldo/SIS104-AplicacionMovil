package com.example.sis104menu.Graficos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

public class Cantor  extends View {
    private static final  String TAG = "Grafico";

    public Cantor(Context context) {
        super(context);
    }

    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLACK);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();

        drawCantor(canvas, 10, alto / 2, ancho - 10, 4, paint);
    }


    private void  drawCantor(Canvas canvas, int x, int y, int ancho, int nivel, Paint paint){
        if (nivel == 0 || nivel < 1){
            return;
        }

        canvas.drawLine(x, y, x + ancho, y, paint);
        int newY = y + 30;

        drawCantor(canvas, x, newY, ancho/3, nivel - 1, paint);
        drawCantor(canvas, x + 2 * (ancho / 3), newY, ancho/3, nivel - 1, paint);
    }
}
