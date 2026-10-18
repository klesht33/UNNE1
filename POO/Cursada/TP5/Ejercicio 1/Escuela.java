
import java.util.Scanner;

public class Escuela {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Persona persona = null;
        Alumno alumno = null;
        int opcion;

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Agregar alumno");
            System.out.println("3. Mostrar persona");
            System.out.println("4. Mostrar alumno");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("DNI: ");
                    int dniP = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Nombre: ");
                    String nombreP = teclado.nextLine();

                    System.out.print("Apellido: ");
                    String apellidoP = teclado.nextLine();

                    System.out.print("Anio de nacimiento: ");
                    int anioP = teclado.nextInt();

                    persona = new Persona(
                            dniP, nombreP, apellidoP, anioP);

                    System.out.println("Persona agregada correctamente");
                    break;

                case 2:
                    System.out.print("DNI: ");
                    int dniA = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Nombre: ");
                    String nombreA = teclado.nextLine();

                    System.out.print("Apellido: ");
                    String apellidoA = teclado.nextLine();

                    System.out.print("Anio de nacimiento: ");
                    int anioA = teclado.nextInt();

                    System.out.print("LU: ");
                    int lu = teclado.nextInt();

                    System.out.print("Nota 1: ");
                    double nota1 = teclado.nextDouble();

                    System.out.print("Nota 2: ");
                    double nota2 = teclado.nextDouble();

                    alumno = new Alumno(
                            dniA, anioA, lu, nombreA, apellidoA, nota1, nota2);

                    System.out.println("Alumno agregado correctamente");
                    break;

                case 3:
                    if (persona != null) {
                        persona.mostrar();
                    } else {
                        System.out.println("No hay una persona cargada");
                    }
                    break;

                case 4:
                    if (alumno != null) {
                        alumno.mostrar();
                    } else {
                        System.out.println("No hay un alumno cargado");
                    }
                    break;

                case 0:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (opcion != 0);

        teclado.close();
    }
}
