import javax.swing.JOptionPane;

public class clienteMain {

    public static void main(String[] args) {
       
        int nroDNI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de DNI:"));
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial:"));
        
        cliente c = new cliente(nroDNI, apellido, nombre, saldo);
        c.mostrar();
    }
}
