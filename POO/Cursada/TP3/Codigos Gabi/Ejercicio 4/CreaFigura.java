import java.util.Random;

/**
 * Clase ejecutable para crear, desplazar, comparar y calcular distancias entre
 * instancias de Rectangulo.
 * 
 * @author Gabi
 * @version 1.0
 */
public class CreaFigura {

    /**
     * Método principal que instancia y manipula rectángulos.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        Random unNumero = new Random();

        // Creamos el primer rectangulo

        Punto origen1 = new Punto(0, 0);
        double ancho1 = unNumero.nextDouble() * 100.0;
        double alto1 = unNumero.nextDouble() * 100.0;

        Rectangulo rectangulo1 = new Rectangulo(origen1, ancho1, alto1);

        rectangulo1.desplazar(40, -20);

        rectangulo1.mostrarDatos();

        Punto origen2 = new Punto(7.4, 4.5);
        double ancho2 = unNumero.nextDouble() * 100.0;
        double alto2 = unNumero.nextDouble() * 100.0;

        Rectangulo rectangulo2 = new Rectangulo(origen2, ancho2, alto2);

        Rectangulo mayor = rectangulo1.elMayor(rectangulo2);

        mayor.mostrarDatos();

        System.out.println("Distancia entre rectangulos: " + rectangulo1.distanciaA(rectangulo2));
    }
}