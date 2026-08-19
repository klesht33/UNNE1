package EjercicioClase;
import javax.swing.JOptionPane;

public class autorMain {
    public static void main(String[] args){
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del autor:");
        String institucion = JOptionPane.showInputDialog("Ingrese el nombre de la institucion:");
        String mail = JOptionPane.showInputDialog("Ingrese el mail del usuario: ");

        autor nuevoAutor = new autor(nombre, institucion, mail);
        nuevoAutor.mostrar();

    }
}
