import java.util.ArrayList;

public class Profesor extends Persona {
    private String titulo;
    private ArrayList<Cargo> cargos;

    // Constructor que inicializa la persona y la colección de cargos
    public Profesor(int p_dni, String p_nombre, String p_apellido, int p_anio, String p_titulo) {
        super(p_dni, p_nombre, p_apellido, p_anio);
        this.titulo = p_titulo;
        this.cargos = new ArrayList<>();
    }

    // Método agregado para cumplir la consigna de que no puede tener más de 3 cargos[cite: 3]
    public boolean agregarCargo(Cargo p_cargo) {
        if (this.cargos.size() < 3) {
            this.cargos.add(p_cargo);
            return true;
        }
        return false;
    }

    public double sueldoTotal() {
        double total = 0;
        for (Cargo cargo : this.cargos) {
            total += cargo.sueldoDelCargo();
        }
        return total;
    }

    public void listarCargos() {
        System.out.println("-***** Cargos Asignados *****-");
        for (Cargo cargo : this.cargos) {
            cargo.mostrarCargo();
        }
    }

    @Override
    public void mostrar() {
        super.mostrar(); // Imprime Nombre, Apellido, DNI y Edad
        System.out.println("Titulo: " + this.titulo);
        this.listarCargos();
        System.out.println("** Sueldo Total: " + this.sueldoTotal() + " **");
    }

    public String mostrarLinea() {
        return "DNI: " + this.getDni() + " Nombre: " + this.nomYAp() + " - Sueldo Total: " + this.sueldoTotal();
    }
}