public abstract class ArtefactoHogar {
    private String marca;
    private float precio;
    private int stock;

    public ArtefactoHogar(String p_marca, float p_precio, int p_stock) {
        this.marca = p_marca;
        this.precio = p_precio;
        this.stock = p_stock;
    }

    public String getMarca() { return this.marca; }
    public float getPrecio() { return this.precio; }
    public int getStock() { return this.stock; }

    public void imprimir() {
        System.out.println("Marca: " + this.marca + " Precio: " + this.precio + " Stock: " + this.stock);
    }

    public float cuotaCredito(int p_cuotas, float p_interes) {
        float cuotaPura = this.precio / p_cuotas;
        float recargoInteres = this.precio * (p_interes / 100f);
        return cuotaPura + recargoInteres;
    }

    // Método abstracto que las subclases deberán implementar
    public abstract float creditoConAdicional(int p_cuotas, float p_interes);
}