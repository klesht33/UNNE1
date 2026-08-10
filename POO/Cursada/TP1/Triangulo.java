package Cursada.TP1;

public class Triangulo {

    float a;
    float b;
    float c;

    float area;
    float semiperimetro;
    float perimetro;

    public Triangulo(float a, float b, float c){

        this.a = a;
        this.b = b;
        this.c = c;

        semiperimetro = (a + b + c) / 2;
        perimetro = a + b + c;

        area = (float) Math.sqrt(semiperimetro * (semiperimetro - a) * (semiperimetro - b) * (semiperimetro - c));



    }
    
}
