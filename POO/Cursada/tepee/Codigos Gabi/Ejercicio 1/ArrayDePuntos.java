import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase ejecutable ArrayDePuntos.
 * Administra una colección de objetos Punto utilizando el tipo de dato ArrayList
 * sin genéricos (con casting al recuperar elementos), aplicando las pautas
 * de la cátedra para constructores y encapsulamiento.
 * 
 * @author Gabi
 * @version 1.0
 */
public class ArrayDePuntos {

    /** Colección de puntos utilizando el tipo de dato ArrayList sin tipar */
    private ArrayList puntos;

    /**
     * Constructor caso 0 (0..*):
     * No recibe elementos iniciales. Crea la colección con this.setPuntos(new ArrayList()).
     */
    public ArrayDePuntos() {
        this.setPuntos(new ArrayList());
    }

    /**
     * Constructor caso 1 (1..*):
     * Recibe un objeto elemento de la colección -> crea la colección y le adiciona el objeto.
     * 
     * @param p_punto punto inicial a agregar a la colección
     */
    public ArrayDePuntos(Punto p_punto) {
        this.setPuntos(new ArrayList());
        this.agregarPunto(p_punto);
    }

    /**
     * Constructor caso * ó n:
     * Recibe una colección completa representando el conocimiento * ó n.
     * 
     * @param p_puntos colección de puntos a asignar
     */
    public ArrayDePuntos(ArrayList p_puntos) {
        this.setPuntos(p_puntos);
    }

    /**
     * Asigna la colección de puntos.
     * 
     * @param p_puntos colección de puntos
     */
    private void setPuntos(ArrayList p_puntos) {
        this.puntos = p_puntos;
    }

    /**
     * Obtiene la colección de puntos.
     * 
     * @return colección de puntos
     */
    public ArrayList getPuntos() {
        return this.puntos;
    }

    /**
     * Agrega un nuevo punto a la colección.
     * 
     * @param p_punto punto a agregar
     * @return true si se agregó correctamente
     */
    public boolean agregarPunto(Punto p_punto) {
        return this.getPuntos().add(p_punto);
    }

    /**
     * Elimina un punto de la colección.
     * 
     * @param p_punto punto a eliminar
     * @return true si se eliminó correctamente
     */
    public boolean quitarPunto(Punto p_punto) {
        return this.getPuntos().remove(p_punto);
    }

    /**
     * 1.3. Recorre la colección e imprime las coordenadas de cada elemento
     * utilizando cast (Punto) al recuperar cada elemento del ArrayList.
     */
    public void imprimirCoordenadas() {
        for (int i = 0; i < this.getPuntos().size(); i++) {
            System.out.print("Punto " + (i + 1) + ": ");
            Punto unPunto = (Punto) this.getPuntos().get(i);
            unPunto.mostrar();
        }
    }

    /**
     * 1.4. Imprime en pantalla la distancia entre cada 2 elementos consecutivos
     * utilizando cast (Punto) al recuperar los elementos del ArrayList.
     */
    public void imprimirDistanciasConsecutivas() {
        for (int i = 0; i < this.getPuntos().size() - 1; i++) {
            Punto actual = (Punto) this.getPuntos().get(i);
            Punto siguiente = (Punto) this.getPuntos().get(i + 1);
            double dist = actual.distanciaA(siguiente);
            System.out.printf("Distancia pto%d-pto%d: %.4f%n", (i + 1), (i + 2), dist);
        }
    }

    /**
     * Auxiliar para leer números decimales aceptando tanto '.' como ','
     * 
     * @param scanner instancia de Scanner
     * @return número double ingresado
     */
    private static double leerDouble(Scanner scanner) {
        while (true) {
            String entrada = scanner.next().trim().replace(',', '.');
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
    }

    /**
     * Método principal ejecutable.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Instanciación usando el constructor caso 0 (colección vacía)
        ArrayDePuntos contenedor = new ArrayDePuntos();

        System.out.println("==================================================");
        System.out.println("  1.2. INGRESO DE PUNTOS AL ARRAYLIST             ");
        System.out.println("==================================================");

        // 1.2. Agregar como elementos instancias de la clase Punto ingresando por teclado
        for (int i = 0; i < 6; i++) {
            System.out.println("\n--- Punto " + (i + 1) + " ---");
            System.out.print("Ingrese coordenada X: ");
            double x = leerDouble(teclado);

            System.out.print("Ingrese coordenada Y: ");
            double y = leerDouble(teclado);

            contenedor.agregarPunto(new Punto(x, y));
        }

        // 1.3. Recorrer el contenedor e imprimir las coordenadas de cada elemento
        System.out.println("\n==================================================");
        System.out.println("  1.3. COORDENADAS DE CADA ELEMENTO DEL ARRAY     ");
        System.out.println("==================================================");
        contenedor.imprimirCoordenadas();

        // 1.4. Imprimir la distancia de cada 2 elementos consecutivos
        System.out.println("\n==================================================");
        System.out.println("  1.4. DISTANCIAS ENTRE ELEMENTOS CONSECUTIVOS    ");
        System.out.println("==================================================");
        contenedor.imprimirDistanciasConsecutivas();

        System.out.println("==================================================");

        teclado.close();
    }
}
