/**
 * Representa una figura geométrica elíptica definida por sus semiejes mayor y menor,
 * y su punto central (origen), como especialización de FiguraGeometrica.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Elipse extends FiguraGeometrica {

    /** Semieje mayor de la elipse. */
    private double sEjeMayor;
    /** Semieje menor de la elipse. */
    private double sEjeMenor;

    /**
     * Constructor que inicializa la elipse con sus semiejes y su punto central.
     * 
     * @param p_sEjeMayor semieje mayor de la elipse
     * @param p_sEjeMenor semieje menor de la elipse
     * @param p_centro    punto central de la elipse
     */
    public Elipse(double p_sEjeMayor, double p_sEjeMenor, Punto p_centro) {
        super(p_centro);
        this.setsEjeMayor(p_sEjeMayor);
        this.setsEjeMenor(p_sEjeMenor);
    }

    /**
     * Constructor que inicializa la elipse con sus semiejes y centro por defecto en (0, 0).
     * 
     * @param p_sEjeMayor semieje mayor de la elipse
     * @param p_sEjeMenor semieje menor de la elipse
     */
    public Elipse(double p_sEjeMayor, double p_sEjeMenor) {
        super(new Punto(0, 0));
        this.setsEjeMayor(p_sEjeMayor);
        this.setsEjeMenor(p_sEjeMenor);
    }

    /**
     * Constructor por defecto con semiejes en 0 y centro en (0, 0).
     */
    public Elipse() {
        super(new Punto(0, 0));
        this.setsEjeMayor(0.0);
        this.setsEjeMenor(0.0);
    }

    /**
     * Asigna el semieje mayor de la elipse.
     * 
     * @param p_sEjeMayor valor del semieje mayor a asignar
     */
    protected void setsEjeMayor(double p_sEjeMayor) {
        this.sEjeMayor = Math.max(0.0, p_sEjeMayor);
    }

    /**
     * Asigna el semieje menor de la elipse.
     * 
     * @param p_sEjeMenor valor del semieje menor a asignar
     */
    protected void setsEjeMenor(double p_sEjeMenor) {
        this.sEjeMenor = Math.max(0.0, p_sEjeMenor);
    }

    /**
     * Asigna el punto centro de la elipse (equivalente a su origen).
     * 
     * @param p_centro punto central a asignar
     */
    protected void setCentro(Punto p_centro) {
        this.setOrigen(p_centro);
    }

    /**
     * Obtiene el semieje mayor de la elipse.
     * 
     * @return semieje mayor
     */
    public double getsEjeMayor() {
        return this.sEjeMayor;
    }

    /**
     * Obtiene el semieje menor de la elipse.
     * 
     * @return semieje menor
     */
    public double getsEjeMenor() {
        return this.sEjeMenor;
    }

    /**
     * Obtiene el punto central de la elipse.
     * 
     * @return punto central (origen)
     */
    public Punto getCentro() {
        return this.getOrigen();
    }

    /**
     * Desplaza el centro de la elipse en las coordenadas especificadas.
     * 
     * @param p_dx desplazamiento en el eje X
     * @param p_dy desplazamiento en el eje Y
     */
    public void desplazar(double p_dx, double p_dy) {
        if (this.getOrigen() != null) {
            this.getOrigen().desplazar(p_dx, p_dy);
        }
    }

    /**
     * Calcula la superficie o área de la elipse.
     * Fórmula: Pi * sEjeMayor * sEjeMenor
     * 
     * @return superficie de la elipse
     */
    @Override
    public double superficie() {
        return Math.PI * this.getsEjeMayor() * this.getsEjeMenor();
    }

    /**
     * Calcula la distancia entre el centro de esta elipse y el centro de otra.
     * 
     * @param otraElipse elipse con la cual calcular la distancia
     * @return distancia entre los centros
     */
    public double distanciaA(Elipse otraElipse) {
        if (otraElipse == null || otraElipse.getCentro() == null || this.getCentro() == null) {
            return 0.0;
        }
        return this.getCentro().distanciaA(otraElipse.getCentro());
    }

    /**
     * Compara esta elipse con otra y devuelve la de mayor superficie.
     * 
     * @param otraElipse elipse con la cual comparar
     * @return la elipse con mayor superficie
     */
    public Elipse elMayor(Elipse otraElipse) {
        if (otraElipse == null) {
            return this;
        }
        if (this.superficie() >= otraElipse.superficie()) {
            return this;
        } else {
            return otraElipse;
        }
    }

    /**
     * Retorna el nombre de la figura geométrica.
     * 
     * @return nombre de la figura
     */
    @Override
    public String nombreFigura() {
        return "****** Elipse ******";
    }

    /**
     * Muestra por consola las características de la elipse.
     */
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        String coord = (this.getCentro() != null) ? this.getCentro().coordenadas() : "(0.0, 0.0)";
        System.out.println("Centro: " + coord + " - Semieje Mayor: " + this.getsEjeMayor() + " - Semieje Menor: " + this.getsEjeMenor());
        System.out.println("Superficie: " + String.format(java.util.Locale.US, "%.2f", this.superficie()));
    }
}
