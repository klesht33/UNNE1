import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cargo {
    private String nombreCargo;
    private double sueldoBasico;
    private int anioIngreso;
    private int horasDeDocencia;

    public Cargo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDocencia) {
        this.nombreCargo = p_nombreCargo;
        this.sueldoBasico = p_sueldoBasico;
        this.anioIngreso = p_anioIngreso;
        this.horasDeDocencia = p_horasDocencia;
    }

    public int antiguedad() {
        Calendar hoy = new GregorianCalendar();
        int anioActual = hoy.get(Calendar.YEAR);
        return Math.max(0, anioActual - this.anioIngreso);
    }

    private double adicionalXAntiguedad() {
        // Un 1% del sueldo básico por año de antigüedad
        return this.sueldoBasico * 0.01 * this.antiguedad();
    }

    public double sueldoDelCargo() {
        return this.sueldoBasico + this.adicionalXAntiguedad();
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public int getHorasDeDocencia() {
        return horasDeDocencia;
    }

    public void mostrarCargo() {
        System.out.println(this.nombreCargo + " - Sueldo Basico: " + this.sueldoBasico + 
                           " - Sueldo Cargo: " + this.sueldoDelCargo() + " - Antiguedad: " + this.antiguedad() + " años");
        System.out.println("Horas Docencia: " + this.horasDeDocencia);
    }
}