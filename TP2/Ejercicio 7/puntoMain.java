import javax.swing.JOptionPane;

/**
 * Punto de entrada de la aplicacion para crear y manipular puntos
 * en un plano cartesiano.
 */
public class puntoMain {

    /**
     * Solicita las coordenadas de un punto mediante cuadros de dialogo,
     * crea el objeto correspondiente, muestra su información y permite
     * desplazarlo.
     *
     * @param args argumentos de linea de comandos; no se utilizan.
     */
    public static void main(String[] args) {
        
        double x = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la coordenada X:"));
        double y = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la coordenada Y:"));
        
        punto p = new punto(x, y);
        p.mostrar();
        System.out.println("" + p.coordenadas());
        
        double dx = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el desplazamiento en X:"));
        double dy = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el desplazamiento en Y:"));
        
        p.desplazar(dx, dy);

        p.mostrar();
        System.out.println("" + p.coordenadas());
    }
}
