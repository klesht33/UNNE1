import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

/**
 * Representa a una delegación formada por un conjunto de individuos.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Delegacion extends Visitante {

    private ArrayList<Individuo> integrantes;

    /**
     * Crea una delegación con nombre y fecha de visita, inicializando la lista de integrantes vacía.
     * 
     * @param p_nombre      nombre que identifica a la delegación
     * @param p_fechaVisita fecha en que la delegación visita el zoológico
     */
    public Delegacion(String p_nombre, Calendar p_fechaVisita) {
        super(p_nombre, p_fechaVisita);
        this.setIntegrantes(new ArrayList<Individuo>());
    }

    /**
     * Crea una delegación con nombre, fecha de visita y una lista de integrantes inicial.
     * 
     * @param p_nombre      nombre que identifica a la delegación
     * @param p_fechaVisita fecha en que la delegación visita el zoológico
     * @param p_integrantes colección inicial de integrantes
     */
    public Delegacion(String p_nombre, Calendar p_fechaVisita, ArrayList<Individuo> p_integrantes) {
        super(p_nombre, p_fechaVisita);
        this.setIntegrantes(p_integrantes);
    }

    private void setIntegrantes(ArrayList<Individuo> p_integrantes) {
        this.integrantes = p_integrantes;
    }

    public ArrayList<Individuo> getIntegrantes() {
        return this.integrantes;
    }

    @Override
    public String tipoVisitante() {
        return "Delegación";
    }

    /**
     * Inscribe un nuevo individuo en la delegación, impidiendo duplicados.
     * 
     * @param p_individuo individuo a inscribir
     */
    public void inscribirIndividuo(Individuo p_individuo) {
        if (!this.getIntegrantes().contains(p_individuo)) {
            this.getIntegrantes().add(p_individuo);
        }
    }

    /**
     * Quita a un individuo integrante de la delegación.
     * 
     * @param p_individuo individuo a dar de baja
     * @return true si se removió con éxito, false en caso contrario
     */
    public boolean quitarIntegrante(Individuo p_individuo) {
        return this.getIntegrantes().remove(p_individuo);
    }

    /**
     * Retorna la cantidad total de integrantes que forman parte de la delegación.
     * 
     * @return cantidad de integrantes
     */
    public int cantidadIntegrantes() {
        return this.getIntegrantes().size();
    }

    @Override
    public double entrada() {
        double subtotal = 0.0;
        for (Individuo unIndividuo : this.getIntegrantes()) {
            subtotal += unIndividuo.entrada();
        }
        return subtotal * 0.90; // Aplica 10% de descuento
    }

    @Override
    public void mostrar() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Delegación: " + this.getNombre());
        System.out.println("Integrantes");
        for (Individuo unIndividuo : this.getIntegrantes()) {
            unIndividuo.mostrar();
        }
        System.out.println("Cantidad de Integrantes: " + this.cantidadIntegrantes());
        System.out.println("------------------------------------------------------------------");
    }

    @Override
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
        if (this.esMismaFecha(this.getFechaVisita(), p_fecha) &&
            (this.tipoVisitante().equalsIgnoreCase(p_visitante) ||
             (p_visitante.equalsIgnoreCase("Delegacion") && this.tipoVisitante().equalsIgnoreCase("Delegación")))) {
            this.mostrar();
        }
    }

    @Override
    public HashSet<Persona> listarPersonas() {
        HashSet<Persona> personas = new HashSet<Persona>();
        for (Individuo unIndividuo : this.getIntegrantes()) {
            personas.addAll(unIndividuo.listarPersonas());
        }
        return personas;
    }
}
