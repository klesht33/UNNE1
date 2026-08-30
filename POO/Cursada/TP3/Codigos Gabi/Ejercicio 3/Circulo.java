/**
 * Representa un círculo geométrico caracterizado por su radio y su punto central.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Circulo {
    /** Radio del círculo. */
    private double radio;
    /** Punto central del círculo. */
    private punto centro;

    /**
     * Constructor que crea un círculo especificando su radio y su centro.
     * 
     * @param p_radio radio del círculo
     * @param p_centro punto central del círculo
     */
    public Circulo(double p_radio, punto p_centro){
        this.setRadio(p_radio);
        this.setCentro(p_centro);
    }

    /**
     * Constructor por defecto que inicializa el círculo con radio 0 y centro en el origen (0,0).
     */
    public Circulo(){
        this.radio = 0;
        this.centro = new punto(0, 0);
    }

    /**
     * Asigna el punto centro del círculo.
     * 
     * @param p_centro centro a asignar
     */
    private void setCentro(punto p_centro){
        this.centro = p_centro;
    }

    /**
     * Asigna el radio del círculo.
     * 
     * @param p_radio radio a asignar
     */
    private void setRadio(double p_radio){
        this.radio = p_radio;
    }
    
    /**
     * Obtiene el punto central del círculo.
     * 
     * @return punto central
     */
    public punto getCentro(){
        return this.centro;
    }

    /**
     * Obtiene el radio del círculo.
     * 
     * @return radio del círculo
     */
    public double getRadio(){
        return this.radio;
    }

    /**
     * Desplaza la posición del círculo sumando los desplazamientos a las coordenadas del centro.
     * 
     * @param p_dx desplazamiento en el eje X
     * @param p_dy desplazamiento en el eje Y
     */
    public void desplazar(double p_dx, double p_dy){
        centro.desplazar(p_dx, p_dy);
    }

    /**
     * Muestra por consola las características del círculo (centro, radio, superficie y perímetro).
     */
    public void caracteristicas(){
        System.out.println("******Circulo*****");
        System.out.println("Centro: " + centro.coordenadas() + " - Radio: " + getRadio());
        System.out.println("Superficie: " + superficie() + " - Perimetro: " + perimetro());
    }

    /**
     * Calcula la superficie o área del círculo.
     * 
     * @return superficie del círculo
     */
    public double superficie(){
        return Math.PI * Math.pow(getRadio(), 2);
    }

    /**
     * Calcula la distancia entre el centro de este círculo y el centro de otro círculo.
     * 
     * @param otroCirculo círculo hasta el cual se calcula la distancia
     * @return distancia entre los centros de ambos círculos
     */
    public double distanciaA(Circulo otroCirculo){
        return this.getCentro().distanciaA(otroCirculo.getCentro());
    }

    /**
     * Compara este círculo con otro y devuelve el de mayor superficie.
     * 
     * @param otroCirculo círculo con el cual comparar
     * @return el círculo con mayor superficie
     */
    public Circulo elMayor(Circulo otroCirculo){
        if(this.superficie() > otroCirculo.superficie()){
            return this;
        } else {
            return otroCirculo;
        }
    }

    /**
     * Calcula el perímetro (circunferencia) del círculo.
     * 
     * @return perímetro del círculo
     */
    public double perimetro(){
        return 2 * Math.PI * getRadio();
    }
}
