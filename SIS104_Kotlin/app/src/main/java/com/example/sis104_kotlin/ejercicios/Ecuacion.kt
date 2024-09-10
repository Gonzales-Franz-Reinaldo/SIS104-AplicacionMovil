package com.example.sis104_kotlin.ejercicios

import kotlin.math.sqrt

class Ecuacion(a: Double, b: Double, c: Double) {

    private var _a: Double = 0.0
    private var _b: Double = 0.0
    private var _c: Double = 0.0

    init {
        _a = a
        _b = b
        _c = c
    }

    private fun d(): Double{
        return _b * _b - 4 * _a * _c
    }


    public  fun Raices(): String{
        var s: String = ""
        var x1: Double = 0.0
        var x2: Double = 0.0

        if(d() == 0.0){
            x1 = -_b /(2*_a)
            x2 = x1
            s = "Raices x1 = x2 = $x1"
        }else if(d() > 0.0){
            x1 = (-_b + sqrt(d()))/(2*_a)
            x2 = (-_b - sqrt(d()))/(2*_a)
            s = "Raices: x1 = $x1, x2=$x2"
        }else{
            var real = -_b/(2*_a)
            var img = sqrt(-d())/(2*_a)
            s = "raices: x1= $real + $img i, x2 = $real - $img"
        }

        return s
    }
}