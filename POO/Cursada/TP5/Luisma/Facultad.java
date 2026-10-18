import java.util.ArrayList;

public class Facultad {
    private String nombre;
    private ArrayList<Profesor> profesores;

    public Facultad(String p_nombre) {
        this.nombre = p_nombre;
        this.profesores = new ArrayList<>();
    }

    public void agregarProfesor(Profesor p_profesor) {
        this.profesores.add(p_profesor);
    }

    public double totalAPagar() {
        double total = 0;
        for (Profesor prof : this.profesores) {
            total += prof.sueldoTotal();
        }
        return total;
    }

    public void nominaProfesores() {
        System.out.println("*************** Nómina Facultad: " + this.nombre);
        for (Profesor prof : this.profesores) {
            System.out.println(prof.mostrarLinea());
        }
        System.out.println("Total a pagar: $" + this.totalAPagar());
    }

    public void listarProfesorCargos() {
        System.out.println("***** Detalle de Profesores y cargos de Facultad: " + this.nombre + " *****");
        for (Profesor prof : this.profesores) {
            prof.mostrar();
            System.out.println("****");
        }
        System.out.println("Hay " + this.profesores.size() + " profesores");
    }
}