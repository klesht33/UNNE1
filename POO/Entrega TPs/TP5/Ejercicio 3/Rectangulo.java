/**
 * Representa una figura geométrica rectangular definida por su punto de origen
 * (esquina inferior izquierda), ancho y alto.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Rectangulo {

    /** Punto de origen del rectángulo. */
    private Punto origen;
    /** Ancho del rectángulo. */
    private double ancho;
    /** Alto del rectángulo. */
    private double alto;

    /**
     * Constructor que inicializa el rectángulo con un punto de origen, ancho y
     * alto.
     * 
     * @param p_origen punto de origen del rectángulo
     * @param p_ancho  ancho del rectángulo
     * @param p_alto   alto del rectángulo
     */
    public Rectangulo(Punto p_origen, double p_ancho, double p_alto) {
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
        this.setOrigen(p_origen != null ? p_origen : new Punto(0, 0));
    }

    /**
     * Constructor que inicializa el rectángulo con ancho y alto, ubicando el origen
     * por defecto en (0, 0).
     * 
     * @param p_ancho ancho del rectángulo
     * @param p_alto  alto del rectángulo
     */
    public Rectangulo(double p_ancho, double p_alto) {
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
        this.setOrigen(new Punto(0, 0));
    }

    /**
     * Asigna el ancho del rectángulo.
     * 
     * @param p_ancho ancho a asignar
     */
    public void setAncho(double p_ancho) {
        this.ancho = Math.max(0.0, p_ancho);
    }

    /**
     * Asigna el alto del rectángulo.
     * 
     * @param p_alto alto a asignar
     */
    public void setAlto(double p_alto) {
        this.alto = Math.max(0.0, p_alto);
    }

    /**
     * Asigna el punto de origen del rectángulo.
     * 
     * @param p_origen punto de origen a asignar
     */
    public void setOrigen(Punto p_origen) {
        this.origen = p_origen != null ? p_origen : new Punto(0, 0);
    }

    /**
     * Obtiene el ancho del rectángulo.
     * 
     * @return ancho del rectángulo
     */
    public double getAncho() {
        return this.ancho;
    }

    /**
     * Obtiene el alto del rectángulo.
     * 
     * @return alto del rectángulo
     */
    public double getAlto() {
        return this.alto;
    }

    /**
     * Obtiene el punto de origen del rectángulo.
     * 
     * @return punto de origen
     */
    public Punto getOrigen() {
        return this.origen;
    }

    /**
     * Desplaza el rectángulo desplazando su punto de origen.
     * 
     * @param p_dx desplazamiento en el eje X
     * @param p_dy desplazamiento en el eje Y
     */
    public void desplazar(double p_dx, double p_dy) {
        if (this.origen != null) {
            this.origen.desplazar(p_dx, p_dy);
        }
    }

    /**
     * Calcula el perímetro del rectángulo.
     * 
     * @return perímetro del rectángulo
     */
    public double perimetro() {
        return 2 * this.getAncho() + 2 * this.getAlto();
    }

    /**
     * Calcula la superficie o área del rectángulo.
     * 
     * @return superficie del rectángulo
     */
    public double superficie() {
        return this.getAncho() * this.getAlto();
    }

    /**
     * Calcula la distancia entre los orígenes de este rectángulo y otro.
     * 
     * @param otroRectangulo rectángulo con el cual calcular la distancia
     * @return distancia euclídea entre los orígenes
     */
    public double distanciaA(Rectangulo otroRectangulo) {
        if (otroRectangulo == null || otroRectangulo.getOrigen() == null || this.getOrigen() == null) {
            return 0.0;
        }
        return this.origen.distanciaA(otroRectangulo.getOrigen());
    }

    /**
     * Compara este rectángulo con otro y retorna el de mayor superficie.
     * 
     * @param otroRectangulo rectángulo a comparar
     * @return el rectángulo de mayor superficie
     */
    public Rectangulo elMayor(Rectangulo otroRectangulo) {
        if (otroRectangulo == null) {
            return this;
        }
        if (this.superficie() >= otroRectangulo.superficie()) {
            return this;
        } else {
            return otroRectangulo;
        }
    }

    /**
     * Retorna el nombre de la figura geométrica.
     * 
     * @return nombre de la figura
     */
    public String nombreFigura() {
        return "****** Rectangulo ******";
    }

    /**
     * Muestra por consola las características de la figura geométrica.
     */
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        String coord = (this.origen != null) ? this.origen.coordenadas() : "(0.0, 0.0)";
        System.out.println("Origen: " + coord + " - Alto: " + this.getAlto() + " - Ancho: " + this.getAncho());
        System.out.println("Superficie: " + this.superficie() + " - Perimetro: " + this.perimetro());
    }

    /**
     * Muestra por consola las características completas del rectángulo.
     */
    public void mostrarDatos() {
        this.caracteristicas();
    }
}
