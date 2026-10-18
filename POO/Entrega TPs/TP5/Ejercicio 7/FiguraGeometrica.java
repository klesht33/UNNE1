/**
 * Clase abstracta que representa una figura geométrica en un sistema de coordenadas,
 * definida por su punto de origen.
 * 
 * @author Gabi
 * @version 1.0
 */
public abstract class FiguraGeometrica {

    /** Punto de origen de la figura geométrica. */
    private Punto origen;

    /**
     * Constructor que inicializa la figura geométrica con su punto de origen.
     * 
     * @param p_origen punto de origen de la figura
     */
    public FiguraGeometrica(Punto p_origen) {
        this.setOrigen(p_origen != null ? p_origen : new Punto(0, 0));
    }

    /**
     * Asigna el punto de origen de la figura.
     * 
     * @param p_origen punto de origen a asignar
     */
    public void setOrigen(Punto p_origen) {
        this.origen = p_origen != null ? p_origen : new Punto(0, 0);
    }

    /**
     * Obtiene el punto de origen de la figura.
     * 
     * @return punto de origen
     */
    public Punto getOrigen() {
        return this.origen;
    }

    /**
     * Retorna el nombre de la figura geométrica.
     * 
     * @return nombre de la figura
     */
    public abstract String nombreFigura();

    /**
     * Calcula la superficie de la figura geométrica.
     * 
     * @return superficie calculada
     */
    public abstract double superficie();

    /**
     * Muestra por consola el nombre de la figura y su superficie.
     */
    public void mostrarSuperficie() {
        System.out.println(this.nombreFigura());
        System.out.printf(java.util.Locale.US, "Superficie: %.2f%n", this.superficie());
    }
}
