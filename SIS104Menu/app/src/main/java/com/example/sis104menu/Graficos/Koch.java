package com.example.sis104menu.Graficos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

public class Koch extends View {
    private static final String TAG = "Grafico";
    public Koch(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLACK);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();

        // Array of colors to use for different levels
        int[] colors = {
                Color.rgb(255, 182, 193), // Light Pink
                Color.rgb(255, 105, 180), // Pink
                Color.rgb(255, 20, 147),  // Hot Pink
                Color.rgb(255, 0, 127),   // Deep Pink
                Color.rgb(199, 21, 133),  // Medium Violet Red
                Color.rgb(219, 112, 147), // Pale Violet Red
                Color.rgb(218, 112, 214), // Orchid
        };

        drawKoch(canvas, 10, alto/2, ancho-10,alto/2, 4, paint, colors, 0);
    }
    private void drawKoch(Canvas canvas, int x1, int y1, int x5, int y5, int nivel, Paint paint, int[] colors, int colorIndex) {
        if(nivel == 0 ){
            paint.setColor(colors[colorIndex % colors.length]);
            canvas.drawLine(x1, y1, x5, y5, paint);
        }
        else{
            paint.setColor(colors[nivel % colors.length]);
            int deltaX = x5-x1;
            int deltaY = y5-y1;
            int x2 = x1 + deltaX/3;
            int y2 = y1 + deltaY/3;
            double x31 = ((x1+x5)/2) - Math.sqrt(3)/6*(y1-y5);
            double y31 = (y1+y5)/2 - Math.sqrt(3)/6*(x5-x1);
            int x3 = (int)x31;
            int y3 = (int)y31;
            int x4 = x1 + 2*deltaX/3;
            int y4 = y1 + 2*deltaY/3;
            int nextColorIndex = colorIndex + 1;
            drawKoch(canvas, x1, y1, x2, y2, nivel - 1, paint, colors, nextColorIndex);
            nextColorIndex += 1;
            drawKoch(canvas, x2, y2, x3, y3, nivel - 1, paint, colors, nextColorIndex);
            nextColorIndex += 1;
            drawKoch(canvas, x3, y3, x4, y4, nivel - 1, paint, colors, nextColorIndex);
            nextColorIndex += 1;
            drawKoch(canvas, x4, y4, x5, y5, nivel - 1, paint, colors, nextColorIndex);

        }
    }
}