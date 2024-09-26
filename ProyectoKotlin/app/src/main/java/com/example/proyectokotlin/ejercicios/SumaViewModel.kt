package com.example.proyectokotlin.ejercicios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SumaViewModel : ViewModel() {
    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> get() = _resultado

    fun sumar(a: Int, b: Int) {
        val resultado = procedimientoSuma(a, b)
        _resultado.value = resultado
    }

    private fun procedimientoSuma(a: Int, b: Int): String {
        // Convertir los números a cadenas de texto
        val strA = a.toString()
        val strB = b.toString()

        // Llenar con ceros a la izquierda para igualar las longitudes
        val maxLength = maxOf(strA.length, strB.length)
        val numA = strA.padStart(maxLength, '0')
        val numB = strB.padStart(maxLength, '0')

        // Variables para el resultado y el carry
        var carry = 0
        val resultado = StringBuilder()
        val carrys = mutableListOf<Int?>()

        // Sumar de derecha a izquierda
        for (i in (maxLength - 1) downTo 0) {
            val digitA = numA[i].digitToInt()
            val digitB = numB[i].digitToInt()

            val suma = digitA + digitB + carry
            val resultadoDigito = suma % 10
            carry = suma / 10

            resultado.append(resultadoDigito)

            // Si hay carry, lo guardamos, pero solo si no es el primer dígito
            if (i > 0) {
                carrys.add(if (carry > 0) carry else null)
            }
        }

        // Si al final hay un carry, lo añadimos
        if (carry > 0) {
            resultado.append(carry)
            carrys.add(carry)
        }

        // Invertir el resultado para que esté en el orden correcto
        resultado.reverse()

        // Crear la salida formateada
        val sb = StringBuilder()

        // Agregar los carrys (solo desde el segundo dígito hacia la izquierda)
        if (carrys.any { it != null }) {
            val carryString = carrys.reversed().map { it?.toString() ?: " " }.joinToString(" ")
            sb.append(" ".repeat(maxLength - carryString.split(" ").size + 1)) // Alineamos el carry
            sb.append(carryString).append("\n")
        }

        // Agregar el número A
        sb.append(numA.chunked(1).joinToString(" ")).append("\n")

        // Agregar el número B sin los ceros a la izquierda
        val trimmedNumB = " ".repeat(maxLength - strB.length) + strB.chunked(1).joinToString(" ")
        sb.append("+").append(trimmedNumB).append("\n")

        // Separador de suma
        sb.append("--".repeat(maxLength * 2)).append("\n")

        // Agregar el resultado final
        sb.append(resultado.chunked(1).joinToString(" "))

        return sb.toString()
    }
}
