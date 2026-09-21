import java.util.Scanner;

public class GestionComercio {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Comercio comercio = new Comercio("Avanti SRL");

        int opcion = 0;

        do {
            System.out.println("\n*** MENU GESTION COMERCIO ***");
            System.out.println("1. Alta de empleado");
            System.out.println("2. Baja de empleado");
            System.out.println("3. Buscar empleado");
            System.out.println("4. Mostrar sueldo neto por CUIL");
            System.out.println("5. Emitir nomina de empleados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese CUIL: ");
                    long cuil = teclado.nextLong();
                    teclado.nextLine();

                    System.out.print("Ingrese Apellido: ");
                    String apellido = teclado.nextLine();

                    System.out.print("Ingrese Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Ingrese Sueldo Basico: ");
                    double sueldoBasico = teclado.nextDouble();

                    System.out.print("Ingrese Año de Ingreso: ");
                    int anioIngreso = teclado.nextInt();

                    Empleado nuevoEmpleado = new Empleado(cuil, apellido, nombre, sueldoBasico, anioIngreso);
                    comercio.altaEmpleado(nuevoEmpleado);
                    System.out.println("Empleado agregado con exito.");
                    break;

                case 2:
                    System.out.print("Ingrese CUIL a dar de baja: ");
                    long cuilBaja = teclado.nextLong();

                    if (comercio.esEmpleado(cuilBaja)) {
                        comercio.bajaEmpleado(cuilBaja);
                        System.out.println("Empleado dado de baja.");
                    } else {
                        System.out.println("No se encontro ningun empleado con ese CUIL.");
                    }
                    break;

                case 3:
                    for (Empleado unEmpleado : comercio.getEmpleados().values()) {
                        System.out.println("- " + unEmpleado.getCuil() + ": " + unEmpleado.getNomYApe());
                    }
                    System.out.print("Ingrese CUIL a buscar: ");
                    long cuilBuscar = teclado.nextLong();

                    Empleado emp = comercio.buscarEmpleado(cuilBuscar);
                    if (emp != null) {
                        emp.mostrar();
                    } else {
                        System.out.println("No se encontro el empleado.");
                    }
                    break;

                case 4:
                    System.out.println();
                    comercio.nomina();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        } while (opcion != 0);

        teclado.close();
    }
}
