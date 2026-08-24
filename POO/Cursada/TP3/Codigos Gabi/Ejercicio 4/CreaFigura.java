import java.util.Random;
 
public class CreaFigura{
    public static void main (String [] args){
        Random unNumero = new Random();
        
        //Creamos el primer rectangulo
        
        punto origen1 = new punto (0,0);
        double ancho1 = unNumero.nextDouble () * 100.0;
        double alto1 = unNumero.nextDouble () * 100.0;
        
        Rectangulo rectangulo1 = new Rectangulo(origen1, ancho1, alto1); 
        
        rectangulo1.desplazar(40, -20);
        
        rectangulo1.mostrarDatos();
        
        punto origen2 = new punto (7.4,4.5);
        double ancho2 = unNumero.nextDouble () * 100.0;
        double alto2 = unNumero.nextDouble () * 100.0;
        
        Rectangulo rectangulo2 = new Rectangulo(origen2, ancho2, alto2);
        
        Rectangulo mayor = rectangulo1.elMayor(rectangulo2);
        
        mayor.mostrarDatos();
        
        System.out.println("Distancia entre rectangulos: "+ rectangulo1.distanciaA(rectangulo2));
    }
}