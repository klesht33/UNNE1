import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cargo {

    private String nombreCargo;
    private double sueldoBasico;
    private int anioIngreso;
    private int horasDeDocencia;

    public Cargo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDeDocencia) {

        setNombreCargo(p_nombreCargo);
        setSueldoBasico(p_sueldoBasico);
        setAnioIngreso(p_anioIngreso);
        setHorasDeDocencia(p_horasDeDocencia);
    }

    private void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    private void setHorasDeDocencia(int horasDeDocencia) {
        this.horasDeDocencia = horasDeDocencia;
    }

    private void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    private void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public int getHorasDeDocencia() {
        return horasDeDocencia;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public int antiguedad() {
        Calendar fechaActual = new GregorianCalendar();
        int anioActual = fechaActual.get(Calendar.YEAR);

        return anioActual - this.getAnioIngreso();
    }

    private double adicionalXAntiguedad() {
        return (this.getSueldoBasico() * 0.01) * this.antiguedad();

    }

    public double sueldoDelCargo() {
        return this.getSueldoBasico() + this.adicionalXAntiguedad();
    }

    public void mostrarCargo() {
        System.out.println(this.getNombreCargo() + " - Sueldo Basico: " + this.getSueldoBasico() + " - Sueldo Cargo: "
                + this.sueldoDelCargo() + " - Antiguedad: " + this.antiguedad() + "Anios" + "\n" + "- Horas Docencia: "
                + this.getHorasDeDocencia());
    }

}
