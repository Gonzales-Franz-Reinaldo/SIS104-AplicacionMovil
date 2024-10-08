package com.example.proyectokotlin.ejercicios

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DivisionViewModel : ViewModel() {

    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> get() = _resultado

    fun dividir(a: Int, b: Int) {
        val resultado = procedimientoDivision(a, b)
        _resultado.value = resultado
    }


    fun procedimientoDivision(a: Int, b: Int): String {
        var resultado = ""
        var aux = 0
        var temp = 0
        var resultadoFinal = 0
        var residuo = a


//        resultado += "$a   |__$b __\n"
        var cocienteResult = "$a   |__$b __\n";
        resultado += cocienteResult

        val cadenaNumeros = a.toString()

        for (i in cadenaNumeros.indices) {

            val digito = cadenaNumeros[i].toString().toInt()

            aux = aux * 10 + digito

            if (aux >= b) {
                val cociente = aux / b
                val productoResta = cociente * b
                aux = aux - productoResta

                resultado += "-${productoResta}\n"
                resultado += "------\n"
                resultado += " $aux\n"


                resultadoFinal = resultadoFinal * 10 + cociente

            } else {
                if (resultadoFinal > 0) {
                    resultadoFinal = resultadoFinal * 10
                }
            }
        }


        resultado += "El resultado es: $resultadoFinal\n"

//        if (temp != 0) {
//            resultado += "El residuo es: $temp\n"
//        }

        return resultado
    }

}
