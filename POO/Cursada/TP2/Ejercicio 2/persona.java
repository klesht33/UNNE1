import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Representa una persona mediante sus datos personales básicos.
 *
 * @version 1.0
 */
public class persona {


/** Documento Nacional de Identidad de la persona. */
private int dni;
/** Nombre de la persona. */
private String nombre;
/** Apellido de la persona. */
private String apellido;
/** Año de nacimiento de la persona. */
private int anioNacimiento;

/**
 * Crea una persona con sus datos personales.
 *
 * @param dni Documento Nacional de Identidad de la persona
 * @param nombre nombre de la persona
 * @param apellido apellido de la persona
 * @param anioNacimiento año de nacimiento de la persona
 */
public persona(int dni, String nombre, String apellido, int anioNacimiento) {
       setDNI(dni);
       setNombre(nombre);
       setApellido(apellido);
       setAnioNacimiento(anioNacimiento);
}

/**
 * Asigna el Documento Nacional de Identidad de la persona.
 *
 * @param dni Documento Nacional de Identidad que se asignará
 */
private void setDNI(int dni) {
    this.dni = dni;
}

/**
 * Asigna el nombre de la persona.
 *
 * @param nombre nombre que se asignará
 */
private void setNombre(String nombre) {
    this.nombre = nombre;
}

/**
 * Asigna el apellido de la persona.
 *
 * @param apellido apellido que se asignará
 */
private void setApellido(String apellido) {
    this.apellido = apellido;
}

/**
 * Asigna el año de nacimiento de la persona.
 *
 * @param anioNacimiento año de nacimiento que se asignará
 */
private void setAnioNacimiento(int anioNacimiento) {
    this.anioNacimiento = anioNacimiento;
}

/**
 * Obtiene el Documento Nacional de Identidad de la persona.
 *
 * @return Documento Nacional de Identidad de la persona
 */
public int getDNI() {
    return dni;
}

/**
 * Obtiene el nombre de la persona.
 *
 * @return nombre de la persona
 */
public String getNombre() {
    return nombre;
}

/**
 * Obtiene el apellido de la persona.
 *
 * @return apellido de la persona
 */
public String getApellido() {
    return apellido;
}

/**
 * Obtiene el año de nacimiento de la persona.
 *
 * @return año de nacimiento de la persona
 */
public int getAnioNacimiento() {
    return anioNacimiento;
}

/**
 * Calcula la edad aproximada de la persona a partir del año actual.
 *
 * @return edad de la persona en años
 */
public int edad() {
    Calendar fechaHoy = new GregorianCalendar();
    int anioHoy = fechaHoy.get(Calendar.YEAR);

    return anioHoy - anioNacimiento;
}

/**
 * Construye el nombre completo de la persona.
 *
 * @return nombre y apellido separados por un espacio
 */
public String nomYAp() {
    return getNombre() + " " + getApellido();
}

/**
 * Muestra por consola los datos principales de la persona.
 */
public void mostrar() {
    System.out.println("Nombre y Apellido: " + nomYAp());
    System.out.println("DNI: " + getDNI() + " Edad: " + edad() + " años: " + getAnioNacimiento());
}


}
