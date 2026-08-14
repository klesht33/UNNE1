import javax.swing.JOptionPane;

public class Ecuacion {
    
    float a;
    float b;
    float c;

    float x1;
    float x2;
    float discriminante;

    public Ecuacion(float a, float b, float c){

        this.a = a;
        this.b = b;
        this.c = c;

        discriminante = (b * b) - (4 * a * c);

        switch (Float.compare(discriminante, 0.0f)) {
            case -1:
               
                System.out.println("La ecuacion no tiene solucion real");
                break;
            case 0:
              
                float x = -b / (2 * a);
                System.out.println("Raíz doble: " + x);
                break;
            case 1:
               
                float sqrt = (float) Math.sqrt(discriminante);
                x1 = (-b + sqrt) / (2 * a);
                x2 = (-b - sqrt) / (2 * a);
                System.out.printf("Raíces reales: %f y %f%n", x1, x2);
                break;
        }

    }

    public static void main(String[] args) {
        float n1 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor a: "));
        float n2 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor b: "));
        float n3 = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el valor c: "));

        new Ecuacion(n1, n2, n3);
    }
}
