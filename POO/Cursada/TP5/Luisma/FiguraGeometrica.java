/**
 * Clase abstracta que representa una figura geométrica general.
 * Sirve como superclase para que todas las figuras compartan un origen y
 * definan su comportamiento para nombre y superficie.
 */
public abstract class FiguraGeometrica {
    private Punto origen;

    public FiguraGeometrica(Punto p_origen) {
        this.origen = p_origen != null ? p_origen : new Punto(0, 0);
    }

    public Punto getOrigen() {
        return this.origen;
    }

    protected void setOrigen(Punto p_origen) {
        this.origen = p_origen != null ? p_origen : new Punto(0, 0);
    }

    // Métodos abstractos que cada subclase debe implementar
    public abstract String nombreFigura();
    public abstract double superficie();

    /**
     * Muestra el nombre de la figura y su superficie calculada.
     */
    public void mostrarSuperficie() {
        System.out.println(this.nombreFigura());
        System.out.println("Superficie: " + this.superficie());
    }
}