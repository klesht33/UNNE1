package Cursada.TP1;


public class CircunferenciaWhile {
    
    float radio;
    float area;
    float perimetro;


   public CircunferenciaWhile(float radio){
            this.radio = radio;
            area = (float) (Math.PI * Math.pow(radio, 2));
            perimetro = (float) (2 * Math.PI * radio);

            System.out.println("El area de la circunferencia es: " + area);
            System.out.println("El perimetro de la circunferencia es: " + perimetro);
    }
}
