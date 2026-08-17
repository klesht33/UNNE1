import javax.swing.JOptionPane;

/**
 * Ejecuta una demostración del uso de la clase {@link cliente}.
 *
 * @version 1.0
 */
public class clienteMain {

    /**
     * Solicita los datos de un cliente y muestra su información.
     *
     * @param args argumentos recibidos desde la línea de comandos
     */




    public static void main(String[] args) {
       
        int nroDNI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de DNI:"));
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial:"));
        
        cliente c = new cliente(nroDNI, apellido, nombre, saldo);
        c.mostrar();
    }
}
