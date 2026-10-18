/**
 * Clase ejecutable para verificar el funcionamiento de las clases Elipse y
 * Circulo
 * según la consigna del Trabajo Práctico 5 Ejercicio 4.
 * 
 * @author Gabi
 * @version 1.0
 */
public class MainCirculo {

    public static void main(String[] args) {
        Punto centroElipse = new Punto(5.0, 3.0);
        Elipse elipse = new Elipse(20.44, 46.86, centroElipse);

        elipse.caracteristicas();

        System.out.println();

        Punto centroCirculo = new Punto(5.0, 3.0);
        Circulo circulo = new Circulo(10.0, centroCirculo);
        circulo.caracteristicas();

        System.out.println();
        System.out.println("--- Después de desplazar (+2, +2) ---");
        elipse.desplazar(2.0, 2.0);
        circulo.desplazar(2.0, 2.0);

        elipse.caracteristicas();
        System.out.println();
        circulo.caracteristicas();
    }
}
