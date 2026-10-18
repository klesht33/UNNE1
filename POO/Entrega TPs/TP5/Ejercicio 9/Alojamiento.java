import java.util.ArrayList;

public abstract class Alojamiento {

    private String nombre;
    private double precioBase;
    private int diasAlquiler;
    private ArrayList<Servicio> servicio;

    public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler) {
        setNombre(p_nombre);
        setPrecioBase(p_precioBase);
        setDiasAlquiler(p_diasAlquiler);
        setServicios(new ArrayList<Servicio>());

    }

    private void setDiasAlquiler(int p_diasAlquiler) {
        this.diasAlquiler = p_diasAlquiler;
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setPrecioBase(double p_precioBase) {
        this.precioBase = p_precioBase;
    }

    private void setServicios(ArrayList<Servicio> p_servicios) {
        this.servicio = p_servicios;
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public ArrayList<Servicio> getServicio() {
        return servicio;
    }

    public boolean agregarServicio(Servicio p_servicio) {
        return this.getServicio().add(p_servicio);
    }

    public boolean quitarServicio(Servicio p_Servicio) {
        return this.getServicio().remove(p_Servicio);
    }

    public abstract int contar(String p_alojamiento);

    public double costo() {
        return this.getPrecioBase() * this.getDiasAlquiler();
    }

    public void listarServicios() {
        for (Servicio unServicio : this.getServicio()) {
            System.out.println(unServicio.getDescripcion() + ": $" + unServicio.getPrecio());
        }
    }

    public double costoServicios() {
        double costo = 0.0;
        for (Servicio unServicio : this.getServicio()) {
            costo += unServicio.getPrecio();
        }

        return costo;
    }

    public void liquidar() {
        System.out.println("Alojamiento: " + this.getNombre());
        System.out.println("Costo por: " + this.getDiasAlquiler() + "Dias: $" + costo() + "Alquiler");
        this.listarServicios();
    }
}
