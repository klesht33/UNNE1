/**
 * Representa un renglón o ítem individual dentro de un pedido de etiquetas.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Renglon {

    private int cantidad;
    private double precio;
    private Etiqueta item;

    /**
     * Crea un renglón con la cantidad solicitada y la etiqueta correspondiente,
     * calculando el precio total delegando el cálculo en la propia etiqueta.
     * 
     * @param p_cantidad cantidad de etiquetas del ítem
     * @param p_item     etiqueta requerida
     */
    public Renglon(int p_cantidad, Etiqueta p_item) {
        this.setCantidad(p_cantidad);
        this.setItem(p_item);
        this.setPrecio(this.getItem().precio(p_cantidad));
    }

    private void setCantidad(int p_cantidad) {
        this.cantidad = p_cantidad;
    }

    private void setPrecio(double p_precio) {
        this.precio = p_precio;
    }

    private void setItem(Etiqueta p_item) {
        this.item = p_item;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public double getPrecio() {
        return this.precio;
    }

    public Etiqueta getItem() {
        return this.item;
    }

    /**
     * Muestra por consola el detalle del renglón según el formato requerido.
     */
    public void mostrar() {
        System.out.println(this.getCantidad() + " Etiquetas de " + this.getItem().toString());
    }
}
