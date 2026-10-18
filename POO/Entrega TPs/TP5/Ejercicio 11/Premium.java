/**
 * Representa una etiqueta premium cuyo costo se incrementa con un adicional
 * según la cantidad de colores requeridos.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Premium extends Etiqueta {

    private int colores;

    /**
     * Crea una etiqueta premium con su costo base y cantidad de colores.
     * 
     * @param p_costo   costo base acordado por unidad
     * @param p_colores cantidad de colores a utilizar
     */
    public Premium(double p_costo, int p_colores) {
        super(p_costo);
        this.setColores(p_colores);
    }

    private void setColores(int p_colores) {
        this.colores = p_colores;
    }

    public int getColores() {
        return this.colores;
    }

    /**
     * Determina el porcentaje de recargo adicional de acuerdo con la cantidad de colores:
     * - 1 color: 0%
     * - 2 colores: 5%
     * - 3 colores: 7%
     * - Más de 3 colores: 3% por cada color
     * 
     * @return porcentaje de recargo en formato decimal (ej: 0.05 para 5%)
     */
    private double plus() {
        if (this.getColores() == 1) {
            return 0.0;
        } else if (this.getColores() == 2) {
            return 0.05;
        } else if (this.getColores() == 3) {
            return 0.07;
        } else {
            // Más de 3 colores: 3% por cada color
            return this.getColores() * 0.03;
        }
    }

    @Override
    public double precio(int p_q) {
        double subtotal = this.getCosto() * p_q;
        return subtotal + (subtotal * this.plus());
    }

    @Override
    protected String tipo() {
        // Se utiliza "Premiun" para respetar el formato exacto del ejemplo de la cátedra
        return "Premiun";
    }

    @Override
    public String toString() {
        return "tipo " + this.tipo() + " - Costo: $" + this.getCosto() + " - Colores: " + this.getColores();
    }
}
