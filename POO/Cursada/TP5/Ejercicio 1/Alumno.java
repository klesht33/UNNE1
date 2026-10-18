
/**
 * Representa a un alumno con su libreta universitaria, nombre, apellido y dos
 * calificaciones.
 */
public class Alumno extends Persona {

    private int lu;
    private double nota1;
    private double nota2;

    /**
     * Crea un alumno con sus datos personales y sus dos notas.
     *
     * @param lu       libreta universitaria del alumno.
     * @param nombre   nombre del alumno.
     * @param apellido apellido del alumno.
     * @param nota1    primera calificacion del alumno.
     * @param nota2    segunda calificacion del alumno.
     */
    public Alumno(int p_dni, int p_anioNacimiento, int p_lu, String p_nombre, String p_apellido, double p_nota1,
            double p_nota2) {
        super(p_dni, p_nombre, p_apellido, p_anioNacimiento);
        setNota1(p_nota1);
        setNota2(p_nota2);
    }

    /**
     * Actualiza la primera calificacion del alumno.
     *
     * @param nota1 nueva primera calificacion.
     */
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    /**
     * Actualiza la segunda calificacion del alumno.
     *
     * @param nota2 nueva segunda calificacion.
     */
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    /**
     * Obtiene la libreta universitaria del alumno.
     *
     * @return libreta universitaria.
     */
    public int getLu() {
        return lu;
    }

    /**
     * Obtiene la primera calificacion del alumno.
     *
     * @return primera calificacion.
     */
    public double getNota1() {
        return nota1;
    }

    /**
     * Obtiene la segunda calificacion del alumno.
     *
     * @return segunda calificacion.
     */
    public double getNota2() {
        return nota2;
    }

    /**
     * Calcula el promedio aritmetico de las dos calificaciones.
     *
     * @return promedio de {@code nota1} y {@code nota2}.
     */
    public double promedio() {
        double promedio = (getNota1() + getNota2()) / 2;
        return promedio;
    }

    /**
     * Determina si el alumno aprueba segun un promedio minimo de 7,0.
     *
     * @return {@code true} si el promedio es mayor o igual que 7,0;
     *         {@code false} en caso contrario.
     */
    public boolean aprueba() {

        return promedio() >= 7.0;
    }

    /**
     * Devuelve la condicion academica del alumno como texto.
     *
     * @return {@code "APROBADO"} si aprueba o {@code "DESAPROBADO"} en caso
     *         contrario.
     */
    public String leyendaAprueba() {

        if (aprueba()) {
            return "APROBADO";
        } else {
            return "DESAPROBADO";
        }

    }

    /**
     * Muestra por consola los datos, las notas, el promedio y la condicion
     * academica del alumno.
     */
    public void mostrar() {
        super.mostrar();
        System.out.println("LU: " + getLu() + " Notas: " + getNota1() + " - " + getNota2());
        System.out.println("Promedio: " + promedio() + " - " + leyendaAprueba());
    }

}
