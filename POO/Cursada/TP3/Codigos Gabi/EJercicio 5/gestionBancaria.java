import javax.swing.JOptionPane;

/**
 * Clase ejecutable para interactuar con el usuario y gestionar operaciones de CuentaBancaria.
 * 
 * @author Gabi
 * @version 1.0
 */
public class gestionBancaria {

   /**
    * Método principal que solicita datos de titular y cuenta, y realiza depósitos y extracciones.
    * 
    * @param args argumentos de línea de comandos
    */
   public static void main(String[] args) {
      int nroCuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cuenta:"));
      int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del titular:"));
      String nombre = JOptionPane.showInputDialog("Ingrese el nombre del titular:");
      String apellido = JOptionPane.showInputDialog("Ingrese el apellido del titular:");
      int anioNacimiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el anio de nacimiento del titular:"));
      persona titular = new persona(dni, nombre, apellido, anioNacimiento);
      double saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial:"));

      CuentaBancaria cuenta = new CuentaBancaria(nroCuenta, titular, saldo);
      double importeDepositar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el saldo a depositar: "));
      double importeExtraer = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto a extraer: "));
      cuenta.despositar(importeDepositar);
      cuenta.mostrar();
      cuenta.extraer(importeExtraer);
      cuenta.mostrar();
      
      System.out.println("" + cuenta.toString());
   }

}
