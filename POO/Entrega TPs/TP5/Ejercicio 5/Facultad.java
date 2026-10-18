import java.util.ArrayList;

public class Facultad {
    private String nombre;
    private ArrayList<Profesor> profesores;

    public Facultad(String p_nombre, ArrayList<Profesor> p_profesores) {
        setNombre(p_nombre);
        setProfesor(p_profesores);
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setProfesor(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public double totalAPagar() {
        double total = 0.0;

        for (Profesor unProfesor : this.getProfesores()) {
            total += unProfesor.sueldoTotal();
        }

        return total;
    }

    public void nominaProfesores() {

        System.out.println("*************** Nómina Facultad: " + this.getNombre());
        System.out.println("------------------------------------------------------------------");

        for (Profesor unProfesor : this.getProfesores()) {
            System.out.println(unProfesor.mostrarLInea());
        }
        System.out.println("------------------------------------------------------------------");

        System.out.println("Total a pagar: " + this.totalAPagar());
    }

    public void listarProfesorCargos() {

        System.out.println("***** Detalle de Profesores y cargos de Facultad: " + this.getNombre() + " *****");
        System.out.println("--------------------------------------------------------------------------------");

        for (Profesor unProfesor : this.getProfesores()) {
            unProfesor.mostrar();
            System.out.println("------------------ **** -------------------");
        }

        System.out.println("------------------------------------------------------------------");
        System.out.println("Hay " + this.getProfesores().size() + " profesores");
    }

}
