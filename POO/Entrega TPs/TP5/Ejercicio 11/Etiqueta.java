/**
 * Clase abstracta que representa una etiqueta de packaging en la empresa Etiquet.AR.
 * 
 * @author Gabi
 * @version 1.0
 */
public abstract class Etiqueta {

    private double costo;

    /**
     * Crea una etiqueta con su costo base.
     * 
     * @param p_costo costo base por unidad
     */
    public Etiqueta(double p_costo) {
        this.setCosto(p_costo);
    }

    private void setCosto(double p_costo) {
        this.costo = p_costo;
    }

    public double getCosto() {
        return this.costo;
    }

    /**
     * Calcula y retorna el precio de venta total para una cantidad determinada de etiquetas.
     * 
     * @param p_q cantidad de unidades a vender
     * @return precio total en pesos
     */
    public abstract double precio(int p_q);

    /**
     * Retorna la denominación del tipo de etiqueta.
     * 
     * @return tipo de etiqueta ("Común" o "Premiun")
     */
    protected abstract String tipo();

    /**
     * Retorna una representación en texto con las características de la etiqueta.
     * 
     * @return cadena con el detalle de la etiqueta
     */
    @Override
    public abstract String toString();
}
