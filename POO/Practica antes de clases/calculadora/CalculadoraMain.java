package calculadora;

import javax.swing.JOptionPane;

public class CalculadoraMain {
    public static void main(String[] args){

        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero:"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero:"));
        
        operacion op = new operacion();

        //int suma = op.sumar(n1, n2);
        //int resta = op.restar(n1, n2);
        //int mul = op.multiplicar(n1, n2);
        //float div = op.dividir(n1, n2);//

        //op.mostrarResultados(suma, resta, mul, div);

        System.out.println("La suma es:" + op.sumar(n1, n2));
        System.out.println("La resta es:" + op.restar(n1, n2));
        System.out.println("La multiplicación es:" + op.multiplicar(n1, n2));
        System.out.println("La división es:" + op.dividir(n1, n2));
    }

    
}
