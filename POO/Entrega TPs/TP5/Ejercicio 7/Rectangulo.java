/**
 * Representa una figura geométrica rectangular definida por su punto de origen
 * (esquina inferior izquierda), ancho y alto, como especialización de FiguraGeometrica.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Rectangulo extends FiguraGeometrica {

    /** Ancho del rectángulo. */
    private double ancho;
    /** Alto del rectángulo. */
    private double alto;

    /**
     * Constructor que inicializa el rectángulo con un punto de origen, ancho y alto.
     * 
     * @param p_origen punto de origen del rectángulo
     * @param p_ancho  ancho del rectángulo
     * @param p_alto   alto del rectángulo
     */
    public Rectangulo(Punto p_origen, double p_ancho, double p_alto) {
        super(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
    }

    /**
     * Constructor que inicializa el rectángulo con ancho y alto, ubicando el origen
     * por defecto en (0, 0).
     * 
     * @param p_ancho ancho del rectángulo
     * @param p_alto  alto del rectángulo
     */
    public Rectangulo(double p_ancho, double p_alto) {
        super(new Punto(0, 0));
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
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
     * Desplaza el rectángulo desplazando su punto de origen.
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
    @Override
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
        return this.getOrigen().distanciaA(otroRectangulo.getOrigen());
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
    @Override
    public String nombreFigura() {
        return "****** Rectangulo ******";
    }

    /**
     * Muestra por consola las características de la figura geométrica.
     */
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        String coord = (this.getOrigen() != null) ? this.getOrigen().coordenadas() : "(0.0, 0.0)";
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
