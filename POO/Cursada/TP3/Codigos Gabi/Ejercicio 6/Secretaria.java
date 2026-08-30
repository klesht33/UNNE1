import javax.swing.JOptionPane;

/**
 * Clase ejecutable que solicita datos de la escuela y del docente para emitir el recibo de sueldo.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Secretaria {

    /**
     * Método principal que interactúa con el usuario y genera el recibo del docente.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la escuela: ");
        String domicilio = JOptionPane.showInputDialog("Ingrese el domicilio de la escuela: ");
        String director = JOptionPane.showInputDialog("Ingrese el nombre del director de la escuela: ");
        Escuela escuela = new Escuela(nombre, domicilio, director);

        String nombreDocente = JOptionPane.showInputDialog("Ingrese el nombre del docente: ");
        String gradoDocente = JOptionPane.showInputDialog("Ingrese el grado del docente: ");
        double sueldoBasico = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo basico del docente: "));
        double asignacionFamiliar = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la asignacion familiar del docente: "));
        Docente docente = new Docente(nombreDocente, gradoDocente, sueldoBasico, asignacionFamiliar);

        escuela.imprimirRecibo(docente);
    }
}
