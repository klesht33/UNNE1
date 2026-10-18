/**
 * Representa un círculo geométrico caracterizado por su radio y su punto central.
 * Ahora hereda de Elipse, siendo un caso especial donde ambos semiejes son iguales.
 * 
 * @author Gabi
 * @version 2.0
 */
public class Circulo extends Elipse {

    /**
     * Constructor que crea un círculo especificando su radio y su centro.
     * 
     * @param p_radio  radio del círculo
     * @param p_centro punto central del círculo
     */
    public Circulo(double p_radio, Punto p_centro) {
        // Un círculo es una elipse con semieje mayor y menor iguales al radio
        super(p_radio, p_radio, p_centro);
    }

    /**
     * Constructor por defecto que inicializa el círculo con radio 0 y centro en el origen (0,0).
     */
    public Circulo() {
        super(0, 0, new Punto(0, 0));
    }

    /**
     * Obtiene el radio del círculo (equivalente al semieje mayor).
     * 
     * @return radio del círculo
     */
    public double getRadio() {
        return this.getSEjeMayor(); 
    }

    /**
     * Sobrescribe el nombre de la figura según lo solicitado en el diagrama.
     */
    @Override
    public String nombreFigura() {
        return "****** Circulo ******";
    }

    /**
     * Calcula el perímetro (circunferencia) específico del círculo.
     * 
     * @return perímetro del círculo
     */
    public double perimetro() {
        return 2 * Math.PI * this.getRadio();
    }
    
    // NOTA: Los métodos desplazar(), superficie(), distanciaA(), elMayor() 
    // y caracteristicas() ya no necesitan ser reescritos aquí, pues se 
    // heredan automáticamente de la clase padre Elipse y funcionarán 
    // correctamente gracias al polimorfismo.
}