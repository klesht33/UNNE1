/**
 * Representa un cuadrado, que es un caso particular de un rectángulo 
 * donde el ancho y el alto son iguales.
 */
public class Cuadrado extends Rectangulo {

    /**
     * Constructor que inicializa el cuadrado. 
     * Llama al constructor de Rectangulo pasando el lado como ancho y como alto[cite: 1].
     * 
     * @param p_origen punto de origen del cuadrado
     * @param p_lado   medida de los lados del cuadrado
     */
    public Cuadrado(Punto p_origen, double p_lado) {
        super(p_origen, p_lado, p_lado);
    }

    /**
     * Redefine el nombre de la figura[cite: 1].
     */
    @Override
    public String nombreFigura() {
        return "****** Cuadrado ******";
    }

    /**
     * Redefine la impresión de características para mostrar "Lado" en lugar de "Alto" y "Ancho"[cite: 1].
     */
    @Override
    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        
        // Obtenemos las coordenadas del origen (si existe)
        String coord = (this.getOrigen() != null) ? this.getOrigen().coordenadas() : "(0.0, 0.0)";
        
        // Como es un cuadrado, el lado es igual al ancho (o alto), así que usamos getAncho()[cite: 14]
        System.out.println("Origen: " + coord + " - Lado: " + this.getAncho());
        System.out.println("Superficie: " + this.superficie() + " - Perimetro: " + this.perimetro());
    }
}