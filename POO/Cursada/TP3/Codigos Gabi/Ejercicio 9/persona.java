import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Representa una persona mediante sus datos personales y fecha de nacimiento.
 *
 * @version 2.0
 */
public class persona {

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
     * @param p_dni            Documento Nacional de Identidad
     * @param p_nombre         Nombre de la persona
     * @param p_apellido       Apellido de la persona
     * @param p_anio           Año de nacimiento
     */
    public persona(int p_dni, String p_nombre, String p_apellido, int p_anio) {
        this.setDni(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnioNacimiento(p_anio);
    }

    /**
     * Constructor que crea una persona recibiendo la fecha de nacimiento completa.
     *
     * @param p_dni            Documento Nacional de Identidad
     * @param p_nombre         Nombre de la persona
     * @param p_apellido       Apellido de la persona
     * @param p_fecha          Fecha de nacimiento como Calendar
     */
    public persona(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha) {
        this.setDni(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setFechaNacimiento(p_fecha);
    }

    /**
     * Asigna el DNI de la persona.
     *
     * @param p_dni DNI a asignar
     */
    private void setDni(int p_dni) {
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
     * Asigna la fecha de nacimiento a partir de un año (mantiene protocolo).
     *
     * @param p_anio año de nacimiento
     */
    private void setAnioNacimiento(int p_anio) {
        this.fechaNacimiento = new GregorianCalendar(p_anio, Calendar.JANUARY, 1);
    }

    /**
     * Asigna la fecha de nacimiento de la persona.
     *
     * @param p_fecha fecha de nacimiento como Calendar
     */
    private void setFechaNacimiento(Calendar p_fecha) {
        this.fechaNacimiento = p_fecha;
    }

    /**
     * Obtiene el DNI de la persona.
     *
     * @return DNI de la persona
     */
    public int getDni() {
        return this.dni;
    }

    /**
     * Obtiene el DNI de la persona (alias para compatibilidad).
     *
     * @return DNI de la persona
     */
    public int getDNI() {
        return this.getDni();
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
     * Obtiene el año de nacimiento a partir de la fecha de nacimiento (mantiene protocolo).
     *
     * @return año de nacimiento
     */
    public int getAnioNacimiento() {
        return this.getFechaNacimiento().get(Calendar.YEAR);
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return fecha de nacimiento como Calendar
     */
    public Calendar getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    /**
     * Calcula la edad exacta de la persona a partir de la fecha actual.
     *
     * @return edad en años
     */
    public int edad() {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        int edad = anioHoy - this.getAnioNacimiento();

        if (fechaHoy.get(Calendar.MONTH) < this.getFechaNacimiento().get(Calendar.MONTH) ||
            (fechaHoy.get(Calendar.MONTH) == this.getFechaNacimiento().get(Calendar.MONTH) &&
             fechaHoy.get(Calendar.DAY_OF_MONTH) < this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }

        return edad;
    }

    /**
     * Retorna el nombre y apellido separados por un espacio.
     *
     * @return nombre y apellido
     */
    public String nomYape() {
        return this.getNombre() + " " + this.getApellido();
    }

    /**
     * Retorna el nombre y apellido (alias por compatibilidad).
     *
     * @return nombre y apellido
     */
    public String nomYAp() {
        return this.nomYape();
    }

    /**
     * Retorna el apellido y nombre separados por coma y espacio.
     *
     * @return apellido y nombre
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
        System.out.println("Nombre y Apellido: " + this.nomYape());
        System.out.println("DNI: " + this.getDni() + " Edad: " + this.edad() + " años");
    }

}
