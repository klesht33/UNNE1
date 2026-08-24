import java.util.Random;

public class CreaFigura{

    public static void main(String [] args){
        Random unNumero = new Random ();
        
        //Crear el primer circulo en (0,0)
        punto p1 = new punto(0,0);
        double radio1 = unNumero.nextDouble () * 100.0;
        
        Circulo circulo1 = new Circulo (radio1, p1);
        
        //Desplazar 240 a la izquierda y 230 hacia abajo
        
        circulo1.desplazar(-240, -230);
        
        //Mostrar caracteristicas del primer circulo 
        
        circulo1.caracteristicas();
        
        //Crear el segundo circulo en (5.2, 0.5)
        
        punto p2 = new punto (5.2, 0.5);
        double radio2 = unNumero.nextDouble() * 100.0;
        
        Circulo circulo2 = new Circulo (radio2 , p2);
        
        //Obtener el mayor
        
        Circulo mayor = circulo1.elMayor(circulo2);
        
        //Mostrar caracteristicas del mayor
        
        mayor.caracteristicas();
        
        //Mostrar distancia entre los circulos
        
        System.out.println ("Distancia entre circulos: " + circulo1.distanciaA(circulo2));
    }
}