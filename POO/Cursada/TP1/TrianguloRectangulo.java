package Cursada.TP1;

public class TrianguloRectangulo {
    
    float a;
    float b;
    float hipotenusa;

    public TrianguloRectangulo(float a, float b, float hipotenusa){

        this.a= a;
        this.b= b;
        this.hipotenusa = hipotenusa;

        if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(hipotenusa, 2)){
            System.out.println("El triangulo es rectangulo");
        } else{
            System.out.println("El triangulo no es rectangulo");
        }
    }
}
