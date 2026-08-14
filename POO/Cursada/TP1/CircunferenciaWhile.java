import java.util.Scanner;

public class CircunferenciaWhile {
    
    float radio;
    float area;
    float perimetro;


   public CircunferenciaWhile(float radio){
            this.radio = radio;
            area = (float) (Math.PI * Math.pow(radio, 2));
            perimetro = (float) (2 * Math.PI * radio);

            System.out.println("El area de la circunferencia es: " + area);
            System.out.println("El perimetro de la circunferencia es: " + perimetro);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String decision;

        do {
            System.out.println("Ingrese el radio de la circunferencia:");
            int radio = teclado.nextInt();

            new CircunferenciaWhile(radio);

            teclado.nextLine();
            System.out.println("Desea ingresar otro radio? (si/no)");
            decision = teclado.nextLine();
        } while (decision.equalsIgnoreCase("si"));

        teclado.close();
    }
}
