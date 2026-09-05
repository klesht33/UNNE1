/**
 * Clase ejecutable para gestionar y probar el stock de productos y su
 * interacción con Laboratorio.
 * 
 * @author Gabi
 * @version 1.0
 */
public class GestionStock {

    /**
     * Método principal que ejecuta las pruebas sobre producto y laboratorio.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {

        Laboratorio p0 = new Laboratorio("Colgate", "Junin", "379523489");
        Producto p2 = new Producto(123, "Sombra", 100, p0, 100, "Cosmetica");
        p2.ajuste(500);
        p2.mostrar();
        p2.ajuste(200);
        System.out.println("" + p2.mostrarLinea());

    }

}
