package com.example.proyectokotlin.examen

class Suma(private val a: Int, private val b: Int) {

    fun sumarConAcarreo(): List<String> {
        val strA = a.toString().padStart(4, '0') // Rellenar con ceros si son menos de 4 dígitos
        val strB = b.toString().padStart(4, '0') // Rellenar con ceros si son menos de 4 dígitos

        val resultado = mutableListOf<Int>()
        val acarreo = mutableListOf<Int>()

        var carry = 0

        // Realizar la suma dígito por dígito de derecha a izquierda
        for (i in 3 downTo 0) {
            val suma = (strA[i].toString().toInt() + strB[i].toString().toInt()) + carry
            if (suma >= 10) {
                resultado.add(0, suma % 10)
                carry = suma / 10
            } else {
                resultado.add(0, suma)
                carry = 0
            }
            acarreo.add(0, carry)
        }

        // Convertir las listas en strings para cada fila
        val fila1 = strA.chunked(1).joinToString(" ")
        val fila2 = strB.chunked(1).joinToString(" ")
        val fila3 = acarreo.joinToString(" ")
        val fila4 = resultado.joinToString(" ")

        return listOf(fila1, fila2, fila3, fila4)
    }
}
