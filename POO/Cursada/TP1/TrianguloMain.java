package Cursada.TP1;

import javax.swing.JOptionPane;

public class TrianguloMain {

    public static void main(String[] args) {
        float n1 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el lado a del triangulo:"));
        float n2 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el lado b del triangulo:"));
        float n3 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el lado c del triangulo:"));

        Triangulo triangulo = new Triangulo(n1, n2, n3);
        System.out.println("El perimetro del triangulo es: " + triangulo.perimetro);
        System.out.println("El area del triangulo es: " + triangulo.area);
    }
}
