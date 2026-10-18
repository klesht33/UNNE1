public class Comun extends Etiqueta {
    private double plus; // Adicional por el diseño

    public Comun(double p_costo, double p_plus) {
        super(p_costo);
        this.plus = p_plus;
    }

    private double descuento(int q) {
        if (q >= 1 && q <= 10) return 0.0;
        if (q >= 11 && q <= 50) return 0.02;
        if (q >= 51 && q <= 100) return 0.05;
        
        // Para +100 unidades: 1% (0.01) por cada 10 unidades[cite: 10]
        return (q / 10) * 0.01;
    }

    @Override
    public double precio(int q) {
        double bruto = (this.costo * q) + this.plus;
        return bruto - (bruto * this.descuento(q));
    }

    @Override
    protected String tipo() {
        return "Común";
    }

    @Override
    public String toString() {
        return "tipo " + this.tipo() + " - Costo: $" + this.costo + " - Diseño: $" + this.plus;
    }
}