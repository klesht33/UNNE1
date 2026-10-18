/**
 * Representa un triángulo en un sistema de coordenadas, como especialización de
 * FiguraGeometrica, definido por su base, altura y punto de origen (extremo inferior izquierdo).
 * 
 * @author Gabi
 * @version 1.0
 */
public class Triangulo extends FiguraGeometrica {

    /** Longitud de la base del triángulo. */
    private double base;
    /** Altura del triángulo. */
    private double altura;

    /**
     * Constructor que inicializa el triángulo con su punto de origen, base y altura.
     * 
     * @param p_origen punto de origen (extremo inferior izquierdo)
     * @param p_base   longitud de la base
     * @param p_altura altura del triángulo
     */
    public Triangulo(Punto p_origen, double p_base, double p_altura) {
        super(p_origen);
        this.setBase(p_base);
        this.setAltura(p_altura);
    }

    /**
     * Asigna la base del triángulo.
     * 
     * @param p_base longitud de la base a asignar
     */
    private void setBase(double p_base) {
        this.base = p_base;
    }

    /**
     * Asigna la altura del triángulo.
     * 
     * @param p_altura altura a asignar
     */
    private void setAltura(double p_altura) {
        this.altura = p_altura;
    }

    /**
     * Obtiene la longitud de la base del triángulo.
     * 
     * @return base del triángulo
     */
    public double getBase() {
        return this.base;
    }

    /**
     * Obtiene la altura del triángulo.
     * 
     * @return altura del triángulo
     */
    public double getAltura() {
        return this.altura;
    }

    /**
     * Retorna el nombre de la figura geométrica.
     * 
     * @return nombre de la figura
     */
    @Override
    public String nombreFigura() {
        return "****** Triángulo ******";
    }

    /**
     * Calcula la superficie del triángulo utilizando la fórmula: (base * altura) / 2.
     * 
     * @return superficie calculada
     */
    @Override
    public double superficie() {
        return (this.getBase() * this.getAltura()) / 2.0;
    }
}
