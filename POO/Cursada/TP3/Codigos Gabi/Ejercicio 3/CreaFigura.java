import java.util.Random;

/**
 * Clase ejecutable para crear, desplazar, comparar y medir distancias entre
 * objetos de tipo Circulo.
 * 
 * @author Gabi
 * @version 1.0
 */
public class CreaFigura {

    /**
     * Método principal que realiza demostraciones y cálculos con círculos.
     * 
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        Random unNumero = new Random();

        Punto p1 = new Punto(0, 0);
        double radio1 = unNumero.nextDouble() * 100.0;

        Circulo circulo1 = new Circulo(radio1, p1);

        circulo1.desplazar(-240, -230);

        circulo1.caracteristicas();

        Punto p2 = new Punto(5.2, 0.5);
        double radio2 = unNumero.nextDouble() * 100.0;

        Circulo circulo2 = new Circulo(radio2, p2);

        Circulo mayor = circulo1.elMayor(circulo2);

        mayor.caracteristicas();

        System.out.println("Distancia entre circulos: " + circulo1.distanciaA(circulo2));
    }
}