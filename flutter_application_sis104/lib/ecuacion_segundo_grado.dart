// ecuacion_segundo_grado.dart

import 'dart:math';

class EcuacionSegundoGrado {

  String resolver(double a, double b, double c) {
    
    if (a == 0) {
      return "El coeficiente 'a' no puede ser cero en una ecuación de segundo grado.";
    }

    final discriminante = pow(b, 2) - (4 * a * c);

    // if(discriminante < 0) {
    //   return "No existen raíces reales para la ecuación de segundo grado.";
    // }

    if (discriminante > 0) {
      // Raíces Reales Distintas (Discriminante > 0)
      //Probamos con valores a=1, b=-3, c=2
      final x1 = (-b + sqrt(discriminante)) / (2 * a);
      final x2 = (-b - sqrt(discriminante)) / (2 * a);
      return "Raíces reales distintas: x1 = $x1, x2 = $x2";
    } else if (discriminante == 0) {
      // Raíces Reales Iguales (Discriminante = 0)
      // Con los valores a=1, b=-2, c=1
      final x = -b / (2 * a);
      return "Raíces reales iguales: x1 = x2 = $x";
    } else {
      // Raíces Imaginarias 
      // Con los valroes: a=1, b=2, c=5
      final parteReal = -b / (2 * a);
      final parteImaginaria = sqrt(-discriminante) / (2 * a);
      return "Raíces imaginarias: x1 = $parteReal + ${parteImaginaria}i, x2 = $parteReal - ${parteImaginaria}i";
    }
  
  }
}
