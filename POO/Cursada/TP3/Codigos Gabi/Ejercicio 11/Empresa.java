
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Clase ejecutable para la empresa "Iberá Servicios".
 * Permite cargar los datos de un empleado, mostrar su información
 * y emitir un permiso de salida de 1 hora antes si hoy es su aniversario de
 * ingreso.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Empresa {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("       EMPRESA IBERÁ SERVICIOS");
        System.out.println("    INGRESO DE DATOS DEL EMPLEADO");
        System.out.println("==========================================");
        System.out.print("Ingrese CUIL: ");
        long cuil = teclado.nextLong();
        teclado.nextLine();
        System.out.print("Ingrese Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingrese Apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("Ingrese Sueldo Básico: $");
        double sueldoBasico = teclado.nextDouble();

        System.out.print("Ingrese Día de Ingreso: ");
        int dia = teclado.nextInt();

        System.out.print("Ingrese Mes de Ingreso (1-12): ");
        int mes = teclado.nextInt();

        System.out.print("Ingrese Año de Ingreso: ");
        int anio = teclado.nextInt();

        teclado.nextLine();

        Calendar fechaIngreso = new GregorianCalendar(anio, mes - 1, dia);

        Empleado unEmpleado = new Empleado(cuil, apellido, nombre, sueldoBasico, fechaIngreso);
        System.out.println("\n==========================================");
        System.out.println("        DATOS DEL EMPLEADO");
        System.out.println("==========================================");
        unEmpleado.mostrar();
        System.out.println("\n==========================================");
        System.out.println("      VERIFICACIÓN DE ANIVERSARIO");
        System.out.println("==========================================");

        if (unEmpleado.esAniversario()) {
            System.out.println("\n**************************************************");
            System.out.println("           PERMISO DE SALIDA AUTORIZADO");
            System.out.println("**************************************************");
            System.out.println("¡Felicidades! Hoy es el aniversario de ingreso.");
            System.out.println("Empleado: " + unEmpleado.getNomYApe());
            System.out.println("CUIL: " + unEmpleado.getCuil());
            System.out.println("Antigüedad: " + unEmpleado.antiguedad() + " años de servicio");
            System.out.println("Autorización: Se le permite retirarse 1 hora antes.");
            System.out.println("**************************************************");
        } else {
            System.out.println("Hoy no es el aniversario de ingreso a la empresa.");
            System.out.println("No corresponde emisión de permiso de salida.");
        }
        teclado.close();
    }

}
