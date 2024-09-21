package com.example.proyectokotlin.examen

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class TrianguloView @JvmOverloads constructor(
    context: Context,
    private var size: Float, // Tamaño introducido
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint: Paint = Paint().apply {
        style = Paint.Style.FILL
        isAntiAlias = true
        color = 0xFF0000FF.toInt() // Color azul
    }

    private val path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Obtener el tamaño disponible en la pantalla
        val availableWidth = width.toFloat()
        val availableHeight = height.toFloat()

        // Ajustar el tamaño del triángulo al tamaño máximo permitido por la pantalla
        val maxSize = minOf(availableWidth, availableHeight)
        size = minOf(size, maxSize) // Ajusta el tamaño si es mayor al permitido

        // Definir los puntos del triángulo según el tamaño ajustado
        val halfSize = size / 2

        path.reset()
        path.moveTo(availableWidth / 2, (availableHeight / 2) - halfSize) // Punto superior
        path.lineTo((availableWidth / 2) - halfSize, (availableHeight / 2) + halfSize) // Punto inferior izquierdo
        path.lineTo((availableWidth / 2) + halfSize, (availableHeight / 2) + halfSize) // Punto inferior derecho
        path.close()

        // Dibujar el triángulo
        canvas.drawPath(path, paint)
    }
}
