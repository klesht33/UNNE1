/**
 * Clase ejecutable para probar las figuras Rectangulo y Cuadrado según el Trabajo Práctico 5 Ejercicio 3.
 * 
 * @author Gabi
 * @version 1.0
 */
public class MainCuadrado {

    public static void main(String[] args) {
        // Instancia de Cuadrado con los datos de ejemplo de la consigna
        Punto puntoOrigen = new Punto(5.0, 3.0);
        double ladoCuadrado = 72.99;
        Cuadrado cuadrado = new Cuadrado(puntoOrigen, ladoCuadrado);

        cuadrado.caracteristicas();

        System.out.println();

        // Instancia de Rectangulo para verificar polimorfismo y funcionamiento de ambas clases
        Rectangulo rectangulo = new Rectangulo(new Punto(2.0, 1.0), 10.0, 20.0);
        rectangulo.caracteristicas();
    }
}
