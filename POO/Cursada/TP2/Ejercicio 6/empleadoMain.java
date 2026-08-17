import javax.swing.JOptionPane;

/**
 * Clase principal que permite crear un empleado y mostrar su información salarial.
 * Utiliza diálogos gráficos (JOptionPane) para solicitar los datos del empleado.
 * 
 * @author Usuario
 * @version 1.0
 */
public class empleadoMain {

    /**
     * Método principal de la aplicación.
     * Solicita al usuario los datos del empleado mediante diálogos gráficos,
     * crea un objeto empleado y muestra su información.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del empleado: ");
    long cuil = Long.parseLong(JOptionPane.showInputDialog("Ingrese el CUIL del empleado: "));
    double sueldoBasico = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el sueldo basico del empleado: "));
    int anioIngreso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de ingreso del empleado: "));

    empleado empleado1 = new empleado(cuil, apellido, nombre, sueldoBasico, anioIngreso);

    empleado1.mostrar();
    empleado1.mostrarLinea();

    }
    
}
