import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

public class Zoologico {
    private String nombre;
    private ArrayList<Visitante> visitantes;

    public Zoologico(String p_nombre) {
        this.nombre = p_nombre;
        this.visitantes = new ArrayList<>();
    }

    public void nuevoVisitante(Visitante p_visitante) {
        this.visitantes.add(p_visitante);
    }

    public boolean quitarVisitante(Visitante p_visitante) {
        return this.visitantes.remove(p_visitante);
    }

    public void listarTipoVisitantePorFecha(Calendar p_fecha, String p_tipoVisitante) {
        System.out.println("Listado de " + p_tipoVisitante + " para la fecha seleccionada:");
        for (Visitante v : this.visitantes) {
            v.listarPorFecha(p_fecha, p_tipoVisitante);
        }
    }

    public void listarVisitantePorFecha(Calendar p_fecha) {
        System.out.println("Listado de todos los visitantes para la fecha seleccionada:");
        for (Visitante v : this.visitantes) {
            if (v.getFechaVisita().get(Calendar.YEAR) == p_fecha.get(Calendar.YEAR) &&
                v.getFechaVisita().get(Calendar.DAY_OF_YEAR) == p_fecha.get(Calendar.DAY_OF_YEAR)) {
                v.mostrar();
                System.out.println("-------------------------");
            }
        }
    }

    public double recaudacion(Calendar p_fechaDesde, Calendar p_fechaHasta) {
        double total = 0.0;
        for (Visitante v : this.visitantes) {
            Calendar f = v.getFechaVisita();
            if (!f.before(p_fechaDesde) && !f.after(p_fechaHasta)) {
                total += v.entrada();
            }
        }
        return total;
    }

    public HashSet<Persona> listarPersonasQueVisitaronElZoo() {
        HashSet<Persona> personasHistoricas = new HashSet<>();
        for (Visitante v : this.visitantes) {
            personasHistoricas.addAll(v.listarPersonas());
        }
        return personasHistoricas;
    }
}