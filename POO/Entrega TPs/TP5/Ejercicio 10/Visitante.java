import java.util.Calendar;
import java.util.HashSet;

/**
 * Clase abstracta que representa a un visitante del zoológico.
 * 
 * @author Gabi
 * @version 1.0
 */
public abstract class Visitante {

    private String nombre;
    private Calendar fechaVisita;

    /**
     * Constructor para inicializar los datos comunes a todo visitante.
     * 
     * @param p_nombre      nombre identificador del visitante o delegación
     * @param p_fechaVisita fecha en la que se realiza la visita
     */
    public Visitante(String p_nombre, Calendar p_fechaVisita) {
        this.setNombre(p_nombre);
        this.setFechaVisita(p_fechaVisita);
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setFechaVisita(Calendar p_fechaVisita) {
        this.fechaVisita = p_fechaVisita;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Calendar getFechaVisita() {
        return this.fechaVisita;
    }

    /**
     * Muestra los datos del visitante según el formato correspondiente.
     */
    public abstract void mostrar();

    /**
     * Calcula y retorna el costo de la entrada.
     * 
     * @return costo de la entrada en pesos
     */
    public abstract double entrada();

    /**
     * Emite el listado de los datos si coincide con la fecha y tipo de visitante solicitados.
     * 
     * @param p_fecha     fecha a consultar
     * @param p_visitante tipo de visitante ("Individuo" o "Delegación")
     */
    public abstract void listarPorFecha(Calendar p_fecha, String p_visitante);

    /**
     * Retorna el tipo de visitante ("Individuo" o "Delegación").
     * 
     * @return tipo de visitante
     */
    public abstract String tipoVisitante();

    /**
     * Retorna el conjunto de personas que componen el visitante.
     * 
     * @return colección sin duplicados de objetos Persona
     */
    public abstract HashSet<Persona> listarPersonas();

    /**
     * Compara dos objetos Calendar para determinar si corresponden al mismo día, mes y año.
     * 
     * @param p_fecha1 primer fecha a comparar
     * @param p_fecha2 segunda fecha a comparar
     * @return true si corresponden al mismo día, false en caso contrario
     */
    protected boolean esMismaFecha(Calendar p_fecha1, Calendar p_fecha2) {
        return p_fecha1.get(Calendar.YEAR) == p_fecha2.get(Calendar.YEAR) &&
               p_fecha1.get(Calendar.DAY_OF_YEAR) == p_fecha2.get(Calendar.DAY_OF_YEAR);
    }
}
