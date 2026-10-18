/**
 * Clase ejecutable para crear y manipular instancias de Rectangulo y Cuadrado.
 * 
 * @author Gabi
 * @version 1.0
 */
public class CreaFigura {

    public static void main(String[] args) {
        Punto origenCuadrado = new Punto(5.0, 3.0);
        Cuadrado cuadrado = new Cuadrado(origenCuadrado, 72.99);
        cuadrado.caracteristicas();

        System.out.println();

        Punto origenRectangulo = new Punto(1.0, 2.0);
        Rectangulo rectangulo = new Rectangulo(origenRectangulo, 15.0, 25.0);
        rectangulo.caracteristicas();
    }
}
