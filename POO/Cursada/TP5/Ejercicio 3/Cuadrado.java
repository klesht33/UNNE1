/**
 * Representa una figura geométrica cuadrada como una especialización de
 * Rectangulo,
 * donde todos sus lados son de igual longitud.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Cuadrado extends Rectangulo {

    /**
     * Constructor que inicializa el cuadrado con un punto de origen y la longitud
     * del lado.
     * 
     * @param p_origen punto de origen del cuadrado
     * @param p_lado   longitud del lado del cuadrado
     */
    public Cuadrado(Punto p_origen, double p_lado) {
        super(p_origen, p_lado, p_lado);
    }

    /**
     * Constructor que inicializa el cuadrado con la longitud del lado y el origen
     * por defecto en (0, 0).
     * 
     * @param p_lado longitud del lado del cuadrado
     */
    public Cuadrado(double p_lado) {
        super(p_lado, p_lado);
    }

    /**
     * Modifica la longitud del lado del cuadrado, manteniendo la igualdad de ancho
     * y alto.
     * 
     * @param p_lado nueva longitud del lado
     */
    public void setLado(double p_lado) {
        super.setAncho(p_lado);
        super.setAlto(p_lado);
    }

    /**
     * Obtiene la longitud del lado del cuadrado.
     * 
     * @return longitud del lado
     */
    public double getLado() {
        return this.getAlto();
    }

    /**
     * Asigna el ancho del cuadrado, ajustando también su alto para mantener la
     * figura cuadrada.
     * 
     * @param p_ancho nuevo ancho y alto del cuadrado
     */
    @Override
    public void setAncho(double p_ancho) {
        super.setAncho(p_ancho);
        super.setAlto(p_ancho);
    }

    /**
     * Asigna el alto del cuadrado, ajustando también su ancho para mantener la
     * figura cuadrada.
     * 
     * @param p_alto nuevo alto y ancho del cuadrado
     */
    @Override
    public void setAlto(double p_alto) {
        super.setAncho(p_alto);
        super.setAlto(p_alto);
    }

    /**
     * Retorna el nombre de la figura geométrica.
     * 
     * @return cadena con el nombre de la figura
     */
    @Override
    public String nombreFigura() {
        return "****** Cuadrado ******";
    }

    /**
     * Muestra por consola las características particulares del cuadrado:
     * origen, longitud del lado, superficie y perímetro.
     */
    @Override
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        String coord = (this.getOrigen() != null) ? this.getOrigen().coordenadas() : "(0.0, 0.0)";
        System.out.println("Origen: " + coord + " - Lado: " + this.getAlto());
        System.out.println("Superficie: " + String.format(java.util.Locale.US, "%.2f", this.superficie())
                + "  - Perimetro: " + String.format(java.util.Locale.US, "%.2f", this.perimetro()));
    }

    /**
     * Método ejecutable principal para prueba directa de la clase.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        Punto puntoOrigen = new Punto(5.0, 3.0);
        double ladoCuadrado = 72.99;
        Cuadrado cuadrado = new Cuadrado(puntoOrigen, ladoCuadrado);
        cuadrado.caracteristicas();
    }
}
