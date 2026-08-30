/**
 * Representa a un docente con su información de cargo, sueldo básico y asignación familiar.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Docente {
    /** Nombre del docente. */
    private String nombre;
    /** Grado o curso asignado al docente. */
    private String grado;
    /** Sueldo básico percibido por el docente. */
    private double sueldoBasico;
    /** Monto correspondiente a asignación familiar. */
    private double asignacionFamiliar;

    /**
     * Constructor que inicializa un docente con todos sus atributos.
     * 
     * @param p_nombre nombre del docente
     * @param p_grado grado que enseña
     * @param p_sueldoBasico sueldo básico
     * @param p_asignacionFamiliar asignación familiar
     */
    public Docente(String p_nombre, String p_grado, double p_sueldoBasico, double p_asignacionFamiliar){
        setNombre(p_nombre);
        setGrado(p_grado);
        setSueldoBasico(p_sueldoBasico);
        setAsignacionFamiliar(p_asignacionFamiliar);
    }

    /**
     * Asigna el nombre del docente.
     * 
     * @param nombre nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Asigna el monto de asignación familiar.
     * 
     * @param asignacionFamiliar monto de asignación a asignar
     */
    public void setAsignacionFamiliar(double asignacionFamiliar) {
        this.asignacionFamiliar = asignacionFamiliar;
    }

    /**
     * Asigna el grado o curso del docente.
     * 
     * @param grado grado a asignar
     */
    public void setGrado(String grado) {
        this.grado = grado;
    }

    /**
     * Asigna el sueldo básico del docente.
     * 
     * @param p_sueldoBasico sueldo básico a asignar
     */
    public void setSueldoBasico(double p_sueldoBasico) {
        this.sueldoBasico = p_sueldoBasico;
    }

    /**
     * Obtiene la asignación familiar del docente.
     * 
     * @return asignación familiar
     */
    public double getAsignacionFamiliar() {
        return this.asignacionFamiliar;
    }

    /**
     * Obtiene el grado del docente.
     * 
     * @return grado o curso
     */
    public String getGrado() {
        return this.grado;
    }

    /**
     * Obtiene el nombre del docente.
     * 
     * @return nombre del docente
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene el sueldo básico del docente.
     * 
     * @return sueldo básico
     */
    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    /**
     * Calcula el sueldo total sumando el sueldo básico y la asignación familiar.
     * 
     * @return sueldo total calculado
     */
    public double calcularSueldo(){
        return getAsignacionFamiliar() + getSueldoBasico();
    }    
}
