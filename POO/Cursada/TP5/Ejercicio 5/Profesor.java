import java.util.ArrayList;

public class Profesor extends Persona {
    private String titulo;
    private ArrayList<Cargo> cargos;

    public Profesor(String p_titulo, int p_dni, String p_nombre, String p_apellido, int p_anioNacimiento,
            ArrayList<Cargo> p_cargos) {

        super(p_dni, p_nombre, p_apellido, p_anioNacimiento);
        setTitulo(p_titulo);
        setCargos(p_cargos);
    }

    private void setTitulo(String p_titulo) {
        this.titulo = p_titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    private void setCargos(ArrayList<Cargo> p_cargos) {
        if (p_cargos.size() >= 1 && p_cargos.size() <= 3) {
            this.cargos = p_cargos;
        } else {
            System.out.println("Error: Un profesor debe tener entre 1 y 3 cargos.");
        }

    }

    public ArrayList<Cargo> getCargo() {
        return this.cargos;
    }

    public double sueldoTotal() {

        double sueldo = 0.0;

        for (Cargo unCargo : this.getCargo()) {
            sueldo += unCargo.sueldoDelCargo();
        }

        return sueldo;
    }

    public void listarCargos() {

        System.out.println("-***** Cargos Asignados *****-");
        System.out.println("---------------------------------------");

        for (Cargo unCargo : this.getCargo()) {
            unCargo.mostrarCargo();
        }

    }

    public void mostrar() {

        super.mostrar();
        System.out.println("Titulo: " + getTitulo());
        this.listarCargos();
        System.out.println("** Sueldo Total: " + this.sueldoTotal() + " **");
    }

    public String mostrarLInea() {
        return "DNI: " + super.getDNI() + " - Nombre: " + super.getNombre() + super.getApellido() + "Sueldo Total: "
                + sueldoTotal();
    }

}
