package com.example.sis104menu.Ejercicios;

public class Estadistica {
    private  int a;
    private  int b;
    private  int c;

    public Estadistica(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }



    public String barra(int n) {

        StringBuilder cad = new StringBuilder();

        for (int i = 0; i < n; i++) {
            cad.append("*");
        }
        return cad.toString();
    }




//    public String Grafico() {
//        StringBuilder cad = new StringBuilder();
//
//        int maximo = Math.max(Math.max(this.a, this.b), this.c);
//
//
//        int a = Math.max(1, (int) Math.round((this.a * 60.0) / maximo));
//
//        int b = Math.max(1, (int) Math.round((this.b * 60.0) / maximo));
//        int c = Math.max(1, (int) Math.round((this.c * 60.0) / maximo));
//
//        cad.append(barra(a)).append("\n");
//        cad.append(barra(b)).append("\n");
//        cad.append(barra(c)).append("\n");
//
//        return cad.toString();
//    }

    public String Grafico() {
        StringBuilder cad = new StringBuilder();

        // Obtener el valor máximo para determinar la altura de las barras.
        int maximo = Math.max(Math.max(this.a, this.b), this.c);

        // Calcular las alturas proporcionalmente con la regla de tres.
        int alturaA = Math.max(1, (int) Math.round((this.a * 60.0) / maximo));
        int alturaB = Math.max(1, (int) Math.round((this.b * 60.0) / maximo));
        int alturaC = Math.max(1, (int) Math.round((this.c * 60.0) / maximo));

        // Generar espacio superior.
        cad.append("\n\n");

        // Generar el gráfico desde la parte inferior hacia arriba.
        for (int i = 1; i <= 60; i++) {
            // Espacio para centrar las barras.
            cad.append("    ");

            // Primera barra (a)
            if (i > (60 - alturaA)) {
                cad.append("*");
            } else {
                cad.append(" ");
            }

            cad.append("   "); // Espacio entre barras

            // Segunda barra (b)
            if (i > (60 - alturaB)) {
                cad.append("*");
            } else {
                cad.append(" ");
            }

            cad.append("   "); // Espacio entre barras

            // Tercera barra (c)
            if (i > (60 - alturaC)) {
                cad.append("*");
            } else {
                cad.append(" ");
            }

            // Agregar salto de línea para cada fila.
            cad.append("\n");
        }

        return cad.toString();
    }


    //    private  String barra(int n){
//        String cad = "";
//        for(int i=0; i<n; i++){
//            cad+="*";
//        }
//        return cad;
//    }

//    public  String Grafico(){
//        String cad = "";
//
//        cad += barra(this.a)+"\n";
//        cad += barra(this.b)+"\n";
//        cad += barra(this.c)+"\n";
//
//        return cad;
//    }


    //    public String Grafico() {
//        StringBuilder cad = new StringBuilder();
//
//        int maximo = Math.max(Math.max(this.a, this.b), this.c);
//
//
//        int a = Math.max(1, (int) Math.round((this.a * 60.0) / maximo));
//
//        int b = Math.max(1, (int) Math.round((this.b * 60.0) / maximo));
//        int c = Math.max(1, (int) Math.round((this.c * 60.0) / maximo));
//
//        cad.append(barra(a)).append("\n");
//        cad.append(barra(b)).append("\n");
//        cad.append(barra(c)).append("\n");
//
//        return cad.toString();
//    }


}
