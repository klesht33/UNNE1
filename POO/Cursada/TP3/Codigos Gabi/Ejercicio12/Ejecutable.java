import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ejecutable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== INGRESO DATOS DEL GERENTE GENERAL ===");
        System.out.print("Ingrese CUIL: ");
        long cuilGerente = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Ingrese Apellido: ");
        String apellidoGerente = scanner.nextLine();

        System.out.print("Ingrese Nombre: ");
        String nombreGerente = scanner.nextLine();

        System.out.print("Ingrese Sueldo Básico: ");
        double sueldoGerente = scanner.nextDouble();

        System.out.print("Ingrese Año de Ingreso: ");
        int anioG = scanner.nextInt();
        System.out.print("Ingrese Mes de Ingreso (1-12): ");
        int mesG = scanner.nextInt();
        System.out.print("Ingrese Día de Ingreso (1-31): ");
        int diaG = scanner.nextInt();
        scanner.nextLine();

        Calendar fechaGerente = new GregorianCalendar(anioG, mesG - 1, diaG);

        EmpleadoConJefe gerente = new EmpleadoConJefe(cuilGerente, apellidoGerente, nombreGerente, sueldoGerente,
                fechaGerente);

        System.out.println("\n=== INGRESO DATOS DEL EMPLEADO ===");
        System.out.print("Ingrese CUIL: ");
        long cuilEmp = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Ingrese Apellido: ");
        String apellidoEmp = scanner.nextLine();

        System.out.print("Ingrese Nombre: ");
        String nombreEmp = scanner.nextLine();

        System.out.print("Ingrese Sueldo Básico: ");
        double sueldoEmp = scanner.nextDouble();

        System.out.print("Ingrese Año de Ingreso: ");
        int anioE = scanner.nextInt();
        System.out.print("Ingrese Mes de Ingreso (1-12): ");
        int mesE = scanner.nextInt();
        System.out.print("Ingrese Día de Ingreso (1-31): ");
        int diaE = scanner.nextInt();
        scanner.nextLine();

        Calendar fechaEmpleado = new GregorianCalendar(anioE, mesE - 1, diaE);

        EmpleadoConJefe empleado = new EmpleadoConJefe(cuilEmp, apellidoEmp, nombreEmp, sueldoEmp, fechaEmpleado,
                gerente);

        System.out.println("\n--- DATOS DEL EMPLEADO ---");
        empleado.mostrar();

        System.out.println("\n=== PERMISO DE SALIDA ===");
        System.out.print("Ingrese Motivo de la salida: ");
        String motivo = scanner.nextLine();

        System.out.print("Ingrese Horario autorizado: ");
        String horario = scanner.nextLine();

        emitirPermisoSalida(empleado, motivo, horario);

        scanner.close();
    }

    public static void emitirPermisoSalida(EmpleadoConJefe pEmpleado, String pMotivo, String pHorario) {
        System.out.println("\n===== PERMISO DE SALIDA =====");
        System.out.println("Se autoriza al empleado: " + pEmpleado.getNomYApe());
        System.out.println("CUIL: " + pEmpleado.getCuil());
        System.out.println("Motivo: " + pMotivo);
        System.out.println("Horario autorizado: " + pHorario);
        System.out.println("\nFirma del Jefe:");

        if (pEmpleado.getJefe() != null) {
            System.out.println("___________________________");
            System.out.println("Firma: " + pEmpleado.getJefe().getNomYApe());
            System.out.println("Cargo: Jefe Directo");
        } else {
            System.out.println("___________________________");
            System.out.println("Firma: GERENCIA GENERAL");
        }
        System.out.println("=============================");
    }
}