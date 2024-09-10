package com.example.sis104menu.Graficos

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class SierpinskiTriangle(context: Context) : View(context) {

    private val paint = Paint().apply {
        strokeWidth = 2f
    }

    // Definir una lista de colores fuertes
    private val colors = listOf(
        Color.RED,
        Color.GREEN,
        Color.BLUE,
        Color.YELLOW,
        Color.CYAN,
        Color.MAGENTA,
        Color.rgb(255, 165, 0), // Naranja
        Color.rgb(128, 0, 128)  // Púrpura
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.BLACK)

        // Definir los tres vértices iniciales del triángulo equilátero
        val width = width
        val height = height

        val p1 = Pair(width / 2f, 50f) // Punto superior
        val p2 = Pair(50f, height - 50f) // Punto inferior izquierdo
        val p3 = Pair(width - 50f, height - 50f) // Punto inferior derecho

        // Dibujar el triángulo de Sierpinski
        drawSierpinski(canvas, p1, p2, p3, 5) // Profundidad de recursión = 5
    }

    private fun drawSierpinski(
        canvas: Canvas,
        p1: Pair<Float, Float>,
        p2: Pair<Float, Float>,
        p3: Pair<Float, Float>,
        depth: Int
    ) {
        if (depth == 0) {
            // Asignar un color aleatorio de la lista para cada línea
            paint.color = colors.random()
            canvas.drawLine(p1.first, p1.second, p2.first, p2.second, paint)

            paint.color = colors.random()
            canvas.drawLine(p2.first, p2.second, p3.first, p3.second, paint)

            paint.color = colors.random()
            canvas.drawLine(p3.first, p3.second, p1.first, p1.second, paint)
        } else {
            // Calcular los puntos medios de los lados del triángulo
            val mid1 = midpoint(p1, p2)
            val mid2 = midpoint(p2, p3)
            val mid3 = midpoint(p3, p1)

            // Dibujar los tres triángulos recursivamente
            drawSierpinski(canvas, p1, mid1, mid3, depth - 1)
            drawSierpinski(canvas, mid1, p2, mid2, depth - 1)
            drawSierpinski(canvas, mid3, mid2, p3, depth - 1)
        }
    }

    private fun midpoint(p1: Pair<Float, Float>, p2: Pair<Float, Float>): Pair<Float, Float> {
        return Pair((p1.first + p2.first) / 2, (p1.second + p2.second) / 2)
    }
}
