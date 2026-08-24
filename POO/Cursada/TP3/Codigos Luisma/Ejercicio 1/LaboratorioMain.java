/**
 * Ejecuta una demostración del uso de la clase {@link laboratorio}.
 *
 * @version 1.0
 */
public class LaboratorioMain {

    /**
     * Crea un laboratorio y muestra sus datos por consola.
     *
     * @param args argumentos recibidos desde la línea de comandos
     */
    public static void main(String[] args) {
        Laboratorio p = new Laboratorio("Oscorp INC", "la olla", "3795");
        p.mostrar();

    }
}
