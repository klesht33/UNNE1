public class Premium extends Etiqueta {
    private int colores;

    public Premium(double p_costo, int p_colores) {
        super(p_costo);
        this.colores = p_colores;
    }

    private double plus() {
        if (this.colores == 1) return 0.0;
        if (this.colores == 2) return 0.05;
        if (this.colores == 3) return 0.07;
        
        // Para más de 3 colores, es 3% por cada color
        return this.colores * 0.03;
    }

    @Override
    public double precio(int q) {
        double bruto = this.costo * q;
        return bruto + (bruto * this.plus());
    }

    @Override
    protected String tipo() {
        // Se utiliza "Premiun" con 'n' para coincidir exactamente con la salida de ejemplo solicitada
        return "Premiun";
    }

    @Override
    public String toString() {
        return "tipo " + this.tipo() + " - Costo: $" + this.costo + " - Colores: " + this.colores;
    }
}