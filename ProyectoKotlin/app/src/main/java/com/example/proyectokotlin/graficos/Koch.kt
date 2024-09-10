package com.example.proyectokotlin.graficos

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Koch(context: Context) : View(context) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.BLACK)
        val paint = Paint().apply {
            color = Color.WHITE
        }

        val ancho = canvas.width
        val alto = canvas.height

        // Array de colores para usar en diferentes niveles
        val colors = arrayOf(
            Color.rgb(255, 182, 193), // Light Pink
            Color.rgb(255, 105, 180), // Pink
            Color.rgb(255, 20, 147),  // Hot Pink
            Color.rgb(255, 0, 127),   // Deep Pink
            Color.rgb(199, 21, 133),  // Medium Violet Red
            Color.rgb(219, 112, 147), // Pale Violet Red
            Color.rgb(218, 112, 214)  // Orchid
        )

        drawKoch(canvas, 10, alto / 2, ancho - 10, alto / 2, 4, paint, colors, 0)
    }

    private fun drawKoch(
        canvas: Canvas,
        x1: Int, y1: Int,
        x5: Int, y5: Int,
        nivel: Int,
        paint: Paint,
        colors: Array<Int>,
        colorIndex: Int
    ) {
        if (nivel == 0) {
            paint.color = colors[colorIndex % colors.size]
            canvas.drawLine(x1.toFloat(), y1.toFloat(), x5.toFloat(), y5.toFloat(), paint)
        } else {
            paint.color = colors[nivel % colors.size]
            val deltaX = x5 - x1
            val deltaY = y5 - y1
            val x2 = x1 + deltaX / 3
            val y2 = y1 + deltaY / 3
            val x31 = ((x1 + x5) / 2) - Math.sqrt(3.0) / 6 * (y1 - y5)
            val y31 = (y1 + y5) / 2 - Math.sqrt(3.0) / 6 * (x5 - x1)
            val x3 = x31.toInt()
            val y3 = y31.toInt()
            val x4 = x1 + 2 * deltaX / 3
            val y4 = y1 + 2 * deltaY / 3
            var nextColorIndex = colorIndex + 1
            drawKoch(canvas, x1, y1, x2, y2, nivel - 1, paint, colors, nextColorIndex)
            nextColorIndex += 1
            drawKoch(canvas, x2, y2, x3, y3, nivel - 1, paint, colors, nextColorIndex)
            nextColorIndex += 1
            drawKoch(canvas, x3, y3, x4, y4, nivel - 1, paint, colors, nextColorIndex)
            nextColorIndex += 1
            drawKoch(canvas, x4, y4, x5, y5, nivel - 1, paint, colors, nextColorIndex)
        }
    }
}
