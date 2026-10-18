import java.util.ArrayList;

public class Gerencia {
    private String nombre;
    private ArrayList<Alojamiento> alojamientosAlquilados;

    public Gerencia(String p_nombre) {
        this.nombre = p_nombre;
        this.alojamientosAlquilados = new ArrayList<>();
    }

    public boolean agregarAlojamiento(Alojamiento p_alojamiento) {
        return this.alojamientosAlquilados.add(p_alojamiento);
    }

    public boolean quitarAlojamiento(Alojamiento p_alojamiento) {
        return this.alojamientosAlquilados.remove(p_alojamiento);
    }

    public int contarAlojamiento(String tipoAlojamiento) {
        int contador = 0;
        for (Alojamiento a : this.alojamientosAlquilados) {
            contador += a.contar(tipoAlojamiento);
        }
        return contador;
    }

    public void liquidar() {
        for (Alojamiento a : this.alojamientosAlquilados) {
            a.liquidar();
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