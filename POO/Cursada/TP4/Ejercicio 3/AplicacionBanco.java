import java.util.Scanner;

/**
 * Clase ejecutable para la gestión interactiva del Banco y la liquidación de
 * sueldos (TP4 - Ejercicio 3).
 * Cuenta con un menú simplificado para contratar, despedir y mostrar la
 * liquidación completa del banco.
 * 
 * @author Gabi
 * @version 1.0
 */
public class AplicacionBanco {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("==========================================================");
        System.out.println("         SISTEMA DE GESTIÓN BANCARIA - TP4 EJ 3");
        System.out.println("==========================================================");

        Localidad localidad = new Localidad("Corrientes", "Corrientes");
        Empleado primerEmpleado = new Empleado(27267504235L, "Perez", "Lorena", 120000.0, 2018);
        Banco banco = new Banco("RIO", localidad, 3, primerEmpleado);
        System.out.println("\nBanco RIO Sucursal 3 (Corrientes) inicializado con la empleada Perez, Lorena.");

        int opcion = 0;
        do {
            System.out.println("\n----------------- MENÚ DE OPERACIONES -----------------");
            System.out.println("1. Contratar / Agregar nuevo empleado");
            System.out.println("2. Despedir / Quitar empleado");
            System.out.println("3. Mostrar liquidación y nómina del banco");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            if (!teclado.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                teclado.nextLine();
                continue;
            }

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- CONTRATAR NUEVO EMPLEADO ---");
                    System.out.print("Ingrese CUIL: ");
                    long nuevoCuil = teclado.nextLong();
                    teclado.nextLine();

                    // Verificar si ya existe un empleado con el mismo CUIL
                    boolean cuilExistente = false;
                    for (Empleado emp : banco.getEmpleados()) {
                        if (emp.getCuil() == nuevoCuil) {
                            cuilExistente = true;
                            break;
                        }
                    }

                    if (cuilExistente) {
                        System.out.println("Ya existe un empleado registrado con el CUIL: " + nuevoCuil);
                        break;
                    }

                    System.out.print("Ingrese apellido: ");
                    String nuevoApellido = teclado.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nuevoNombre = teclado.nextLine();

                    System.out.print("Ingrese sueldo básico: $");
                    double nuevoSueldo = teclado.nextDouble();

                    System.out.print("Ingrese año de ingreso: ");
                    int nuevoAnio = teclado.nextInt();
                    teclado.nextLine();

                    Empleado nuevoEmp = new Empleado(nuevoCuil, nuevoApellido, nuevoNombre, nuevoSueldo, nuevoAnio);
                    if (banco.agregarEmpleado(nuevoEmp)) {
                        System.out.println("Empleado '" + nuevoEmp.getNomYApe() + "' contratado exitosamente.");
                    } else {
                        System.out.println("No se pudo agregar al empleado.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- DESPEDIR EMPLEADO ---");
                    if (banco.getEmpleados().size() <= 1) {
                        System.out
                                .println("Operación denegada: El banco tiene solo 1 empleado y no puede quedar vacío.");
                        break;
                    }

                    System.out.println("Empleados actuales en el banco:");
                    for (Empleado emp : banco.getEmpleados()) {
                        System.out.println("  CUIL: " + emp.getCuil() + " | " + emp.getNomYApe());
                    }

                    System.out.print("Ingrese el CUIL del empleado a despedir: ");
                    long cuilBaja = teclado.nextLong();
                    teclado.nextLine();

                    Empleado empleadoAEliminar = null;
                    for (Empleado emp : banco.getEmpleados()) {
                        if (emp.getCuil() == cuilBaja) {
                            empleadoAEliminar = emp;
                            break;
                        }
                    }
                    if (banco.quitarEmpleado(empleadoAEliminar)) {
                        System.out.println(
                                "El empleado " + empleadoAEliminar.getNomYApe() + " ha sido despedido correctamente.");
                    } else {
                        System.out.println("No se encontró ningún empleado con el CUIL ingresado.");
                    }
                    break;

                case 3:
                    System.out.println();
                    banco.mostrar();
                    break;

                case 4:
                    System.out.println("\nSaliendo del sistema bancario. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Ingrese un valor entre 1 y 4.");
                    break;
            }

        } while (opcion != 4);

        teclado.close();
    }

}
