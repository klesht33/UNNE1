import javax.swing.JOptionPane;

public class CircunferenciaEcuacion {

    float perimetro;
    float radio;

    public CircunferenciaEcuacion(float radio) {
        this.radio = radio;
        this.perimetro = 2 * (float) Math.PI * radio;
    }

    public static void main(String[] args) {
        int n1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el radio de la circunferencia:"));

        CircunferenciaEcuacion circunferencia = new CircunferenciaEcuacion(n1);
        System.out.println("El perimetro de la circunferencia es: " + circunferencia.perimetro);
    }
}
