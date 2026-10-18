public abstract class Etiqueta {
    protected double costo;

    public Etiqueta(double p_costo) {
        this.costo = p_costo;
    }

    public abstract double precio(int q);
    protected abstract String tipo();
    public abstract String toString();
}