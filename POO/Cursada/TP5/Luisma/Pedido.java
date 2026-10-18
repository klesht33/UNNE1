import java.util.ArrayList;

public class Pedido {
    private ArrayList<Renglon> renglones;

    public Pedido() {
        this.renglones = new ArrayList<>();
    }

    public void agregarRenglon(Renglon r) {
        this.renglones.add(r);
    }

    public void mostrar() {
        System.out.println("Pedido:");
        System.out.println("Cantidad de items: " + this.renglones.size());

        int totalEtiquetas = 0;
        double totalPrecio = 0.0;

        for (int i = 0; i < this.renglones.size(); i++) {
            Renglon r = this.renglones.get(i);
            
            System.out.print("Item " + (i + 1) + ": ");
            r.mostrar();
            System.out.println("\nPrecio: $ " + r.getPrecio());

            totalEtiquetas += r.getCantidad();
            totalPrecio += r.getPrecio();
        }

        System.out.println("Total pedido: " + totalEtiquetas + " Etiquetas por un importe total de: $ " + totalPrecio);
    }
}