import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Representa una Persona mediante sus datos Personales básicos.
 *
 * @version 1.0
 */
public class Persona {


/** Documento Nacional de Identidad de la Persona. */
private int dni;
/** Nombre de la Persona. */
private String nombre;
/** Apellido de la Persona. */
private String apellido;
/** Año de nacimiento de la Persona. */
private int anioNacimiento;

/**
 * Crea una Persona con sus datos Personales.
 *
 * @param dni Documento Nacional de Identidad de la Persona
 * @param nombre nombre de la Persona
 * @param apellido apellido de la Persona
 * @param anioNacimiento año de nacimiento de la Persona
 */
public Persona(int dni, String nombre, String apellido, int anioNacimiento) {
       setDNI(dni);
       setNombre(nombre);
       setApellido(apellido);
       setAnioNacimiento(anioNacimiento);
}

/**
 * Asigna el Documento Nacional de Identidad de la Persona.
 *
 * @param dni Documento Nacional de Identidad que se asignará
 */
private void setDNI(int dni) {
    this.dni = dni;
}

/**
 * Asigna el nombre de la Persona.
 *
 * @param nombre nombre que se asignará
 */
private void setNombre(String nombre) {
    this.nombre = nombre;
}

/**
 * Asigna el apellido de la Persona.
 *
 * @param apellido apellido que se asignará
 */
private void setApellido(String apellido) {
    this.apellido = apellido;
}

/**
 * Asigna el año de nacimiento de la Persona.
 *
 * @param anioNacimiento año de nacimiento que se asignará
 */
private void setAnioNacimiento(int anioNacimiento) {
    this.anioNacimiento = anioNacimiento;
}

/**
 * Obtiene el Documento Nacional de Identidad de la Persona.
 *
 * @return Documento Nacional de Identidad de la Persona
 */
public int getDNI() {
    return dni;
}

/**
 * Obtiene el nombre de la Persona.
 *
 * @return nombre de la Persona
 */
public String getNombre() {
    return nombre;
}

/**
 * Obtiene el apellido de la Persona.
 *
 * @return apellido de la Persona
 */
public String getApellido() {
    return apellido;
}

/**
 * Obtiene el año de nacimiento de la Persona.
 *
 * @return año de nacimiento de la Persona
 */
public int getAnioNacimiento() {
    return anioNacimiento;
}

/**
 * Calcula la edad aproximada de la Persona a partir del año actual.
 *
 * @return edad de la Persona en años
 */
public int edad() {
    Calendar fechaHoy = new GregorianCalendar();
    int anioHoy = fechaHoy.get(Calendar.YEAR);

    return anioHoy - anioNacimiento;
}

/**
 * Construye el nombre completo de la Persona.
 *
 * @return nombre y apellido separados por un espacio
 */
public String nomYAp() {
    return getNombre() + " " + getApellido();
}

/**
 * Muestra por consola los datos principales de la Persona.
 */
public void mostrar() {
    System.out.println("Nombre y Apellido: " + nomYAp());
    System.out.println("DNI: " + getDNI() + " Edad: " + edad() + " años: " + getAnioNacimiento());
}


}
