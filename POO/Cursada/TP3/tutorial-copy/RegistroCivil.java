import java.util.Scanner;

/**
 * Clase ejecutable para gestionar el Registro Civil, permitiendo ingresar los datos
 * de un hombre y una mujer por teclado mediante Scanner y probar las operaciones
 * de matrimonio, divorcio y consulta de estados civiles.
 * 
 * @author Gabi
 * @version 1.0
 */
public class RegistroCivil {

    /**
     * Método principal ejecutable.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("       REGISTRO CIVIL - INGRESO DE DATOS");
        System.out.println("==========================================");

        // Ingreso de datos del Hombre
        System.out.println("\n--- Datos del Hombre ---");
        System.out.print("Ingrese nombre: ");
        String nombreH = teclado.nextLine();

        System.out.print("Ingrese apellido: ");
        String apellidoH = teclado.nextLine();

        System.out.print("Ingrese edad: ");
        int edadH = teclado.nextInt();
        teclado.nextLine(); // Limpiar el buffer

        Hombre hombre = new Hombre(nombreH, apellidoH, edadH);

        // Ingreso de datos de la Mujer
        System.out.println("\n--- Datos de la Mujer ---");
        System.out.print("Ingrese nombre: ");
        String nombreM = teclado.nextLine();

        System.out.print("Ingrese apellido: ");
        String apellidoM = teclado.nextLine();

        System.out.print("Ingrese edad: ");
        int edadM = teclado.nextInt();
        teclado.nextLine(); // Limpiar el buffer

        Mujer mujer = new Mujer(nombreM, apellidoM, edadM);

        int opcion;

        do {
            System.out.println("\n==========================================");
            System.out.println("          MENÚ DE REGISTRO CIVIL");
            System.out.println("==========================================");
            System.out.println("1. Mostrar estado civil de ambos");
            System.out.println("2. Casar a " + hombre.getNombre() + " con " + mujer.getNombre());
            System.out.println("3. Mostrar con quién están casados");
            System.out.println("4. Divorciar a " + hombre.getNombre());
            System.out.println("5. Divorciar a " + mujer.getNombre());
            System.out.println("6. Ingresar nuevos datos de personas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer

            System.out.println("------------------------------------------");
            switch (opcion) {
                case 1 -> {
                    System.out.println("Estado civil actual:");
                    hombre.mostrarEstadoCivil();
                    mujer.mostrarEstadoCivil();
                }
                case 2 -> {
                    System.out.println("Celebrando matrimonio...");
                    hombre.casarseCon(mujer);
                    System.out.println("Operación completada.");
                    hombre.mostrarEstadoCivil();
                    mujer.mostrarEstadoCivil();
                }
                case 3 -> {
                    System.out.println("Consulta de matrimonio:");
                    hombre.casadoCon();
                    mujer.casadaCon();
                }
                case 4 -> {
                    System.out.println("Gestionando divorcio para " + hombre.getNombre() + "...");
                    hombre.divorcio();
                    System.out.println("Operación completada.");
                    hombre.mostrarEstadoCivil();
                    mujer.mostrarEstadoCivil();
                }
                case 5 -> {
                    System.out.println("Gestionando divorcio para " + mujer.getNombre() + "...");
                    mujer.divorcio();
                    System.out.println("Operación completada.");
                    hombre.mostrarEstadoCivil();
                    mujer.mostrarEstadoCivil();
                }
                case 6 -> {
                    System.out.println("\n--- Nuevos datos del Hombre ---");
                    System.out.print("Ingrese nombre: ");
                    nombreH = teclado.nextLine();
                    System.out.print("Ingrese apellido: ");
                    apellidoH = teclado.nextLine();
                    System.out.print("Ingrese edad: ");
                    edadH = teclado.nextInt();
                    teclado.nextLine();
                    hombre = new Hombre(nombreH, apellidoH, edadH);

                    System.out.println("\n--- Nuevos datos de la Mujer ---");
                    System.out.print("Ingrese nombre: ");
                    nombreM = teclado.nextLine();
                    System.out.print("Ingrese apellido: ");
                    apellidoM = teclado.nextLine();
                    System.out.print("Ingrese edad: ");
                    edadM = teclado.nextInt();
                    teclado.nextLine();
                    mujer = new Mujer(nombreM, apellidoM, edadM);

                    System.out.println("Nuevas personas cargadas con éxito.");
                }
                case 0 -> System.out.println("Saliendo del sistema de Registro Civil. ¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        teclado.close();
    }
}
