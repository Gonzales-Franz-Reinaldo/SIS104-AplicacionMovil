// main.dart

import 'package:flutter/material.dart';
import 'complejos.dart';

void main() {
  runApp(const Principal());
}

class Principal extends StatelessWidget {
  const Principal({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const CalculadoraComplejos(),
    );
  }
}

class CalculadoraComplejos extends StatefulWidget {
  const CalculadoraComplejos({super.key});

  @override
  _CalculadoraComplejosState createState() => _CalculadoraComplejosState();
}

class _CalculadoraComplejosState extends State<CalculadoraComplejos> {
  final TextEditingController _real1Controller = TextEditingController();
  final TextEditingController _imag1Controller = TextEditingController();
  final TextEditingController _real2Controller = TextEditingController();
  final TextEditingController _imag2Controller = TextEditingController();
  String _resultado = '';
  String _operacionSeleccionada = 'Suma';

  void _calcular() {
    final double? real1 = double.tryParse(_real1Controller.text);
    final double? imag1 = double.tryParse(_imag1Controller.text);
    final double? real2 = double.tryParse(_real2Controller.text);
    final double? imag2 = double.tryParse(_imag2Controller.text);

    if (real1 == null || imag1 == null || real2 == null || imag2 == null) {
      setState(() {
        _resultado = "Por favor ingrese valores numéricos válidos.";
      });
      return;
    }

    final numero1 = NumeroComplejo(real1, imag1);
    final numero2 = NumeroComplejo(real2, imag2);

    setState(() {
      switch (_operacionSeleccionada) {
        case 'Suma':
          _resultado = numero1.sumar(numero2);
          break;
        case 'Resta':
          _resultado = numero1.restar(numero2);
          break;
        case 'Multiplicación':
          _resultado = numero1.multiplicar(numero2);
          break;
        case 'División':
          _resultado = numero1.dividir(numero2);
          break;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Calculadora de Números Complejos"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              "Operaciones con Números Complejos",
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
              textAlign: TextAlign.center,
            ),
            const SizedBox(height: 16),
            TextField(
              controller: _real1Controller,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                labelText: "Parte Real 1",
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 8),
            TextField(
              controller: _imag1Controller,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                labelText: "Parte Imaginaria 1",
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 8),
            TextField(
              controller: _real2Controller,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                labelText: "Parte Real 2",
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 8),
            TextField(
              controller: _imag2Controller,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                labelText: "Parte Imaginaria 2",
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 16),
            DropdownButton<String>(
              value: _operacionSeleccionada,
              onChanged: (String? newValue) {
                setState(() {
                  _operacionSeleccionada = newValue!;
                });
              },
              items: <String>['Suma', 'Resta', 'Multiplicación', 'División']
                  .map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
            ),
            const SizedBox(height: 16),
            ElevatedButton(
              onPressed: _calcular,
              child: const Text("Calcular"),
              style: ElevatedButton.styleFrom(
                padding:
                    const EdgeInsets.symmetric(horizontal: 24, vertical: 12),
              ),
            ),
            const SizedBox(height: 16),
            Text(
              _resultado,
              style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              textAlign: TextAlign.center,
            ),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    _real1Controller.dispose();
    _imag1Controller.dispose();
    _real2Controller.dispose();
    _imag2Controller.dispose();
    super.dispose();
  }
}























// // main.dart

// import 'package:flutter/material.dart';
// import 'ecuacion_segundo_grado.dart';

// void main() {
//   runApp(const Principal());
// }

// class Principal extends StatelessWidget {
//   const Principal({super.key});

//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       theme: ThemeData(
//         primarySwatch: Colors.indigo,
//       ),
//       home: const EcuacionPage(),
//     );
//   }
// }

// class EcuacionPage extends StatefulWidget {
//   const EcuacionPage({super.key});

//   @override
//   _EcuacionPageState createState() => _EcuacionPageState();
// }

// class _EcuacionPageState extends State<EcuacionPage> {
//   final TextEditingController _aController = TextEditingController();
//   final TextEditingController _bController = TextEditingController();
//   final TextEditingController _cController = TextEditingController();
//   String _resultado = '';

//   void _resolverEcuacion() {

//     final double? a = double.tryParse(_aController.text);
//     final double? b = double.tryParse(_bController.text);
//     final double? c = double.tryParse(_cController.text);

//     if (a == null || b == null || c == null) {
//       setState(() {
//         _resultado = "Por favor ingrese valores numéricos válidos para a, b y c.";
//       });
//       return;
//     }

//     final ecuacion = EcuacionSegundoGrado();
//     setState(() {
//       _resultado = ecuacion.resolver(a, b, c);
//     });
//   }

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//         title: const Text("Ecuación de Segundo Grado"),
//       ),
//       body: Padding(
//         padding: const EdgeInsets.all(16.0),
//         child: Column(
//           mainAxisAlignment: MainAxisAlignment.center,
//           children: <Widget>[
//             const Text(
//               "Calculadora de Ecuación de Segundo Grado",
//               style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
//               textAlign: TextAlign.center,
//             ),
//             const SizedBox(height: 16),
//             TextField(
//               controller: _aController,
//               keyboardType: TextInputType.number,
//               decoration: const InputDecoration(
//                 labelText: "Coeficiente a",
//                 border: OutlineInputBorder(),
//               ),
//             ),
//             const SizedBox(height: 16),
//             TextField(
//               controller: _bController,
//               keyboardType: TextInputType.number,
//               decoration: const InputDecoration(
//                 labelText: "Coeficiente b",
//                 border: OutlineInputBorder(),
//               ),
//             ),
//             const SizedBox(height: 16),
//             TextField(
//               controller: _cController,
//               keyboardType: TextInputType.number,
//               decoration: const InputDecoration(
//                 labelText: "Coeficiente c",
//                 border: OutlineInputBorder(),
//               ),
//             ),
//             const SizedBox(height: 24),
//             ElevatedButton(
//               onPressed: _resolverEcuacion,
//               child: const Text("Calcular"),
//               style: ElevatedButton.styleFrom(
//                 padding: const EdgeInsets.symmetric(horizontal: 24, vertical: 12),
//               ),
//             ),
//             const SizedBox(height: 24),
//             Text(
//               _resultado,
//               style: const TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
//               textAlign: TextAlign.center,
//             ),
//           ],
//         ),
//       ),
//     );
//   }

//   @override
//   void dispose() {
//     _aController.dispose();
//     _bController.dispose();
//     _cController.dispose();
//     super.dispose();
//   }
// }


// numeros complejos de suma, resta, multiplicacion y division






















// import 'package:flutter/material.dart';
// import 'calculadora.dart';

// void main() {
//   runApp(const Principal());
// }

// class Principal extends StatelessWidget {
//   const Principal({super.key});

//   @override
//   Widget build(BuildContext context) {
//     return const MaterialApp(
//       home: Operaciones(),
//     );
//   }
// }

// // Elementos que cmabiaran de estado, clase donde cambiara de  estado
// class Operaciones extends StatefulWidget {
//   const Operaciones({super.key});

//   @override
//   _OperacionesState createState() => _OperacionesState();
// }

// class _OperacionesState extends State<Operaciones> {
//   final TextEditingController _caja1 = TextEditingController();
//   final TextEditingController _caja2 = TextEditingController();
//   int _resultado = 0;

//   void _sumar() {
//     final int numero1 = int.tryParse(_caja1.text) ?? 0;
//     final int numero2 = int.tryParse(_caja2.text) ?? 0;

//     final calculadora = Calculadora();
//     setState(() {
//       _resultado = calculadora.sumar(numero1, numero2);
//     });
//   }

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//         title: const Text('Suma de Dos Números'),
//       ),
//       body: Padding(
//         padding: const EdgeInsets.all(16.0),
//         child: Column(
//           mainAxisAlignment: MainAxisAlignment.center,
//           children: <Widget>[
//             TextField(
//               controller: _caja1,
//               keyboardType: TextInputType.number,
//               decoration: const InputDecoration(
//                 labelText: 'Número 1',
//               ),
//             ),
//             TextField(
//               controller: _caja2,
//               keyboardType: TextInputType.number,
//               decoration: const InputDecoration(
//                 labelText: 'Número 2',
//               ),
//             ),
//             ElevatedButton(
//               onPressed: _sumar,
//               child: const Text('Sumar'),
//             ),
//             Text(
//               'Resultado: $_resultado',
//               style: const TextStyle(fontSize: 24),
//             ),
//           ],
//         ),
//       ),
//     );
//   }

//   @override
//   void dispose() {
//     _caja1.dispose();
//     _caja2.dispose();
//     super.dispose();
//   }
// }





















// import 'package:flutter/material.dart';

// void main() {
//   runApp(const Principal());
// }

// class Principal extends StatelessWidget {
//   const Principal({Key? key}) : super(key: key);

//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: 'Carátula',
//       theme: ThemeData(
//         primarySwatch: Colors.blue,
//       ),
//       home: const CaratulaScreen(),
//     );
//   }
// }

// class CaratulaScreen extends StatelessWidget {
//   const CaratulaScreen({Key? key}) : super(key: key);

//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//         title: const Text('Carátula'),
//         centerTitle: true,
//         leading: IconButton(
//           icon: const Icon(Icons.account_circle),
//           onPressed: () {
//             // Acciones al presionar el icono (opcional)
//           },
//         ),
//       ),
//       body: SingleChildScrollView(
//         child: Padding(
//           padding: const EdgeInsets.all(16.0),
//           child: Column(
//             mainAxisAlignment: MainAxisAlignment.center,
//             crossAxisAlignment: CrossAxisAlignment.center,
//             children: [
//               Text(
//                 'Universidad San Francisco Xavier de Chuquisaca',
//                 style: TextStyle(
//                   fontSize: 32,
//                   fontWeight: FontWeight.bold,
//                   color: Colors.blueAccent,
//                 ),
//                 textAlign: TextAlign.center,
//               ),
//               const SizedBox(height: 10),
//               Text(
//                 'Facultad de Ciencias y Tecnología',
//                 style: TextStyle(
//                   fontSize: 24,
//                   fontWeight: FontWeight.w600,
//                   color: Colors.blueGrey,
//                 ),
//                 textAlign: TextAlign.center,
//               ),
//               const SizedBox(height: 20),
//               Text(
//                 'Materia: Aplicaciones Móviles SIS104',
//                 style: TextStyle(
//                   fontSize: 20,
//                   fontWeight: FontWeight.w500,
//                   color: Colors.black87,
//                 ),
//                 textAlign: TextAlign.center,
//               ),
//               const SizedBox(height: 20),
//               Text(
//                 'Nombres: Franz Reinaldo',
//                 style: TextStyle(
//                   fontSize: 18,
//                   fontWeight: FontWeight.normal,
//                   color: Colors.black54,
//                 ),
//                 textAlign: TextAlign.center,
//               ),
//               const SizedBox(height: 10),
//               Text(
//                 'Apellidos: Gonzales Suyo',
//                 style: TextStyle(
//                   fontSize: 18,
//                   fontWeight: FontWeight.normal,
//                   color: Colors.black54,
//                 ),
//                 textAlign: TextAlign.center,
//               ),
//               const SizedBox(height: 10),
//               Text(
//                 'Cédula: 12961519',
//                 style: TextStyle(
//                   fontSize: 18,
//                   fontWeight: FontWeight.normal,
//                   color: Colors.black54,
//                 ),
//                 textAlign: TextAlign.center,
//               ),
//               const SizedBox(height: 30),
//               ElevatedButton(
//                 onPressed: () {
//                   showDialog(
//                     context: context,
//                     builder: (BuildContext context) {
//                       return AlertDialog(
//                         title: const Text('Descripción de la Universidad'),
//                         content: const Text(
//                             'La Universidad San Francisco Xavier de Chuquisaca es una de las instituciones más prestigiosas de Bolivia, con una rica historia académica y cultural.'),
//                         actions: [
//                           TextButton(
//                             onPressed: () {
//                               Navigator.of(context).pop();
//                             },
//                             child: const Text('Cerrar'),
//                           ),
//                         ],
//                       );
//                     },
//                   );
//                 },
//                 child: const Text('Ver descripción de la Universidad'),
//               ),
//               const SizedBox(height: 10),
//               ElevatedButton(
//                 onPressed: () {
//                   showDialog(
//                     context: context,
//                     builder: (BuildContext context) {
//                       return AlertDialog(
//                         title: const Text('Descripción de la Facultad'),
//                         content: const Text(
//                             'La Facultad de Ciencias y Tecnología se especializa en la formación de profesionales en el área de la ingeniería y ciencias aplicadas, proporcionando educación de calidad.'),
//                         actions: [
//                           TextButton(
//                             onPressed: () {
//                               Navigator.of(context).pop();
//                             },
//                             child: const Text('Cerrar'),
//                           ),
//                         ],
//                       );
//                     },
//                   );
//                 },
//                 child: const Text('Ver descripción de la Facultad'),
//               ),
//               const SizedBox(height: 30),
//               SizedBox(
//                 height: 150,
//                 child: ListView(
//                   scrollDirection: Axis.horizontal,
//                   children: [
//                     Image.network(
//                       'https://usfx.bo/wp-content/uploads/2023/04/115730-Universidad-De-San-Francisco-Xavier-De-Chuquisaca-1.png',
//                       width: 250,
//                       fit: BoxFit.cover,
//                     ),
//                     const SizedBox(width: 10),
//                     Image.network(
//                       'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2cfyPBrJIOubx7ZWVs2BzmG23lGSnmfVm4g&s',
//                       width: 250,
//                       fit: BoxFit.cover,
//                     ),
//                     const SizedBox(width: 10),
//                     Image.network(
//                       'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSN7C5L5WvVjNmOfnSYMKvf-ebc15RSUgObQ&s',
//                       width: 250,
//                       fit: BoxFit.cover,
//                     ),
//                   ],
//                 ),
//               ),
//               const SizedBox(height: 30),
//               Text(
//                 'Sucre, Bolivia - 2024',
//                 style: TextStyle(
//                   fontSize: 16,
//                   fontStyle: FontStyle.italic,
//                   color: Colors.grey,
//                 ),
//                 textAlign: TextAlign.center,
//               ),
//             ],
//           ),
//         ),
//       ),
//     );
//   }
// }
