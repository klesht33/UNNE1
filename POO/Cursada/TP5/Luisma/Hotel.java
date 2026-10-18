public class Hotel extends Alojamiento {
    private String tipoHabitacion;

    public Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler, String p_tipoHabitacion) {
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.tipoHabitacion = p_tipoHabitacion;
    }

    @Override
    public double costo() {
        double recargo = 0.0;
        if (this.tipoHabitacion.equalsIgnoreCase("Single")) {
            recargo = 20.0;
        } else if (this.tipoHabitacion.equalsIgnoreCase("Doble")) {
            recargo = 35.0;
        }
        return super.costo() + (recargo * this.getDiasAlquiler());
    }

    @Override
    public int contar(String p_alojamiento) {
        return p_alojamiento.equalsIgnoreCase("Hotel") ? 1 : 0;
    }

    @Override
    public void liquidar() {
        super.liquidar();
        System.out.println("Habitacion " + this.tipoHabitacion);
        System.out.println("Total: ----> $" + (this.costo() + this.costoServicios()));
    }
}