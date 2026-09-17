import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Pedido {

    private Calendar fecha;
    private Cliente cliente;
    private ArrayList<Producto> productos;

    public Pedido(Calendar p_fecha, Cliente p_cliente, ArrayList<Producto> p_productos) {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
    }

    public Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_producto) {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList<Producto>());
        this.agregarProducto(p_producto);
    }

    private void setFecha(Calendar p_fecha) {
        this.fecha = p_fecha;
    }

    private void setCliente(Cliente p_cliente) {
        this.cliente = p_cliente;
    }

    private void setProductos(ArrayList<Producto> p_productos) {
        this.productos = p_productos;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Calendar getFecha() {
        return this.fecha;
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    public double totalAlContado() {
        double total = 0;
        for (Producto producto : this.getProductos()) {
            total += producto.precioContado();
        }
        return total;
    }

    public double totalFinanciado() {
        double total = 0;
        for (Producto producto : this.getProductos()) {
            total += producto.precioLista();
        }
        return total;
    }

    public boolean quitarProducto(Producto p_producto) {
        return this.getProductos().remove(p_producto);
    }

    public boolean agregarProducto(Producto p_producto) {
        return this.getProductos().add(p_producto);
    }

    public void mostrarPedido() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        String fechaFormateada = dateFormat.format(this.getFecha().getTime());
        System.out.println("****** Detalle del pedido ****** Fecha: " + fechaFormateada + ".");
        System.out.println(String.format("%-20s %-15s %-15s", "Producto", "Precio Lista", "Precio Contado"));
        System.out.println("-------------------------------------------------------");

        for (Producto producto : this.getProductos()) {
            System.out.println(String.format("%-20s %-15.2f %-15.2f",
                    producto.getDescripcion(),
                    producto.precioLista(),
                    producto.precioContado()));
        }

        System.out.println("-------------------------------------------------------");
        System.out.println(String.format("*** Total ------     %-15.2f %-15.2f",
                this.totalFinanciado(),
                this.totalAlContado()));
    }
}