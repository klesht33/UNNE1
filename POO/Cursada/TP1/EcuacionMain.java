package Cursada.TP1;
import javax.swing.JOptionPane;

public class EcuacionMain {
    
    public static void main(String[] args){

        float n1 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor a: "));
        float n2 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor b: "));
        float n3 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor c: "));

        Ecuacion ecuacion = new Ecuacion(n1, n2, n3);   
        
    }
    
}
