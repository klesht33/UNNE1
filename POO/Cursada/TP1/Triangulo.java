import javax.swing.JOptionPane;

public class Triangulo {

    float a;
    float b;
    float c;

    float area;
    float semiperimetro;
    float perimetro;

    public Triangulo(float a, float b, float c){

        this.a = a;
        this.b = b;
        this.c = c;

        semiperimetro = (a + b + c) / 2;
        perimetro = a + b + c;

        area = (float) Math.sqrt(semiperimetro * (semiperimetro - a) * (semiperimetro - b) * (semiperimetro - c));



    }

    public static void main(String[] args) {
        float n1 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el lado a del triangulo:"));
        float n2 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el lado b del triangulo:"));
        float n3 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el lado c del triangulo:"));

        Triangulo triangulo = new Triangulo(n1, n2, n3);
        System.out.println("El perimetro del triangulo es: " + triangulo.perimetro);
        System.out.println("El area del triangulo es: " + triangulo.area);
    }
}
