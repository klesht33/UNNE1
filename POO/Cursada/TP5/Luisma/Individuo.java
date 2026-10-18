import java.util.Calendar;
import java.util.HashSet;

public class Individuo extends Visitante {
    private Persona persona;

    public Individuo(Persona p_persona, Calendar p_fechaVisita) {
        super(p_persona.getNombre() + " " + p_persona.getApellido(), p_fechaVisita);
        this.persona = p_persona;
    }

    public Persona getPersona() { return this.persona; }

    @Override
    public String tipoVisitante() {
        return "Individuo";
    }

    @Override
    public double entrada() {
        return 10.0; // Costo por individuo según enunciado
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + this.persona.getNombre() + " " + this.persona.getApellido());
        System.out.println("DNI: " + this.persona.getDni() + " Edad: " + this.persona.edad() + " años");
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
        hashPersonas.add(this.persona);
        return hashPersonas;
    }
}