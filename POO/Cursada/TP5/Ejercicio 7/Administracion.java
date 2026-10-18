import java.util.ArrayList;

/**
 * Clase ejecutable para verificar el funcionamiento de la clase Jardin y las figuras
 * geométricas según la consigna del Trabajo Práctico 5 Ejercicio 7.
 * 
 * Instancia distintas figuras simulando lo que desea pintar el jardín "Bichito de Luz"
 * y emite el presupuesto detallado con la superficie total y la cantidad de latas
 * de pintura a comprar.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Administracion {

    public static void main(String[] args) {
        // Instanciación de las distintas figuras geométricas que se pintarán en el piso
        // Se utilizan los valores de prueba de la consigna:
        // - Cuadrado de lado 5.0 -> Superficie = 25.00
        // - Triángulo de base 2.0 y altura 1.28 -> Superficie = 1.28
        // - Círculo de radio 2.0 -> Superficie = 12.57
        // - Elipse de semiejes 5.0 y 3.0 -> Superficie = 47.12
        Punto origenCuadrado = new Punto(0.0, 0.0);
        Cuadrado cuadrado = new Cuadrado(origenCuadrado, 5.0);

        Punto origenTriangulo = new Punto(0.0, 0.0);
        Triangulo triangulo = new Triangulo(origenTriangulo, 2.0, 1.28);

        Punto centroCirculo = new Punto(0.0, 0.0);
        Circulo circulo = new Circulo(2.0, centroCirculo);

        Punto centroElipse = new Punto(0.0, 0.0);
        Elipse elipse = new Elipse(5.0, 3.0, centroElipse);

        ArrayList<FiguraGeometrica> figuras = new ArrayList<FiguraGeometrica>();
        figuras.add(cuadrado);
        figuras.add(triangulo);
        figuras.add(circulo);
        figuras.add(elipse);

        Jardin jardin = new Jardin("Bichito de Luz", figuras);

        jardin.detalleFiguras();
    }
}
