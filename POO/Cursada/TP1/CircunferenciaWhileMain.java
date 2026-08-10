package Cursada.TP1;

import java.util.Scanner;

public class CircunferenciaWhileMain {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String decision;

        do {

            System.out.println("Ingrese el radio de la circunferencia:");
            int radio = teclado.nextInt();

            CircunferenciaWhile circunferencia = new CircunferenciaWhile(radio);

            teclado.nextLine(); // Limpia el Enter pendiente

            System.out.println("Desea ingresar otro radio? (si/no)");
            decision = teclado.nextLine();

        } while (decision.equalsIgnoreCase("si"));

        teclado.close();
    }
}

