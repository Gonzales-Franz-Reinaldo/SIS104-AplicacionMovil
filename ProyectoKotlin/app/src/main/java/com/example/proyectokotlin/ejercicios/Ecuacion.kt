package com.example.proyectokotlin.ejercicios

import java.util.function.DoubleConsumer
import kotlin.math.sqrt

class Ecuacion(a : Double, b: Double,c:  Double) {
    private var _a: Double = 0.0
    private var _b: Double = 0.0
    private var _c: Double = 0.0

    init{
        _a = a
        _b = b
        _c = c
    }
    private fun discriminante(): Double{
        return _b*_b - 4 * _a * _c
    }

    public fun Raices(): String{
        var s:String = ""
        var x1:Double = 0.0
        var x2:Double = 0.0
        if(discriminante() == 0.0){
            x1 = - _b / (2 * _a)
            x2 = x1
            s =  "Raices x1 = x2 $x1"

        }
        else{
            if(discriminante()>0.0){
                x1 = (-_b + sqrt(discriminante())/(2 * _a))
                x2 = (-_b - sqrt(discriminante())/(2 * _a))
                s = "X1 = $x1 X2 = $x2"
            }
            else{
                var real=-_b/(2*_a)
                var imag=sqrt(-discriminante())/(2*_a)
                s="Raices : x1=$real+$imag i, x2=$real-$imag i "
            }
        }
        return s
    }
    fun esNumeroValido(input: String): Boolean {
        val patronNumero = "^\\d+(\\.\\d+)?$"
        return input.matches(Regex(patronNumero))
    }


}