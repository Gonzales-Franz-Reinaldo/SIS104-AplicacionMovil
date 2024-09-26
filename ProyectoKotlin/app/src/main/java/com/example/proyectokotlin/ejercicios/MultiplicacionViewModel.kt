package com.example.proyectokotlin.ejercicios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MultiplicacionViewModel : ViewModel() {
    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> get() = _resultado

    fun multiplicar(a: Int, b: Int) {
        val resultado = procedimientoMultiplicacion(a, b)
        _resultado.value = resultado
    }

    private fun procedimientoMultiplicacion(a: Int, b: Int): String {
        val strA = a.toString()
        val strB = b.toString()
        val sb = StringBuilder()

        // Alinear los números
        sb.append(" ".repeat(strB.length + 1))
        sb.append(strA.chunked(1).joinToString("     ")).append("\n")
        sb.append("x".padStart(strB.length + 1))
        sb.append(strB.chunked(1).joinToString("     ")).append("\n")
        sb.append("-".repeat((maxOf(strA.length, strB.length) + 2) * 5)).append("\n")

        // Calcular las multiplicaciones parciales
        val resultados = mutableListOf<String>()
        for (i in strB.indices.reversed()) {
            val digito = strB[i].toString().toInt()
            val resultado = a * digito
            val strResultado = resultado.toString().padStart(strA.length, '0')
            resultados.add(strResultado.padStart(strResultado.length + strB.length - 1 - i, ' '))
        }

        // Mostrar los resultados parciales
        for (i in resultados.indices) {
            if (i > 0) sb.append("+")
            sb.append(resultados[i].chunked(1).joinToString("     ")).append("\n")
        }

        // Línea de separación antes del resultado final
        sb.append("-".repeat((maxOf(strA.length, strB.length) + 2) * 5)).append("\n")

        // Calcular y mostrar la suma final
        val sumaFinal = a * b
        val strSumaFinal = sumaFinal.toString()
        sb.append(" ".repeat(maxOf(0, strB.length - strSumaFinal.length + 1)))  // Ajustar alineación del resultado final
        sb.append(strSumaFinal.chunked(1).joinToString("     "))

        return sb.toString()
    }
}