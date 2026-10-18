public class Renglon {
    private int cantidad;
    private double precio;
    private Etiqueta item;

    public Renglon(int p_cantidad, Etiqueta p_item) {
        this.cantidad = p_cantidad;
        this.item = p_item;
        // El precio se calcula delegando la responsabilidad a la etiqueta correspondiente[cite: 10]
        this.precio = this.item.precio(p_cantidad);
    }

    public int getCantidad() { return this.cantidad; }
    public double getPrecio() { return this.precio; }

    public void mostrar() {
        System.out.print(this.cantidad + " Etiquetas de " + this.item.toString());
    }
}