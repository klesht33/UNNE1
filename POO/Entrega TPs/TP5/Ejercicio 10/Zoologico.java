import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

/**
 * Representa a la institución Zoológico que gestiona los visitantes y las entradas.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Zoologico {

    private String nombre;
    private ArrayList<Visitante> visitantes;

    /**
     * Crea un zoológico con nombre e inicializa la colección de visitantes vacía.
     * 
     * @param p_nombre nombre del zoológico
     */
    public Zoologico(String p_nombre) {
        this.setNombre(p_nombre);
        this.setVisitantes(new ArrayList<Visitante>());
    }

    /**
     * Crea un zoológico con nombre y una colección inicial de visitantes.
     * 
     * @param p_nombre     nombre del zoológico
     * @param p_visitantes lista de visitantes inicial
     */
    public Zoologico(String p_nombre, ArrayList<Visitante> p_visitantes) {
        this.setNombre(p_nombre);
        this.setVisitantes(p_visitantes);
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setVisitantes(ArrayList<Visitante> p_visitantes) {
        this.visitantes = p_visitantes;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Visitante> getVisitantes() {
        return this.visitantes;
    }

    /**
     * Registra un nuevo visitante en el zoológico.
     * 
     * @param p_visitante visitante a registrar
     */
    public void nuevoVisitante(Visitante p_visitante) {
        this.getVisitantes().add(p_visitante);
    }

    /**
     * Quita un visitante registrado en el zoológico.
     * 
     * @param p_visitante visitante a dar de baja
     * @return true si se removió correctamente, false en caso contrario
     */
    public boolean quitarVisitante(Visitante p_visitante) {
        return this.getVisitantes().remove(p_visitante);
    }

    /**
     * Emite el listado de visitantes de un tipo específico que acudieron en una fecha determinada.
     * 
     * @param p_fecha         fecha a consultar
     * @param p_tipoVisitante tipo de visitante ("Individuo" o "Delegación")
     */
    public void listarTipoVisitantePorFecha(Calendar p_fecha, String p_tipoVisitante) {
        for (Visitante unVisitante : this.getVisitantes()) {
            unVisitante.listarPorFecha(p_fecha, p_tipoVisitante);
        }
    }

    /**
     * Emite el listado de todos los visitantes que asistieron un determinado día sin discriminar tipo.
     * 
     * @param p_fecha fecha a consultar
     */
    public void listarVisitantePorFecha(Calendar p_fecha) {
        for (Visitante unVisitante : this.getVisitantes()) {
            if (this.esMismaFecha(unVisitante.getFechaVisita(), p_fecha)) {
                unVisitante.mostrar();
            }
        }
    }

    /**
     * Calcula la recaudación total de entradas vendidas dentro de un rango de fechas (inclusive).
     * 
     * @param p_fechaDesde fecha de inicio del rango
     * @param p_fechaHasta fecha de fin del rango
     * @return recaudación total en pesos
     */
    public double recaudacion(Calendar p_fechaDesde, Calendar p_fechaHasta) {
        double total = 0.0;
        int desde = this.fechaComoEntero(p_fechaDesde);
        int hasta = this.fechaComoEntero(p_fechaHasta);

        for (Visitante unVisitante : this.getVisitantes()) {
            int fechaVisita = this.fechaComoEntero(unVisitante.getFechaVisita());
            if (fechaVisita >= desde && fechaVisita <= hasta) {
                total += unVisitante.entrada();
            }
        }
        return total;
    }

    /**
     * Retorna todas las personas distintas que visitaron el zoológico desde su apertura.
     * 
     * @return conjunto sin duplicados de objetos Persona
     */
    public HashSet<Persona> listarPersonasQueVisitaronElZoo() {
        HashSet<Persona> personasHistoricas = new HashSet<Persona>();
        for (Visitante unVisitante : this.getVisitantes()) {
            personasHistoricas.addAll(unVisitante.listarPersonas());
        }
        return personasHistoricas;
    }

    /**
     * Compara dos objetos Calendar evaluando si corresponden al mismo año y día del año.
     * 
     * @param p_fecha1 primer fecha
     * @param p_fecha2 segunda fecha
     * @return true si coinciden en el día, false en caso contrario
     */
    private boolean esMismaFecha(Calendar p_fecha1, Calendar p_fecha2) {
        return p_fecha1.get(Calendar.YEAR) == p_fecha2.get(Calendar.YEAR) &&
               p_fecha1.get(Calendar.DAY_OF_YEAR) == p_fecha2.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Convierte una fecha Calendar a un entero formato YYYYMMDD para comparaciones de rango exactas.
     * 
     * @param p_fecha fecha a convertir
     * @return representación numérica entera de la fecha
     */
    private int fechaComoEntero(Calendar p_fecha) {
        return p_fecha.get(Calendar.YEAR) * 10000 +
               (p_fecha.get(Calendar.MONTH) + 1) * 100 +
               p_fecha.get(Calendar.DAY_OF_MONTH);
    }
}
