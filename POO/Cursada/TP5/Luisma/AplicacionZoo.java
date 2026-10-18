import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class AplicacionZoo {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Zoologico zoo = new Zoologico("El Caribú");
        int opcion = 0;

        System.out.println("======================================");
        System.out.println("   BIENVENIDO AL ZOOLÓGICO EL CARIBÚ  ");
        System.out.println("======================================");

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar nuevo visitante (Individuo)");
            System.out.println("2. Registrar nueva Delegación");
            System.out.println("3. Listar todos los visitantes por fecha");
            System.out.println("4. Listar visitantes por tipo y fecha");
            System.out.println("5. Ver recaudación en un rango de fechas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRO DE INDIVIDUO ---");
                    System.out.print("DNI: ");
                    int dni = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = teclado.nextLine();
                    System.out.print("Edad: ");
                    int edad = teclado.nextInt();
                    
                    Calendar fechaVisita = pedirFecha(teclado, "ingreso");
                    
                    Persona p = new Persona(dni, nombre, apellido, edad);
                    Individuo ind = new Individuo(p, fechaVisita);
                    zoo.nuevoVisitante(ind);
                    System.out.println("¡Visitante individual registrado con éxito!");
                    break;

                case 2:
                    System.out.println("\n--- REGISTRO DE DELEGACIÓN ---");
                    System.out.print("Nombre de la Delegación: ");
                    String nombreDelegacion = teclado.nextLine();
                    Calendar fechaDel = pedirFecha(teclado, "visita de la delegación");
                    
                    Delegacion delegacion = new Delegacion(nombreDelegacion, fechaDel);
                    
                    System.out.print("¿Cuántos integrantes tiene la delegación?: ");
                    int cant = teclado.nextInt();
                    teclado.nextLine();

                    for (int i = 0; i < cant; i++) {
                        System.out.println("Datos del integrante " + (i + 1) + ":");
                        System.out.print("DNI: ");
                        int d = teclado.nextInt();
                        teclado.nextLine();
                        System.out.print("Nombre: ");
                        String n = teclado.nextLine();
                        System.out.print("Apellido: ");
                        String a = teclado.nextLine();
                        System.out.print("Edad: ");
                        int e = teclado.nextInt();
                        
                        Persona per = new Persona(d, n, a, e);
                        // La fecha del integrante es la misma de la delegación
                        Individuo integrante = new Individuo(per, fechaDel); 
                        delegacion.inscribirIndividuo(integrante);
                    }
                    
                    zoo.nuevoVisitante(delegacion);
                    System.out.println("¡Delegación registrada con éxito!");
                    break;

                case 3:
                    System.out.println("\n--- LISTAR VISITANTES POR FECHA ---");
                    Calendar fechaBuscar = pedirFecha(teclado, "búsqueda");
                    zoo.listarVisitantePorFecha(fechaBuscar);
                    break;

                case 4:
                    System.out.println("\n--- LISTAR POR TIPO Y FECHA ---");
                    Calendar fechaFiltro = pedirFecha(teclado, "búsqueda");
                    System.out.print("Ingrese el tipo ('Individuo' o 'Delegación'): ");
                    String tipo = teclado.nextLine();
                    zoo.listarTipoVisitantePorFecha(fechaFiltro, tipo);
                    break;

                case 5:
                    System.out.println("\n--- RECAUDACIÓN POR FECHAS ---");
                    System.out.println("Fecha Desde:");
                    Calendar fechaDesde = pedirFecha(teclado, "inicio");
                    System.out.println("Fecha Hasta:");
                    Calendar fechaHasta = pedirFecha(teclado, "fin");
                    
                    double total = zoo.recaudacion(fechaDesde, fechaHasta);
                    System.out.println("La recaudación total en el período es: $" + total);
                    break;

                case 6:
                    System.out.println("Saliendo del sistema... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción incorrecta. Intente nuevamente.");
            }

        } while (opcion != 6);
        
        teclado.close();
    }

    /**
     * Método auxiliar para evitar repetir el código de lectura de fechas.
     */
    private static Calendar pedirFecha(Scanner teclado, String contexto) {
        System.out.println("Fecha de " + contexto + " (DD MM AAAA): ");
        System.out.print("Día: ");
        int dia = teclado.nextInt();
        System.out.print("Mes (1-12): ");
        int mes = teclado.nextInt() - 1; // Calendar maneja los meses de 0 a 11
        System.out.print("Año: ");
        int anio = teclado.nextInt();
        teclado.nextLine(); // Limpiar el buffer
        
        return new GregorianCalendar(anio, mes, dia);
    }
}