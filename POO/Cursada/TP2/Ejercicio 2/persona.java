import java.util.Calendar;
import java.util.GregorianCalendar;

public class persona {


private int dni;
private String nombre;
private String apellido;
private int anioNacimiento;

public persona(int dni, String nombre, String apellido, int anioNacimiento) {
       setDni(dni);
       setNombre(nombre);
       setApellido(apellido);
       setAnioNacimiento(anioNacimiento);
}

private void setDNI(int dni) {
    this.dni = dni;
}

private void setNombre(String nombre) {
    this.nombre = nombre;
}

private void setApellido(String apellido) {
    this.apellido = apellido;
}

private void setAnioNacimiento(int anioNacimiento) {
    this.anioNacimiento = anioNacimiento;
}

public int getDNI() {
    return dni;
}

public String getNombre() {
    return nombre;
}

public String getApellido() {
    return apellido;
}

public int getAnioNacimiento() {
    return anioNacimiento;
}

public int edad() {
    Calendar fechaHoy = new GregorianCalendar();
    int anioHoy = fechaHoy.get(Calendar.YEAR);

    return anioHoy - anioNacimiento;
}

public String nomYApe() {
    return nombre + " " + apellido;
}

public void mostrar() {
    System.out.println("Nombre y Apellido: " + nomYApe());
    System.out.println("DNI: " + getDNI() + " Edad: " + edad() + " años: " + getAnioNacimiento());
}


}
