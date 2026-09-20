import java.util.Scanner;

/**
 * Clase ejecutable para la gestión interactiva del Banco (TP4 - Ejercicio 4).
 * Permite gestionar empleados, agregar/quitar cuentas bancarias y emitir el
 * 
 * resumen completo.
 * 
 * @author Gabi
 * @version 1.0
 */
public class AplicacionBanco {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("==========================================================");
        System.out.println("         SISTEMA DE GESTIÓN BANCARIA - TP4 EJ 4");
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
            System.out.println("3. Agregar cuenta bancaria");
            System.out.println("4. Quitar cuenta bancaria");
            System.out.println("5. Mostrar resumen de cuentas bancarias");
            System.out.println("6. Mostrar liquidación y nómina del banco");
            System.out.println("7. Salir");
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
                    System.out.println("\n--- AGREGAR CUENTA BANCARIA ---");
                    System.out.print("Ingrese número de cuenta: ");
                    int nroCuenta = teclado.nextInt();
                    teclado.nextLine();

                    boolean cuentaExiste = false;
                    for (CuentaCorriente cuenta : banco.getCuenta()) {
                        if (cuenta.getNroCuenta() == nroCuenta) {
                            cuentaExiste = true;
                            break;
                        }
                    }

                    if (cuentaExiste) {
                        System.out.println("Ya existe una cuenta con el número: " + nroCuenta);
                        break;
                    }

                    System.out.print("Ingrese saldo inicial: $");
                    double saldo = teclado.nextDouble();
                    teclado.nextLine();

                    System.out.print("Ingrese DNI del titular: ");
                    int dniTitular = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Ingrese apellido del titular: ");
                    String apeTitular = teclado.nextLine();

                    System.out.print("Ingrese nombre del titular: ");
                    String nomTitular = teclado.nextLine();

                    System.out.print("Ingrese año de nacimiento: ");
                    int anioNacTitular = teclado.nextInt();
                    teclado.nextLine();

                    Persona nuevoTitular = new Persona(dniTitular, nomTitular, apeTitular, anioNacTitular);
                    CuentaCorriente nuevaCuenta = new CuentaCorriente(nroCuenta, nuevoTitular, saldo);

                    if (banco.agregarCuentaBancaria(nuevaCuenta)) {
                        System.out.println("Cuenta N° " + nroCuenta + " agregada exitosamente.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- QUITAR CUENTA BANCARIA ---");
                    if (banco.getCuenta().isEmpty()) {
                        System.out.println("El banco no posee cuentas bancarias actualmente.");
                        break;
                    }

                    System.out.print("Ingrese el número de cuenta a quitar: ");
                    int nroQuitar = teclado.nextInt();
                    teclado.nextLine();

                    CuentaCorriente cuentaAEliminar = null;
                    for (CuentaCorriente cuenta : banco.getCuenta()) {
                        if (cuenta.getNroCuenta() == nroQuitar) {
                            cuentaAEliminar = cuenta;
                            break;
                        }
                    }

                    if (cuentaAEliminar != null) {
                        if (banco.quitarCuentaBancaria(cuentaAEliminar)) {
                            System.out.println("Cuenta N° " + nroQuitar + " eliminada correctamente.");
                        } else {
                            System.out.println("No se encontró ninguna cuenta con el número: " + nroQuitar);
                        }
                        break;
                    }

                case 5:
                    System.out.println();
                    banco.mostrarResumen();
                    break;

                case 6:
                    System.out.println();
                    banco.mostrar();
                    break;

                case 7:
                    System.out.println("\nSaliendo del sistema bancario. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Ingrese un valor entre 1 y 7.");
                    break;
            }

        } while (opcion != 7);

        teclado.close();
    }
}
