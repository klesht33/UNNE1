public class Servicio {

    private String descripcion;
    private double precio;

    public Servicio(String p_descripcion, double p_precio) {
        setDescripcion(p_descripcion);
        setPrecio(p_precio);
    }

    private void setDescripcion(String p_descripcion) {
        this.descripcion = p_descripcion;
    }

    private void setPrecio(double p_precio) {
        this.precio = p_precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

}
