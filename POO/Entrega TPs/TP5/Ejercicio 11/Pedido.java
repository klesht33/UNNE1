import java.util.ArrayList;

/**
 * Representa un pedido que agrupa uno o más renglones de etiquetas.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Pedido {

    private ArrayList<Renglon> renglones;

    /**
     * Crea un pedido inicializando la lista de renglones vacía.
     */
    public Pedido() {
        this.setRenglones(new ArrayList<Renglon>());
    }

    /**
     * Crea un pedido con una lista inicial de renglones.
     * 
     * @param p_renglones colección inicial de renglones
     */
    public Pedido(ArrayList<Renglon> p_renglones) {
        this.setRenglones(p_renglones);
    }

    /**
     * Crea un pedido inicializándolo con un primer renglón.
     * 
     * @param p_renglon primer renglón del pedido
     */
    public Pedido(Renglon p_renglon) {
        this.setRenglones(new ArrayList<Renglon>());
        this.agregarRenglon(p_renglon);
    }

    private void setRenglones(ArrayList<Renglon> p_renglones) {
        this.renglones = p_renglones;
    }

    public ArrayList<Renglon> getRenglones() {
        return this.renglones;
    }

    /**
     * Agrega un nuevo renglón al pedido.
     * 
     * @param p_renglon renglón a incorporar
     * @return true si se agregó correctamente
     */
    public boolean agregarRenglon(Renglon p_renglon) {
        return this.getRenglones().add(p_renglon);
    }

    /**
     * Quita un renglón del pedido.
     * 
     * @param p_renglon renglón a remover
     * @return true si se removió correctamente
     */
    public boolean quitarRenglon(Renglon p_renglon) {
        return this.getRenglones().remove(p_renglon);
    }

    /**
     * Muestra por consola el detalle completo del pedido, sus ítems y totales.
     */
    public void mostrar() {
        System.out.println("Pedido:");
        System.out.println("Cantidad de items: " + this.getRenglones().size());

        int totalEtiquetas = 0;
        double totalImporte = 0.0;

        for (int i = 0; i < this.getRenglones().size(); i++) {
            Renglon unRenglon = this.getRenglones().get(i);
            System.out.print("Item " + (i + 1) + ": ");
            unRenglon.mostrar();
            System.out.println("Precio: $ " + unRenglon.getPrecio());

            totalEtiquetas += unRenglon.getCantidad();
            totalImporte += unRenglon.getPrecio();
        }

        System.out.println("--- Total pedido: " + totalEtiquetas + " Etiquetas por un importe total de: $ " + totalImporte);
    }
}
