package com.example.proyectokotlin.graficos

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View

class Grafico2D(context: Context) : View(context) {

    companion object {
        private const val TAG = "Grafico"
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.BLACK)
        val paint = Paint().apply {
            color = Color.WHITE
        }

        val ancho = canvas.width
        val alto = canvas.height

        Log.d(TAG, "Ancho: $ancho Alto: $alto")

        // Dibujar ejes X e Y
        canvas.drawLine(0f, (alto / 2).toFloat(), ancho.toFloat(), (alto / 2).toFloat(), paint)
        canvas.drawLine((ancho / 2).toFloat(), 0f, (ancho / 2).toFloat(), alto.toFloat(), paint)

        val limInFx = -20f
        val limSupx = 20f
        val limInfy = -20f
        val limSupy = 20f

        paint.color = Color.YELLOW

        var x = limInFx
        while (x <= limSupx) {
            val y = fx(x)
            Log.d(TAG, "x: $x y: $y")
            val xt = (x - limInFx) / (limSupx - limInFx) * ancho
            val yt = alto - ((y - limInfy) / (limSupy - limInfy) * alto)
            Log.d(TAG, "xt: $xt yt: $yt")
            canvas.drawCircle(xt.toFloat(), yt.toFloat(), 3f, paint)
            x += 0.1f
        }
    }

    private fun fx(x: Float): Double {
        return x * Math.sin(x.toDouble())
    }
}
