import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

public class Delegacion extends Visitante {
    private ArrayList<Individuo> integrantes;

    public Delegacion(String p_nombre, Calendar p_fechaVisita) {
        super(p_nombre, p_fechaVisita);
        this.integrantes = new ArrayList<>();
    }

    @Override
    public String tipoVisitante() {
        return "Delegación";
    }

    public void inscribirIndividuo(Individuo p_individuo) {
        // Evita inscripciones duplicadas
        if (!this.integrantes.contains(p_individuo)) {
            this.integrantes.add(p_individuo);
        }
    }

    public boolean quitarIntegrante(Individuo p_individuo) {
        return this.integrantes.remove(p_individuo);
    }

    public int cantidadIntegrantes() {
        return this.integrantes.size();
    }

    @Override
    public double entrada() {
        double subtotal = 0.0;
        for (Individuo i : this.integrantes) {
            subtotal += i.entrada();
        }
        return subtotal - (subtotal * 0.10); // Descuento del 10%[cite: 9]
    }

    @Override
    public void mostrar() {
        System.out.println("Delegación: " + this.getNombre());
        System.out.println("Integrantes");
        for (Individuo i : this.integrantes) {
            i.mostrar();
        }
        System.out.println("Cantidad de Integrantes: " + this.cantidadIntegrantes());
    }

    @Override
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
        if (esMismaFecha(this.getFechaVisita(), p_fecha) && this.tipoVisitante().equalsIgnoreCase(p_visitante)) {
            this.mostrar();
            System.out.println("-------------------------");
        }
    }

    @Override
    public HashSet<Persona> listarPersonas() {
        HashSet<Persona> hashPersonas = new HashSet<>();
        for (Individuo i : this.integrantes) {
            hashPersonas.addAll(i.listarPersonas()); // Colecciona sin duplicados gracias a HashSet[cite: 9]
        }
        return hashPersonas;
    }
}