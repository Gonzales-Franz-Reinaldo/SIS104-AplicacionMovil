package com.example.applicationsis104;

public class Complejos {

    private double a;
    private double b;
    private double c;
    private double d;

    public Complejos(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    private String calcularResultado(double real, double imag) {
        String resultado;
        if (imag >= 0) {
            resultado = real + " + " + imag + "i";
        } else {
            resultado = real + " - " + Math.abs(imag) + "i";
        }

        return resultado;
    }

    public String suma(){
//        String resultado;

        Double real = this.a + this.c;
        Double imag = this.b + this.d;


        return calcularResultado(real, imag);
    }

    public String resta(){
        Double real = this.a - this.c;
        Double imag = this.b - this.d;

//        String resultado = real + "+" + imag + "i";

        return calcularResultado(real, imag);
    }

    public String multiplicacion(){
        Double real = (this.a * this.c) - (this.b * this.d);
        Double imag = (this.a * this.d) + (this.b * this.c);

//        String resultado = real + "+" + imag + "i";

        return calcularResultado(real, imag);
    }

    public String division(){
        Double aux = this.c * this.c + this.d * this.d;
        Double real = (this.a * this.c + this.b * this.d) / aux;
        Double imag = (this.b * this.c - this.a * this.d) / aux;

//        String resultado = real + "+" + imag + "i";

        return calcularResultado(real, imag);
    }
}
