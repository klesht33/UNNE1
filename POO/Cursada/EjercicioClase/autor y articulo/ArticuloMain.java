import javax.swing.JOptionPane;
public class ArticuloMain {
    public static void main (String []args){
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingresar codigo: "));
        String titulo = JOptionPane.showInputDialog("Ingrese titulo: ");
        String area = JOptionPane.showInputDialog("Ingrese area:");

        autor autorIngresado = autor.ingresarAutor();

        Articulo articulo = new Articulo(codigo, titulo, area, autorIngresado);
        articulo.mostrarDatos();
        autorIngresado.mostrar();
    }
}
