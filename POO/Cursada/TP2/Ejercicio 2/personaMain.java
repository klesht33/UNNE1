
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
        Persona persona1 = new Persona(46773971, "luis", "bonessi", 2005);
        persona1.mostrar();
    }
}
