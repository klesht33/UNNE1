import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Representa una persona mediante sus datos personales y fecha de nacimiento.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Persona {

    /** Documento Nacional de Identidad de la persona. */
    private int dni;
    /** Nombre de la persona. */
    private String nombre;
    /** Apellido de la persona. */
    private String apellido;
    /** Fecha de nacimiento de la persona. */
    private Calendar fechaNacimiento;

    /**
     * Constructor que crea una persona recibiendo el año de nacimiento (mantiene protocolo anterior).
     *
     * @param p_dni      Documento Nacional de Identidad
     * @param p_nombre   Nombre de la persona
     * @param p_apellido Apellido de la persona
     * @param p_anio     Año de nacimiento
     */
    public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio) {
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnioNacimiento(p_anio);
    }

    /**
     * Constructor que crea una persona recibiendo la fecha de nacimiento completa.
     *
     * @param p_dni      Documento Nacional de Identidad
     * @param p_nombre   Nombre de la persona
     * @param p_apellido Apellido de la persona
     * @param p_fecha    Fecha de nacimiento como Calendar
     */
    public Persona(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha) {
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setFechaNacimiento(p_fecha);
    }

    /**
     * Asigna el Documento Nacional de Identidad.
     * 
     * @param p_dni DNI a asignar
     */
    private void setDNI(int p_dni) {
        this.dni = p_dni;
    }

    /**
     * Asigna el nombre de la persona.
     * 
     * @param p_nombre nombre a asignar
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /**
     * Asigna el apellido de la persona.
     * 
     * @param p_apellido apellido a asignar
     */
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    /**
     * Asigna el año de nacimiento estableciendo la fecha al 1 de enero de dicho año.
     * 
     * @param p_anio año de nacimiento
     */
    private void setAnioNacimiento(int p_anio) {
        this.fechaNacimiento = new GregorianCalendar(p_anio, Calendar.JANUARY, 1);
    }

    /**
     * Asigna la fecha de nacimiento de la persona.
     * 
     * @param p_fecha fecha de nacimiento
     */
    private void setFechaNacimiento(Calendar p_fecha) {
        this.fechaNacimiento = p_fecha;
    }

    /**
     * Obtiene el Documento Nacional de Identidad.
     * 
     * @return DNI de la persona
     */
    public int getDNI() {
        return this.dni;
    }

    /**
     * Obtiene el DNI (alias con convención camelCase).
     * 
     * @return DNI de la persona
     */
    public int getDni() {
        return this.dni;
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return nombre de la persona
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     * 
     * @return apellido de la persona
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * Obtiene el año de nacimiento de la persona.
     * 
     * @return año de nacimiento
     */
    public int getAnioNacimiento() {
        return this.getFechaNacimiento().get(Calendar.YEAR);
    }

    /**
     * Obtiene la fecha de nacimiento completa como Calendar.
     * 
     * @return fecha de nacimiento
     */
    public Calendar getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    /**
     * Calcula la edad exacta de la persona en función de la fecha actual.
     *
     * @return edad en años
     */
    public int edad() {
        Calendar hoy = new GregorianCalendar();
        int anioHoy = hoy.get(Calendar.YEAR);
        int anioNac = this.getAnioNacimiento();
        int edad = anioHoy - anioNac;

        if (hoy.get(Calendar.MONTH) < this.getFechaNacimiento().get(Calendar.MONTH) ||
            (hoy.get(Calendar.MONTH) == this.getFechaNacimiento().get(Calendar.MONTH) &&
             hoy.get(Calendar.DAY_OF_MONTH) < this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }

        return edad;
    }

    /**
     * Retorna el nombre y apellido separados por espacio.
     * 
     * @return cadena con "Nombre Apellido"
     */
    public String nomYAp() {
        return this.getNombre() + " " + this.getApellido();
    }

    /**
     * Alias de nomYAp().
     * 
     * @return cadena con "Nombre Apellido"
     */
    public String nomYape() {
        return this.nomYAp();
    }

    /**
     * Retorna el apellido y nombre separados por coma.
     * 
     * @return cadena con "Apellido, Nombre"
     */
    public String apeYnom() {
        return this.getApellido() + ", " + this.getNombre();
    }

    /**
     * Comprueba si el día de hoy es el cumpleaños de la persona.
     *
     * @return true si hoy es el cumpleaños, false en caso contrario
     */
    public boolean esCumpleaños() {
        Calendar hoy = new GregorianCalendar();
        return (hoy.get(Calendar.MONTH) == this.getFechaNacimiento().get(Calendar.MONTH)) &&
               (hoy.get(Calendar.DAY_OF_MONTH) == this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH));
    }

    /**
     * Muestra por consola los datos principales de la persona.
     */
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.nomYAp());
        System.out.println("DNI: " + this.getDNI() + " Edad: " + this.edad() + " años");
    }
}
