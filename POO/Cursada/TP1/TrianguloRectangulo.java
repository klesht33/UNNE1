import javax.swing.JOptionPane;

public class TrianguloRectangulo {
    
    float a;
    float b;
    float hipotenusa;

    public TrianguloRectangulo(float a, float b, float hipotenusa){

        this.a= a;
        this.b= b;
        this.hipotenusa = hipotenusa;

        if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(hipotenusa, 2)){
            System.out.println("El triangulo es rectangulo");
        } else{
            System.out.println("El triangulo no es rectangulo");
        }
    }

    public static void main(String[] args) {
        float n1 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el cateto A:"));
        float n2 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el cateto B:"));
        float n3 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la hipotenusa:"));

        new TrianguloRectangulo(n1, n2, n3);
    }
}
