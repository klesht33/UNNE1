/**
 * La clase Punto representa un punto en un plano cartesiano,
 * definido por sus coordenadas X e Y.
 *
 * @author Gabi
 * @version 1.0
 */
public class Punto {

    /**
     * Coordenada X del punto.
     */
    private double x;

    /**
     * Coordenada Y del punto.
     */
    private double y;

    /**
     * Constructor por defecto.
     * Crea un punto en las coordenadas (0, 0).
     */
    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructor que permite crear un punto con coordenadas determinadas.
     *
     * @param p_x coordenada X del punto
     * @param p_y coordenada Y del punto
     */
    public Punto(double p_x, double p_y) {
        this.x = p_x;
        this.y = p_y;
    }

    /**
     * Modifica la coordenada X del punto.
     *
     * @param p_x nuevo valor de la coordenada X
     */
    private void setX(double p_x) {
        this.x = p_x;
    }

    /**
     * Modifica la coordenada Y del punto.
     *
     * @param p_y nuevo valor de la coordenada Y
     */
    private void setY(double p_y) {
        this.y = p_y;
    }

    /**
     * Obtiene la coordenada X del punto.
     *
     * @return valor de la coordenada X
     */
    public double getX() {
        return this.x;
    }

    /**
     * Obtiene la coordenada Y del punto.
     *
     * @return valor de la coordenada Y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Calcula la distancia euclídea entre este punto y otro punto recibido por
     * parámetro.
     * 
     * @param ptoDistante punto hacia el cual se calcula la distancia
     * @return distancia euclídea entre ambos puntos
     */
    public double distanciaA(Punto ptoDistante) {
        if (ptoDistante == null) {
            return 0.0;
        }
        // Diferencia en X
        double dx = ptoDistante.getX() - this.getX();
        // Diferencia en Y
        double dy = ptoDistante.getY() - this.getY();
        // Pitagoras
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Desplaza el punto sumando los valores indicados
     * a sus coordenadas actuales.
     *
     * @param p_dx desplazamiento sobre el eje X
     * @param p_dy desplazamiento sobre el eje Y
     */
    public void desplazar(double p_dx, double p_dy) {
        setX(getX() + p_dx);
        setY(getY() + p_dy);
    }

    /**
     * Muestra por pantalla las coordenadas del punto.
     */
    public void mostrar() {
        System.out.println("Punto. X: " + getX() + ", Y: " + getY());
    }

    /**
     * Devuelve las coordenadas del punto en forma de cadena.
     *
     * @return cadena con el formato (x, y)
     */
    public String coordenadas() {
        return "(" + getX() + ", " + getY() + ")";
    }
}