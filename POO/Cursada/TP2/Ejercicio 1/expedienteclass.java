public class expedienteclass {
    private int numero;
    private String iniciador;
    private int fechaInicio;
    private String oficinaActual;
    private String estado;

    public expedienteclass(int p_numero, String p_iniciador, int p_fechaInicio, String p_oficinaActual, String p_estado) {
        this.numero = p_numero;
        this.iniciador = p_iniciador;
        this.fechaInicio = p_fechaInicio;
        this.oficinaActual = p_oficinaActual;
        this.estado = p_estado;
    }

    public void modificarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void mostrarExpediente() {
        System.out.println("Número de expediente: " + numero);
        System.out.println("Iniciador: " + iniciador);
        System.out.println("Fecha de inicio: " + fechaInicio);
    }
        
}
