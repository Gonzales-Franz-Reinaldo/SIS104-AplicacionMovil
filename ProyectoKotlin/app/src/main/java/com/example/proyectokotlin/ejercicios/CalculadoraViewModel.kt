package com.example.proyectokotlin.ejercicios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculadoraViewModel: ViewModel() {
    private val _resultado = MutableLiveData<String>()
    val resultado : LiveData<String> get() = _resultado

    fun calcular(num1: Double, num2: Double, operacion: String) {
        val calculadora = Calculadora(num1, num2)

        val adicionar = calculadora.adicionar()
        val restar = calculadora.restar()
        val multiplicar = calculadora.multiplicar()
        val dividir = calculadora.dividir()

        val res = StringBuilder()
            .append("Suma: $adicionar\n")
            .append("Resta: $restar\n")
            .append("Multiplicación: $multiplicar\n")
            .append("División: $dividir")
//            .append("División: ${dividir ? : "No se puede dividir entre 0"}")
            .toString()
        _resultado.value = res
    }

    fun calcular(num1: Double, num2: Double) {
        TODO("Not yet implemented")
    }

}