package Cursada.TP1;

import javax.swing.JOptionPane;

public class CircunferenciaMain {
    public static void main(String[] args){

       int n1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el radio de la circunferencia:"));
       
       CircunferenciaEcuacion circunferencia = new CircunferenciaEcuacion(n1);
       System.out.println("El perimetro de la circunferencia es: " + circunferencia.perimetro);

    }
}
