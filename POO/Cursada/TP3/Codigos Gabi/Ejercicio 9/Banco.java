import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Clase ejecutable que gestiona un menú bancario para operar con Caja de Ahorro
 * y Cuenta Corriente de un titular.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Banco {

    /**
     * Método principal que inicializa el titular, las cuentas bancarias y ejecuta
     * el menú interactivo.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("    INGRESO DE DATOS DEL TITULAR");
        System.out.println("==========================================");
        System.out.print("Ingrese DNI: ");
        int dni = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Ingrese Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Ingrese Apellido: ");
        String apellido = teclado.nextLine();

        System.out.print("Ingrese Día de Nacimiento: ");
        int dia = teclado.nextInt();

        System.out.print("Ingrese Mes de Nacimiento (1-12): ");
        int mes = teclado.nextInt();

        System.out.print("Ingrese Año de Nacimiento: ");
        int anio = teclado.nextInt();
        teclado.nextLine();

        Calendar fechaNacimiento = new GregorianCalendar(anio, mes - 1, dia);

        Persona titular = new Persona(dni, nombre, apellido, fechaNacimiento);

        if (titular.esCumpleaños()) {
            System.out.println("\n**************************************************");
            System.out.println(" ¡El Banco le desea un muy Feliz Cumpleaños, " + titular.nomYAp() + "!");
            System.out.println("**************************************************");
        }

        System.out.println("\n==========================================");
        System.out.println("    APERTURA DE CUENTAS");
        System.out.println("==========================================");
        System.out.print("Ingrese saldo inicial para la Caja de Ahorro: $");
        double saldoCA = teclado.nextDouble();
        CajaDeAhorro cajaAhorro = new CajaDeAhorro(101, titular, saldoCA);

        System.out.print("Ingrese saldo inicial para la Cuenta Corriente: $");
        double saldoCC = teclado.nextDouble();
        CuentaCorriente cuentaCorriente = new CuentaCorriente(201, titular, saldoCC);

        int opcion;

        do {
            System.out.println("\n==========================================");
            System.out.println("            MENÚ DE OPERACIONES");
            System.out.println("==========================================");
            System.out.println("1. Depositar en Caja de Ahorro");
            System.out.println("2. Extraer de Caja de Ahorro");
            System.out.println("3. Depositar en Cuenta Corriente");
            System.out.println("4. Extraer de Cuenta Corriente");
            System.out.println("5. Mostrar estado de las cuentas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Monto a depositar en CA: $");
                    double monto = teclado.nextDouble();
                    cajaAhorro.depositar(monto);
                }
                case 2 -> {
                    System.out.print("Monto a extraer de CA: $");
                    double monto = teclado.nextDouble();
                    cajaAhorro.extraer(monto);
                }
                case 3 -> {
                    System.out.print("Monto a depositar en CC: $");
                    double monto = teclado.nextDouble();
                    cuentaCorriente.depositar(monto);
                }
                case 4 -> {
                    System.out.print("Monto a extraer de CC: $");
                    double monto = teclado.nextDouble();
                    cuentaCorriente.extraer(monto);
                }
                case 5 -> {
                    System.out.println("\n------------------------------------------");
                    cajaAhorro.mostrar();
                    System.out.println();
                    cuentaCorriente.mostrar();
                    System.out.println("------------------------------------------");
                }
                case 0 -> System.out.println("\n¡Hasta luego!");
                default -> System.out.println("\nOpción inválida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}