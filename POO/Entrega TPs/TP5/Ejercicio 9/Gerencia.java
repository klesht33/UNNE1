import java.util.ArrayList;

public class Gerencia {
    private String nombre;
    private ArrayList<Alojamiento> alojamiento;

    public Gerencia(String p_nombre, Alojamiento p_alojamiento) {
        setNombre(p_nombre);
        setAlojamiento(new ArrayList<Alojamiento>());
    }

    private void setAlojamiento(ArrayList<Alojamiento> p_alojamiento) {
        this.alojamiento = p_alojamiento;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Alojamiento> getAlojamiento() {
        return alojamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean agregarAlojamiento(Alojamiento p_alojamiento) {
        return getAlojamiento().add(p_alojamiento);
    }

    public boolean quitarAlojamiento(Alojamiento p_alojamiento) {
        return getAlojamiento().remove(p_alojamiento);
    }

    public int contarAlojamiento(String tipoAlojamiento) {
        int contar = 0;

        for (Alojamiento unAlojamiento : this.getAlojamiento()) {
            contar += unAlojamiento.contar(tipoAlojamiento);
        }
        return contar;
    }

    public void liquidar() {
        for (Alojamiento uAlojamiento : this.getAlojamiento()) {
            uAlojamiento.liquidar();
            System.out.println();
        }
    }

    public void mostrarLiquidacion() {
        System.out.println("Gerencia " + this.nombre);
        System.out.println("Liquidación\n");
        this.liquidar();
        System.out.println("Alojamiento tipo Cabaña ----> " + this.contarAlojamiento("Cabaña"));
        System.out.println("Alojamiento tipo Hotel ----> " + this.contarAlojamiento("Hotel"));
    }
}
