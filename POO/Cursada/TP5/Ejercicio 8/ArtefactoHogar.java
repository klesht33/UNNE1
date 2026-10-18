public abstract class ArtefactoHogar {

    private String marca;
    private float precio;
    private int stock;

    public ArtefactoHogar(String p_marca, float p_precio, int p_stock) {
        this.setMarca(p_marca);
        this.setPrecio(p_precio);
        this.setStock(p_stock);
    }

    private void setMarca(String p_marca) {
        this.marca = p_marca;
    }

    private void setPrecio(float p_precio) {
        this.precio = p_precio;
    }

    private void setStock(int p_stock) {
        this.stock = p_stock;
    }

    public String getMarca() {
        return this.marca;
    }

    public float getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
    }

    public void imprimir() {
        System.out.println("Marca: " + this.getMarca() + " - Precio: " + this.getPrecio() + " - Stock: " + this.getStock());
    }

    public float cuotaCredito(int p_cuotas, float p_interes) {
        float totalInteres = this.getPrecio() * (p_interes / 100.0f) * p_cuotas;
        return (this.getPrecio() + totalInteres) / p_cuotas;
    }

    public abstract float creditoConAdicional(int p_cuotas, float p_interes);
}
