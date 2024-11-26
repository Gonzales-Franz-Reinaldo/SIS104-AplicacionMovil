
class NumeroComplejo {
  final double real;
  final double imaginario;

  NumeroComplejo(this.real, this.imaginario);

  String sumar(NumeroComplejo otro) {
    final resultadoReal = real + otro.real;
    final resultadoImaginario = imaginario + otro.imaginario;
    return "${resultadoReal.toStringAsFixed(2)} + ${resultadoImaginario.toStringAsFixed(2)}i";
  }

  String restar(NumeroComplejo otro) {
    final resultadoReal = real - otro.real;
    final resultadoImaginario = imaginario - otro.imaginario;
    return "${resultadoReal.toStringAsFixed(2)} + ${resultadoImaginario.toStringAsFixed(2)}i";
  }

  String multiplicar(NumeroComplejo otro) {
    final resultadoReal = (real * otro.real) - (imaginario * otro.imaginario);
    final resultadoImaginario = (real * otro.imaginario) + (imaginario * otro.real);
    return "${resultadoReal.toStringAsFixed(2)} + ${resultadoImaginario.toStringAsFixed(2)}i";
  }

  String dividir(NumeroComplejo otro) {
    final denominador = (otro.real * otro.real) + (otro.imaginario * otro.imaginario);
    if (denominador == 0) {
      return "Error: División por cero en el denominador.";
    }
    final resultadoReal = ((real * otro.real) + (imaginario * otro.imaginario)) / denominador;
    final resultadoImaginario = ((imaginario * otro.real) - (real * otro.imaginario)) / denominador;
    return "${resultadoReal.toStringAsFixed(2)} + ${resultadoImaginario.toStringAsFixed(2)}i";
  }
}


// Para probar cada operación:

// Suma:

// Ejemplo: Real1 = 3, Imag1 = 4, Real2 = 2, Imag2 = -1
// Resultado esperado: 5.00 + 3.00i
// Resta:

// Ejemplo: Real1 = 5, Imag1 = 7, Real2 = 3, Imag2 = 4
// Resultado esperado: 2.00 + 3.00i
// Multiplicación:

// Ejemplo: Real1 = 1, Imag1 = 2, Real2 = 3, Imag2 = 4
// Resultado esperado: -5.00 + 10.00i
// División:

// Ejemplo: Real1 = 2, Imag1 = 3, Real2 = 4, Imag2 = -5
// Resultado esperado: -0.13 + 0.61i
// Caso especial: Si Real2 y Imag2 son ambos cero, muestra `Error: División por

// valores que coincidan para las cuatro opercaiones son:
// Real1 = 1, Imag1 = 2, Real2 = 3, Imag 2 = 4







