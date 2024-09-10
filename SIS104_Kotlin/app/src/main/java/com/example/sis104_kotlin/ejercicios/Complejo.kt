package com.example.sis104_kotlin.ejercicios

//package com.example.proyectokotlin.ejercicios

class Complejo {
    var a: Double = 0.0
    var b: Double = 0.0
    var c: Double = 0.0
    var d: Double = 0.0

    constructor()

    constructor(a: Double, b: Double, c: Double, d: Double) {
        this.a = a
        this.b = b
        this.c = c
        this.d = d
    }

    fun suma(): String {
        val real = this.a + this.c
        val imag = this.b + this.d
        return if (imag < 0) {
            "$real$imag" + "i"
        } else {
            "$real+$imag" + "i"
        }
    }

    fun resta(): String {
        val real = this.a - this.c
        val imag = this.b - this.d
        return if (imag < 0) {
            "$real$imag" + "i"
        } else {
            "$real+$imag" + "i"
        }
    }

    fun multiplicar(): String {
        val real = this.a * this.c - this.b * this.d
        val imag = this.a * this.d + this.c * this.b
        return if (imag < 0) {
            "$real$imag" + "i"
        } else {
            "$real+$imag" + "i"
        }
    }

    fun dividir(): String {
        val aux = this.c * this.c + this.d * this.d
        val real = (this.a * this.c + this.b * this.d) / aux
        val imag = (this.b * this.c - this.a * this.d) / aux
        return if (imag < 0) {
            "$real$imag" + "i"
        } else {
            "$real+$imag" + "i"
        }
    }

    fun esNumeroValido(input: String): Boolean {
        val patronNumero = "^\\d+(\\.\\d+)?$"
        return input.matches(Regex(patronNumero))
    }
}