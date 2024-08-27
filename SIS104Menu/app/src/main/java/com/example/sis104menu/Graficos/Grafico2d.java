package com.example.sis104menu.Graficos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class Grafico2d  extends View {
    private static final  String TAG = "Grafico";


    public Grafico2d(Context context) {
        super(context);
    }

     public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

         canvas.drawColor(Color.BLACK);
         Paint paint = new Paint();
         paint.setColor(Color.WHITE);


         int ancho = canvas.getWidth();
         int alto = canvas.getHeight();

         Log.d(TAG, "Ancho: " + ancho + " Alto: " + alto);

         canvas.drawLine(0, alto/2, ancho, alto/2, paint);
         canvas.drawLine(ancho/2, 0, ancho/2, alto, paint);

         float limInFx = -20;
         float limSupx = 20;
         float limInfy = -20;
         float limSupy = 20;

         paint.setColor(Color.YELLOW);

         for (float x = limInFx; x <= limSupx; x+= 0.1){
             double y = fx(x);
             Log.d(TAG, "x: " + x + " y: " + y);
             double xt = (x -limInFx) / (limSupx - limInFx) * ancho;
             double yt =alto - ((y - limInfy) / (limSupy - limInfy) * alto);
             Log.d(TAG, "xt: " + xt + " yt: " + yt);
             canvas.drawCircle((float) xt, (float) yt, 3, paint);
         }

     }

    private Double fx(float x){
        return x * Math.sin(x);
    }


}
