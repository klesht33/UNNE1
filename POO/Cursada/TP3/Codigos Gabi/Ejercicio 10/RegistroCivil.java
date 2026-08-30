import java.util.Scanner;

/**
 * Clase ejecutable para simular los actos del Registro Civil: creación de personas, casamiento y divorcio.
 * 
 * @author Gabi
 * @version 1.0
 */
public class RegistroCivil {

    /**
     * Método principal que interactúa por consola simulando el registro de matrimonio y divorcio.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("    INGRESO DE DATOS DEL HOMBRE");
        System.out.println("==========================================");
        System.out.print("Ingrese Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingrese Apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("Ingrese Edad: ");
        int edad = teclado.nextInt();
        teclado.nextLine();

        Hombre hombre = new Hombre(nombre, apellido, edad);

        System.out.println("\n==========================================");
        System.out.println("    INGRESO DE DATOS DE LA MUJER");
        System.out.println("==========================================");
        System.out.print("Ingrese Nombre: ");
        nombre = teclado.nextLine();

        System.out.print("Ingrese Apellido: ");
        apellido = teclado.nextLine();

        System.out.print("Ingrese Edad: ");
        edad = teclado.nextInt();
        teclado.nextLine();

        Mujer mujer = new Mujer(nombre, apellido, edad);

        System.out.println("\n==========================================");
        System.out.println("             ESTADO INICIAL");
        System.out.println("==========================================");
        hombre.mostrarEstadoCivil();
        mujer.mostrarEstadoCivil();

        System.out.println("\n==========================================");
        System.out.println("               MATRIMONIO");
        System.out.println("==========================================");
        hombre.casarseCon(mujer);
        mujer.casarseCon(hombre);
        hombre.casadoCon();
        mujer.casadaCon();
        hombre.mostrarEstadoCivil();
        mujer.mostrarEstadoCivil();

        System.out.println("\n==========================================");
        System.out.println("                DIVORCIO");
        System.out.println("==========================================");
        hombre.divorcio();
        mujer.divorcio();
        hombre.mostrarEstadoCivil();
        mujer.mostrarEstadoCivil();

        teclado.close();
    }
}
