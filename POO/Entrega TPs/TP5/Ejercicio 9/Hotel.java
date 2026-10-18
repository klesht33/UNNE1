public class Hotel extends Alojamiento {

    private String tipoHabitacion;

    public Hotel(String p_tipoHabitacion, String p_nombre, double p_precioBase, int p_diasAlquiler) {
        super(p_nombre, p_precioBase, p_diasAlquiler);
        setTipoHabitacion(p_tipoHabitacion);
    }

    private void setTipoHabitacion(String p_tipoHabitacion) {
        this.tipoHabitacion = p_tipoHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public double costo() {

        double adicionalPorDia = this.getTipoHabitacion().equalsIgnoreCase("Single") ? 20.0 : 35.0;
        return super.costo() + (adicionalPorDia + this.getDiasAlquiler());
    }

    public int contar(String p_alojamiento) {
        return p_alojamiento.equalsIgnoreCase("Cabaña") ? 1 : 0;
    }

    public void liquidar() {

        super.liquidar();
        System.out.println("Habitacion" + this.getTipoHabitacion());
        System.out.println("Total: -------> $" + (costo() + super.costoServicios()));
    }

}