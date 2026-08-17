/**
 * Representa un expediente y la información necesaria para su seguimiento.
 *
 * @version 1.0
 */
public class expedienteclass {
    /** Número identificador del expediente. */
    private int numero;
    /** Persona u organismo que inició el expediente. */
    private String iniciador;
    /** Fecha de inicio del expediente. */
    private int fechaInicio;
    /** Oficina responsable actual del expediente. */
    private String oficinaActual;
    /** Estado actual del expediente. */
    private String estado;

    /**
     * Crea un expediente con todos sus datos iniciales.
     *
     * @param p_numero número identificador del expediente
     * @param p_iniciador persona u organismo que inició el expediente
     * @param p_fechaInicio fecha de inicio del expediente
     * @param p_oficinaActual oficina responsable actual
     * @param p_estado estado inicial del expediente
     */
    public expedienteclass(int p_numero, String p_iniciador, int p_fechaInicio, String p_oficinaActual, String p_estado) {
        this.numero = p_numero;
        this.iniciador = p_iniciador;
        this.fechaInicio = p_fechaInicio;
        this.oficinaActual = p_oficinaActual;
        this.estado = p_estado;
    }

    /**
     * Actualiza el estado del expediente.
     *
     * @param nuevoEstado nuevo estado que se asignará al expediente
     */
    public void modificarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    /**
     * Muestra por consola los datos principales del expediente.
     */
    public void mostrarExpediente() {
        System.out.println("Número de expediente: " + numero);
        System.out.println("Iniciador: " + iniciador);
        System.out.println("Fecha de inicio: " + fechaInicio);
    }
        
}
