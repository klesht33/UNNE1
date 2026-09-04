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
public class Empleado {
    /** CUIL del empleado */
    private long cuil;
    /** Apellido del empleado */
    private String apellido;
    /** Nombre del empleado */
    private String nombre;
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
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_sueldoBasico, Calendar p_fechaIngreso) {
        setCuil(p_cuil);
        setApellido(p_apellido);
        setNombre(p_nombre);
        setSueldoBasico(p_sueldoBasico);
        setFechaIngreso(p_fechaIngreso);
    }

    /**
     * Constructor con año de ingreso como entero.
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_sueldoBasico, int p_anioIngreso) {
        setCuil(p_cuil);
        setApellido(p_apellido);
        setNombre(p_nombre);
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
     * Establece el apellido del empleado.
     * 
     * @param apellido Apellido a asignar
     */
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    /**
     * Establece el año de ingreso a partir de un entero.
     * 
     * @param p_anioIngreso Año de ingreso a asignar
     */
    private void setAnioIngreso(int p_anioIngreso) {
        Calendar auxFecha = new GregorianCalendar();
        auxFecha.set(Calendar.YEAR, p_anioIngreso);
        this.setFechaIngreso(auxFecha);
    }

    /**
     * Establece el nombre del empleado.
     * 
     * @param nombre Nombre a asignar
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /**
     * Establece el sueldo básico del empleado.
     * 
     * @param sueldoBasico Sueldo básico a asignar
     */
    private void setSueldoBasico(double p_sueldoBasico) {
        this.sueldoBasico = p_sueldoBasico;
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
     * Retorna el nombre y apellido del empleado.
     * 
     * @return Cadena con formato "nombre apellido"
     */
    public String nombreYApellido() {
        return nombre + " " + apellido;
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
     * Obtiene el apellido del empleado.
     * 
     * @return Apellido del empleado
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el nombre del empleado.
     * 
     * @return Nombre del empleado
     */
    public String getNombre() {
        return nombre;
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
     * Obtiene el nombre y apellido del empleado en formato "nombre apellido".
     * 
     * @return Cadena con nombre y apellido
     */
    public String getNomYApe() {
        return getNombre() + " " + getApellido();
    }

    /**
     * Calcula la antigüedad del empleado en años.
     * La antigüedad se obtiene restando el año de ingreso al año actual.
     * 
     * @return Años de antigüedad del empleado
     */
    public int antiguedad() {
        GregorianCalendar fechaActual = new GregorianCalendar();
        return fechaActual.get(GregorianCalendar.YEAR) - getFechaIngreso().get(Calendar.YEAR);
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
        System.out.println("Nombre y Apellido: " + getNomYApe());
        System.out.println("CUIL: " + getCuil() + "Antiguedad: " + antiguedad() + " años de servicio");
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

        Calendar hoy = new GregorianCalendar();

        if (hoy.get(Calendar.MONTH) == getFechaIngreso().get(Calendar.MONTH)
                && hoy.get(Calendar.DAY_OF_MONTH) == getFechaIngreso().get(Calendar.DAY_OF_MONTH)) {
            return true;
        } else {
            return false;
        }

    }

}
