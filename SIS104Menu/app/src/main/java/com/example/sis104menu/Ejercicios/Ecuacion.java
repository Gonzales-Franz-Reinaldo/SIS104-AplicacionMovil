package com.example.sis104menu.Ejercicios;

public class Ecuacion {
    private  Double a;
    private  Double b;
    private  Double c;

    public Ecuacion(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    private Double D(){
        return  (this.b * this.b) - (4 * this.a * this.c);
    }

    public String Raices(){
        String solucion;
        if(D() == 0){
            Double x = - this.b /(2*this.a);
            solucion = "X1 = X2 = " + x;
        }else {
            if(D() > 0){
                Double x1 = (-this.b + Math.sqrt(D())/(2 * this.a));
                Double x2 = (-this.b - Math.sqrt(D())/(2 * this.a));
                solucion = "X1 = "+x1+"\n x2 = "+x2;
            }else {
                Double parteReal = -this.b/(2*this.a);
                Double parteImag = Math.sqrt(Math.abs(D()))/(2*this.a);
                solucion = "x1=" + parteReal+ "-"+parteImag + "\n x2 = "+parteReal+ "+" + parteImag + "i";
            }
        }

        return solucion;
    }
}
