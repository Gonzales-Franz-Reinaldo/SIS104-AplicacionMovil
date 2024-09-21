package com.example.proyectokotlin.examen

class SumaRecursiva {
    fun sumar(a: Double, b: Double): Double {
        return if (b == 0.0) {
            a
        } else {
             sumar(a + 1, b - 1)
        }
    }
}