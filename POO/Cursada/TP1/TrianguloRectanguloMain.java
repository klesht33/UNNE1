package Cursada.TP1;

import javax.swing.JOptionPane;

public class TrianguloRectanguloMain {
    
    public static void main(String[] args){

        float n1 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el cateto A:"));
        float n2 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el cateto B:"));
        float n3 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la hipotenusa:"));

        TrianguloRectangulo triangulo = new TrianguloRectangulo(n1, n2, n3);
    }
}
