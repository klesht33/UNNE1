import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Clase que representa un empleado con sus datos personales y salariales.
 * Permite calcular el sueldo neto considerando descuentos y adicionales
 * según la antigüedad del empleado.
 * 
 * @author Usuario
 * @version 1.0
 */
public class Empleado extends Persona {
    /** CUIL del empleado */
    private long cuil;
    /** Sueldo básico mensual del empleado */
    private double sueldoBasico;
    /** Año de ingreso del empleado a la empresa */
    private Calendar fechaIngreso;

    /**
     * Constructor de la clase empleado.
     * Inicializa un empleado con sus datos personales y salariales.
     * 
     * @param cuil         CUIL del empleado
     * @param apellido     Apellido del empleado
     * @param nombre       Nombre del empleado
     * @param sueldoBasico Sueldo básico mensual del empleado
     * @param anioIngreso  Año de ingreso del empleado
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_sueldoBasico, Calendar p_fechaIngreso,
            int p_dni, int p_anioNacimiento) {
        super(p_dni, p_nombre, p_apellido, p_anioNacimiento);
        setCuil(p_cuil);
        setSueldoBasico(p_sueldoBasico);
        setFechaIngreso(p_fechaIngreso);
    }

    /**
     * Constructor con año de ingreso como entero.
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_sueldoBasico, int p_anioIngreso,
            int p_dni, int p_anioNacimiento) {
        super(p_dni, p_nombre, p_apellido, p_anioNacimiento);
        setCuil(p_cuil);
        setSueldoBasico(p_sueldoBasico);
        setAnioIngreso(p_anioIngreso);
    }

    /**
     * Establece el CUIL del empleado.
     * 
     * @param cuil CUIL a asignar
     */
    private void setCuil(long p_cuil) {
        this.cuil = p_cuil;
    }

    /**
     * Establece el año de ingreso a partir de un entero.
     * 
     * @param p_anioIngreso Año de ingreso a asignar
     */
    private void setAnioIngreso(int p_anioIngreso) {
        Calendar auxFecha = new GregorianCalendar(p_anioIngreso, Calendar.JANUARY, 1);
        this.setFechaIngreso(auxFecha);
    }

    /**
     * Establece el sueldo básico del empleado.
     * 
     * @param sueldoBasico Sueldo básico a asignar
     */
    private void setSueldoBasico(double p_sueldoBasico) {
        this.sueldoBasico = Math.max(0.0, p_sueldoBasico);
    }

    /**
     * Establece el año de ingreso del empleado.
     * 
     * @param anioIngreso Año de ingreso a asignar
     */
    private void setFechaIngreso(Calendar p_fechaIngreso) {
        this.fechaIngreso = p_fechaIngreso;
    }

    /**
     * Obtiene el CUIL del empleado.
     * 
     * @return CUIL del empleado
     */
    public long getCuil() {
        return cuil;
    }

    /**
     * Obtiene el sueldo básico del empleado.
     * 
     * @return Sueldo básico mensual
     */
    public double getSueldoBasico() {
        return sueldoBasico;
    }

    /**
     * Obtiene el año de ingreso del empleado.
     * 
     * @return Año de ingreso del empleado
     */
    public Calendar getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Obtiene el año de ingreso del empleado.
     * 
     * @return Año de ingreso del empleado
     */
    public int getAnioIngreso() {
        return getFechaIngreso().get(Calendar.YEAR);
    }

    /**
     * Calcula la antigüedad del empleado en años.
     * La antigüedad se obtiene restando el año de ingreso al año actual.
     * 
     * @return Años de antigüedad del empleado
     */
    public int antiguedad() {
        if (getFechaIngreso() == null) {
            return 0;
        }
        Calendar fechaActual = new GregorianCalendar();
        int antiguedad = fechaActual.get(Calendar.YEAR) - getFechaIngreso().get(Calendar.YEAR);
        if (fechaActual.get(Calendar.DAY_OF_YEAR) < getFechaIngreso().get(Calendar.DAY_OF_YEAR)) {
            antiguedad--;
        }
        return Math.max(0, antiguedad);
    }

    /**
     * Calcula el descuento aplicado al sueldo del empleado.
     * El descuento es el 2% del sueldo básico más una cantidad fija de $1500.
     * 
     * @return Monto de descuento a aplicar
     */
    private double descuento() {
        return getSueldoBasico() * 0.02 + 1500;
    }

    /**
     * Calcula el adicional por antigüedad del empleado.
     * El adicional depende de los años de antigüedad:
     * - 10 años o más: 6% del sueldo básico
     * - 2 a 9 años: 4% del sueldo básico
     * - Menos de 2 años: 2% del sueldo básico
     * 
     * @return Monto del adicional por antigüedad
     */
    private double adicional() {

        if (antiguedad() >= 10) {
            return getSueldoBasico() * 0.06;
        } else if (antiguedad() >= 2) {
            return getSueldoBasico() * 0.04;
        } else {
            return getSueldoBasico() * 0.02;
        }

    }

    /**
     * Calcula el sueldo neto del empleado.
     * El sueldo neto se obtiene sumando el sueldo básico con el adicional
     * por antigüedad y restando los descuentos.
     * 
     * @return Sueldo neto del empleado
     */
    public double sueldoNeto() {
        return getSueldoBasico() + adicional() - descuento();
    }

    /**
     * Muestra en la consola los datos completos del empleado.
     * Imprime nombre, apellido, CUIL, antigüedad y sueldo neto.
     */
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + super.nomYAp());
        System.out.println("DNI: " + super.getDNI() + "Edad: " + super.edad());
        System.out.println("CUIL: " + getCuil() + " Antiguedad: " + antiguedad() + " años de servicio");
        System.out.println("Sueldo Neto: $" + sueldoNeto());
    }

    /**
     * Muestra en la consola los datos del empleado en una sola línea.
     * Formato: CUIL apellido, nombre sueldo_neto
     */
    public void mostrarLinea() {
        System.out.println("" + getCuil() + " " + getApellido() + ", " + " " + getNombre() + " " + " $" + sueldoNeto());
    }

    public boolean esAniversario() {
        if (getFechaIngreso() == null) {
            return false;
        }
        Calendar hoy = new GregorianCalendar();

        if (hoy.get(Calendar.MONTH) == getFechaIngreso().get(Calendar.MONTH)
                && hoy.get(Calendar.DAY_OF_MONTH) == getFechaIngreso().get(Calendar.DAY_OF_MONTH)) {
            return true;
        } else {
            return false;
        }

    }

}
