/**
 * Representa un círculo como un caso especial de elipse, donde ambos semiejes
 * asumen el mismo valor (radio).
 * 
 * @author Gabi
 * @version 1.0
 */
public class Circulo extends Elipse {

    /**
     * Constructor que crea un círculo especificando su radio y su centro.
     * 
     * @param p_radio  radio del círculo
     * @param p_centro punto central del círculo
     */
    public Circulo(double p_radio, Punto p_centro) {
        super(p_radio, p_radio, p_centro);
    }

    /**
     * Constructor que crea un círculo especificando su radio y ubicando el centro en (0, 0).
     * 
     * @param p_radio radio del círculo
     */
    public Circulo(double p_radio) {
        super(p_radio, p_radio);
    }

    /**
     * Constructor por defecto con radio 0 y centro en el origen (0, 0).
     */
    public Circulo() {
        super(0.0, 0.0);
    }

    /**
     * Retorna el nombre de la figura geométrica.
     * 
     * @return cadena con el nombre de la figura
     */
    @Override
    public String nombreFigura() {
        return "****** Circulo ******";
    }

    /**
     * Obtiene el radio del círculo.
     * 
     * @return radio del círculo
     */
    public double getRadio() {
        return this.getsEjeMayor();
    }

    /**
     * Asigna el radio del círculo, actualizando ambos semiejes.
     * 
     * @param p_radio nuevo radio a asignar
     */
    public void setRadio(double p_radio) {
        this.setsEjeMayor(p_radio);
        this.setsEjeMenor(p_radio);
    }

    /**
     * Calcula el perímetro (circunferencia) del círculo.
     * 
     * @return perímetro del círculo
     */
    public double perimetro() {
        return 2 * Math.PI * this.getRadio();
    }

    /**
     * Método ejecutable principal para prueba directa de la clase.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        Circulo circulo = new Circulo(10.0, new Punto(5.0, 3.0));
        circulo.caracteristicas();
    }
}
