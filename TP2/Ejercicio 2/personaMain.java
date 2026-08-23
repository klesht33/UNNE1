

/**
 * Ejecuta una demostración del uso de la clase {@link persona}.
 *
 * @version 1.0
 */
public class personaMain {
    /**
     * Crea una persona y muestra sus datos por consola.
     *
     * @param args argumentos recibidos desde la línea de comandos
     */
    public static void main(String[] args) {
        persona p = new persona(35123456, "Jaaaaauaaaaaaassssssn", "Pérez", 2005);
        p.mostrar();
    }
}
