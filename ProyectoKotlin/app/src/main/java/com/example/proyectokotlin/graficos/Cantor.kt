package com.example.proyectokotlin.graficos

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Cantor(context: Context) : View(context) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.BLACK)
        val paint = Paint().apply {
            color = Color.WHITE
        }

        val ancho = canvas.width
        val alto = canvas.height

        drawCantor(canvas, 10, alto / 2, ancho - 10, 4, paint)
    }

    private fun drawCantor(canvas: Canvas, x: Int, y: Int, ancho: Int, nivel: Int, paint: Paint) {
        if (nivel <= 0) {
            return
        }

        canvas.drawLine(x.toFloat(), y.toFloat(), (x + ancho).toFloat(), y.toFloat(), paint)
        val newY = y + 30

        drawCantor(canvas, x, newY, ancho / 3, nivel - 1, paint)
        drawCantor(canvas, x + 2 * (ancho / 3), newY, ancho / 3, nivel - 1, paint)
    }
}
