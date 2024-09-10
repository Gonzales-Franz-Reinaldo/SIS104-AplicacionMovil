package com.example.proyectokotlin.graficos

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlin.random.Random

class Barnsley(context: Context) : View(context) {

    private val paint = Paint().apply {
        strokeWidth = 2f
    }

    // Definir una lista de colores fuertes
    private val colors = listOf(
        Color.GREEN,
        Color.RED,
        Color.BLUE,
        Color.YELLOW,
        Color.CYAN,
        Color.MAGENTA,
        Color.rgb(255, 165, 0), // Naranja
        Color.rgb(128, 0, 128)  // Púrpura
    )

    private var x = 0f // Coordenada x inicial
    private var y = 0f // Coordenada y inicial

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.BLACK) // Fondo negro

        val width = width.toFloat()
        val height = height.toFloat()

        // Ajuste de escala y traslación para centrar el fractal en la pantalla
        val scaleX = width / 10
        val scaleY = height / 12
        val offsetX = width / 2
        val offsetY = height - 50f

        // Iterar para generar puntos del fractal
        for (i in 0..100000) {
            paint.color = colors.random() // Asignar un color aleatorio para cada punto
            drawBarnsleyPoint(canvas, x, y, scaleX, scaleY, offsetX, offsetY)
            nextPoint()
        }
    }

    private fun drawBarnsleyPoint(
        canvas: Canvas,
        x: Float,
        y: Float,
        scaleX: Float,
        scaleY: Float,
        offsetX: Float,
        offsetY: Float
    ) {
        // Transformar las coordenadas al espacio de la pantalla
        val px = x * scaleX + offsetX
        val py = offsetY - y * scaleY

        // Dibujar el punto
        canvas.drawPoint(px, py, paint)
    }

    private fun nextPoint() {
        val rand = Random.nextFloat()

        when {
            rand < 0.01 -> { // Función 1
                x = 0f
                y = 0.16f * y
            }
            rand < 0.86 -> { // Función 2
                val newX = 0.85f * x + 0.04f * y
                val newY = -0.04f * x + 0.85f * y + 1.6f
                x = newX
                y = newY
            }
            rand < 0.93 -> { // Función 3
                val newX = 0.2f * x - 0.26f * y
                val newY = 0.23f * x + 0.22f * y + 1.6f
                x = newX
                y = newY
            }
            else -> { // Función 4
                val newX = -0.15f * x + 0.28f * y
                val newY = 0.26f * x + 0.24f * y + 0.44f
                x = newX
                y = newY
            }
        }
    }
}
