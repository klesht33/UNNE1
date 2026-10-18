/**
 * Representa a un alumno, heredando las características de Persona.
 */
public class Alumno extends Persona {

    private int lu;
    private double nota1;
    private double nota2;

    /**
     * Crea un alumno con sus datos personales, heredados de Persona, y sus dos notas.
     */
    public Alumno(int p_dni, String p_nombre, String p_apellido, int p_anio, int p_lu, double p_nota1, double p_nota2) {
        // Llamada al constructor de la superclase Persona
        super(p_dni, p_nombre, p_apellido, p_anio);
        this.setLu(p_lu);
        this.setNota1(p_nota1);
        this.setNota2(p_nota2);
    }

    private void setLu(int p_lu) {
        this.lu = p_lu;
    }

    public void setNota1(double p_nota1) {
        this.nota1 = p_nota1;
    }

    public void setNota2(double p_nota2) {
        this.nota2 = p_nota2;
    }

    public int getLu() {
        return lu;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    /**
     * Calcula el promedio aritmetico de las dos calificaciones[cite: 11].
     */
    public double promedio() {
        return (getNota1() + getNota2()) / 2.0;
    }

    /**
     * Determina si el alumno aprueba segun un promedio minimo de 7,0[cite: 11].
     */
    public boolean aprueba() {
        return promedio() >= 7.0;
    }

    /**
     * Devuelve la condicion academica del alumno como texto[cite: 11].
     */
    public String leyendaAprueba() {
        if (aprueba()) {
            return "APROBADO";
        } else {
            return "DESAPROBADO";
        }
    }

    /**
     * Redefine el método mostrar() para incluir los datos personales y los del alumno.
     */
    @Override
    public void mostrar() {
        // Llama al mostrar() de Persona para imprimir Nombre, Apellido, DNI y Edad[cite: 1, 12]
        super.mostrar(); 
        System.out.println("LU: " + getLu() + " Notas: " + getNota1() + " " + getNota2());
        System.out.println("Promedio: " + promedio());
        System.out.println(leyendaAprueba());
    }
}