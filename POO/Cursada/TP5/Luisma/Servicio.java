public class Servicio {
    private String descripcion;
    private double precio;

    public Servicio(String p_descripcion, double p_precio) {
        this.descripcion = p_descripcion;
        this.precio = p_precio;
    }

    public String getDescripcion() { return this.descripcion; }
    public double getPrecio() { return this.precio; }
}