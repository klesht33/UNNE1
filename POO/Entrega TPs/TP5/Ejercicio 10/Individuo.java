import java.util.Calendar;
import java.util.HashSet;

/**
 * Representa a un visitante particular (persona individual).
 * 
 * @author Gabi
 * @version 1.0
 */
public class Individuo extends Visitante {

    private Persona persona;

    /**
     * Crea un visitante individual a partir de una Persona y la fecha de visita.
     * 
     * @param p_persona     persona que visita el zoológico
     * @param p_fechaVisita fecha en que realiza la visita
     */
    public Individuo(Persona p_persona, Calendar p_fechaVisita) {
        super(p_persona.nomYAp(), p_fechaVisita);
        this.setPersona(p_persona);
    }

    private void setPersona(Persona p_persona) {
        this.persona = p_persona;
    }

    public Persona getPersona() {
        return this.persona;
    }

    @Override
    public String tipoVisitante() {
        return "Individuo";
    }

    @Override
    public double entrada() {
        return 10.0;
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.getPersona().nomYAp());
        System.out.println("DNI: " + this.getPersona().getDNI() + "  Edad: " + this.getPersona().edad() + " años");
    }

    @Override
    public void listarPorFecha(Calendar p_fecha, String p_visitante) {
        if (this.esMismaFecha(this.getFechaVisita(), p_fecha) && this.tipoVisitante().equalsIgnoreCase(p_visitante)) {
            this.mostrar();
        }
    }

    @Override
    public HashSet<Persona> listarPersonas() {
        HashSet<Persona> personas = new HashSet<Persona>();
        personas.add(this.getPersona());
        return personas;
    }
}
