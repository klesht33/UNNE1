public class Cabaña extends Alojamiento {
    private int nroHabitaciones;

    public Cabaña(String p_nombre, double p_precioBase, int p_diasAlquiler, int p_nroHabitaciones) {
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.nroHabitaciones = p_nroHabitaciones;
    }

    @Override
    public double costo() {
        // Se agrega $30 por día por cada habitación
        double adicional = 30.0 * this.getDiasAlquiler() * this.nroHabitaciones;
        return super.costo() + adicional;
    }

    @Override
    public int contar(String p_alojamiento) {
        return p_alojamiento.equalsIgnoreCase("Cabaña") ? 1 : 0;
    }

    @Override
    public void liquidar() {
        super.liquidar();
        System.out.println("Cabaña con " + this.nroHabitaciones + " habitaciones");
        System.out.println("Total: ----> $" + (this.costo() + this.costoServicios()));
    }
}