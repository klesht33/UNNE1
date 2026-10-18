/**
 * Representa una etiqueta común con costo base y plus por diseño,
 * sujeta a descuentos según la cantidad de unidades solicitadas.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Comun extends Etiqueta {

    private double plus;

    /**
     * Crea una etiqueta común con su costo base y plus de diseño.
     * 
     * @param p_costo costo base por unidad ($100 según el enunciado)
     * @param p_plus  adicional por el diseño
     */
    public Comun(double p_costo, double p_plus) {
        super(p_costo);
        this.setPlus(p_plus);
    }

    private void setPlus(double p_plus) {
        this.plus = p_plus;
    }

    public double getPlus() {
        return this.plus;
    }

    /**
     * Determina el porcentaje de descuento aplicable según la cantidad de unidades:
     * - 1 a 10: 0%
     * - 11 a 50: 2%
     * - 51 a 100: 5%
     * - +100: 1% cada 10 unidades
     * 
     * @param p_q cantidad de unidades
     * @return porcentaje de descuento en formato decimal (ej: 0.05 para 5%)
     */
    private double descuento(int p_q) {
        if (p_q >= 1 && p_q <= 10) {
            return 0.0;
        } else if (p_q >= 11 && p_q <= 50) {
            return 0.02;
        } else if (p_q >= 51 && p_q <= 100) {
            return 0.05;
        } else {
            // Más de 100 unidades: 1% por cada 10 unidades
            return (p_q / 10) * 0.01;
        }
    }

    @Override
    public double precio(int p_q) {
        double subtotal = (this.getCosto() * p_q) + this.getPlus();
        return subtotal - (subtotal * this.descuento(p_q));
    }

    @Override
    protected String tipo() {
        return "Común";
    }

    @Override
    public String toString() {
        return "tipo " + this.tipo() + " - Costo: $" + this.getCosto() + " - Diseño: $" + this.getPlus();
    }
}
