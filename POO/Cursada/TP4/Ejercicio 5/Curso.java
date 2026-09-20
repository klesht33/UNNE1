import java.util.HashMap;

public class Curso {

    private String nombre;
    private HashMap<Integer, Alumno> alumnos;

    public Curso(String p_nombre) {
        this.setNombre(p_nombre);
        this.setAlumnos(new HashMap<Integer, Alumno>());
    }

    public Curso(String p_nombre, HashMap<Integer, Alumno> p_alumnos) {
        this.setNombre(p_nombre);
        this.setAlumnos(p_alumnos);
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setAlumnos(HashMap<Integer, Alumno> p_alumnos) {
        this.alumnos = p_alumnos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public HashMap<Integer, Alumno> getAlumnos() {
        return this.alumnos;
    }

    public void inscribirAlumno(Alumno p_alumno) {
        this.getAlumnos().put(p_alumno.getLu(), p_alumno);
    }

    public Alumno quitarAlumno(int p_lu) {
        return this.getAlumnos().remove(p_lu);
    }

    public int cantidadDeAlumnos() {
        return this.getAlumnos().size();
    }

    public boolean estaInscripto(int p_lu) {
        return this.getAlumnos().containsKey(p_lu);
    }

    public boolean estaInscripto(Alumno p_alumno) {
        return this.getAlumnos().containsValue(p_alumno);
    }

    public Alumno buscarAlumno(int p_lu) {
        return this.getAlumnos().get(p_lu);
    }

    public void imprimirPromedioDelAlumno(int p_lu) {
        System.out.println("Promedio: " + this.buscarAlumno(p_lu).promedio());
    }

    public void mostrarInscriptos() {
        for (Alumno unAlumno : this.getAlumnos().values()) {
            System.out.println(unAlumno.getLu() + " " + unAlumno.nomYAp());
        }
    }

}