import java.util.Calendar;
import java.util.HashSet;

public abstract class Visitante {
    private String nombre;
    private Calendar fechaVisita;

    public Visitante(String p_nombre, Calendar p_fechaVisita) {
        this.nombre = p_nombre;
        this.fechaVisita = p_fechaVisita;
    }

    public String getNombre() { return this.nombre; }
    public Calendar getFechaVisita() { return this.fechaVisita; }

    public abstract void mostrar();
    public abstract double entrada();
    public abstract void listarPorFecha(Calendar p_fecha, String p_visitante);
    public abstract String tipoVisitante();
    public abstract HashSet<Persona> listarPersonas();
    
    // Método auxiliar para comparar fechas sin tener en cuenta la hora
    protected boolean esMismaFecha(Calendar c1, Calendar c2) {
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) &&
               c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR);
    }
}