/**
 * Clase ejecutable alternativa para crear y manipular instancias de Elipse y Circulo.
 * 
 * @author Gabi
 * @version 1.0
 */
public class CreaFigura {

    public static void main(String[] args) {
        Punto centroElipse = new Punto(5.0, 3.0);
        Elipse elipse = new Elipse(20.44, 46.86, centroElipse);
        elipse.caracteristicas();

        System.out.println();

        Punto centroCirculo = new Punto(2.0, 4.0);
        Circulo circulo = new Circulo(10.0, centroCirculo);
        circulo.caracteristicas();

        System.out.println();

        Elipse mayor = elipse.elMayor(circulo);
        System.out.println("Mayor superficie: " + mayor.nombreFigura());
        System.out.println("Distancia entre centros: " + elipse.distanciaA(circulo));
    }
}
