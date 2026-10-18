import java.util.ArrayList;

public abstract class Alojamiento {
    private String nombre;
    private double precioBase;
    private int diasAlquiler;
    private ArrayList<Servicio> servicios;

    public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler) {
        this.nombre = p_nombre;
        this.precioBase = p_precioBase;
        this.diasAlquiler = p_diasAlquiler;
        this.servicios = new ArrayList<>();
    }

    public String getNombre() { return this.nombre; }
    public double getPrecioBase() { return this.precioBase; }
    public int getDiasAlquiler() { return this.diasAlquiler; }

    public boolean agregarServicio(Servicio p_servicio) {
        return this.servicios.add(p_servicio);
    }

    public boolean quitarServicio(Servicio p_servicio) {
        return this.servicios.remove(p_servicio);
    }

    public void listarServicios() {
        for (Servicio s : this.servicios) {
            System.out.println(s.getDescripcion() + ": $" + s.getPrecio());
        }
    }

    public double costoServicios() {
        double total = 0.0;
        for (Servicio s : this.servicios) {
            total += s.getPrecio();
        }
        return total;
    }

    public double costo() {
        return this.precioBase * this.diasAlquiler;
    }

    public abstract int contar(String p_alojamiento);

    public void liquidar() {
        System.out.println("Alojamiento: " + this.nombre);
        System.out.println("Costo por " + this.diasAlquiler + " dias: $" + this.costo());
        this.listarServicios();
    }
}