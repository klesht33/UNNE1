import javax.swing.JOptionPane;

/**
 * Punto de entrada de la aplicacion para registrar y mostrar los datos de un
 * alumno.
 */
public class pupilMain {

    /**
     * Solicita los datos de un alumno mediante cuadros de dialogo, crea el
     * objeto correspondiente y muestra su informacion por consola.
     *
     * @param args argumentos de linea de comandos; no se utilizan.
     */
    public static void main(String[] args){
        
        int lu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el LU del alumno:"));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno: ");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del alumno: ");
        double nota1 = Double.parseDouble(JOptionPane.showInputDialog(":Ingrese la nota 1:"));
        double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota 2: "));

        pupil alumno = new pupil(lu, nombre, apellido, nota1, nota2);
        alumno.mostrar();
    
    }
    
}
