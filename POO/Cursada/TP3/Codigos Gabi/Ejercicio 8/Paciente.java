/**
 * Representa a un paciente de un centro médico con sus datos filiatorios y localidades de origen y residencia.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Paciente {
    /** Número de historia clínica del paciente. */
    private int historiaClinica;
    /** Nombre completo del paciente. */
    private String nombre;
    /** Domicilio particular del paciente. */
    private String domicilio;
    /** Localidad de nacimiento del paciente. */
    private Localidad localidadNacido;
    /** Localidad donde reside el paciente. */
    private Localidad localidadVive;

    /**
     * Constructor que inicializa los datos completos del paciente.
     * 
     * @param p_historiaClinica número de historia clínica
     * @param p_nombre nombre del paciente
     * @param p_domicilio domicilio del paciente
     * @param p_localidadNacido localidad de nacimiento
     * @param p_localidadVive localidad de residencia actual
     */
    public Paciente(int p_historiaClinica, String p_nombre, String p_domicilio, Localidad p_localidadNacido,
            Localidad p_localidadVive) {

        this.setHistoriaClinica(p_historiaClinica);
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setLocalidadNacido(p_localidadNacido);
        this.setLocalidadVive(p_localidadVive);
    }

    /**
     * Asigna el domicilio del paciente.
     * 
     * @param domicilio domicilio a asignar
     */
    private void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Asigna el número de historia clínica.
     * 
     * @param historiaClinica número de historia clínica a asignar
     */
    private void setHistoriaClinica(int historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    /**
     * Asigna la localidad de nacimiento.
     * 
     * @param localidadNacido localidad de nacimiento a asignar
     */
    private void setLocalidadNacido(Localidad localidadNacido) {
        this.localidadNacido = localidadNacido;
    }

    /**
     * Asigna la localidad de residencia.
     * 
     * @param localidadVive localidad de residencia a asignar
     */
    private void setLocalidadVive(Localidad localidadVive) {
        this.localidadVive = localidadVive;
    }

    /**
     * Asigna el nombre del paciente.
     * 
     * @param nombre nombre a asignar
     */
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el domicilio del paciente.
     * 
     * @return domicilio del paciente
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Obtiene el número de historia clínica.
     * 
     * @return número de historia clínica
     */
    public int getHistoriaClinica() {
        return historiaClinica;
    }

    /**
     * Obtiene la localidad de nacimiento.
     * 
     * @return localidad de nacimiento
     */
    public Localidad getLocalidadNacido() {
        return localidadNacido;
    }

    /**
     * Obtiene la localidad de residencia.
     * 
     * @return localidad de residencia
     */
    public Localidad getLocalidadVive() {
        return localidadVive;
    }

    /**
     * Obtiene el nombre del paciente.
     * 
     * @return nombre del paciente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Muestra por pantalla los datos filiatorios del paciente y su localidad de nacimiento.
     */
    public void mostrarDatosPantalla() {
        System.out.println("Paciente: " + getNombre() + " Historia Clinica: " + getHistoriaClinica() + " Domicilio: "
                + getDomicilio());
        if (getLocalidadNacido() != null) {
            getLocalidadNacido().mostrar();
        } else {
            System.out.println("Localidad de nacimiento: Sin asignar");
        }
    }

    /**
     * Retorna una cadena formateada con los datos del paciente y sus localidades asociadas.
     * 
     * @return cadena con el resumen de datos del paciente
     */
    public String cadenaDeDatos() {
        String vive = (getLocalidadVive() != null) ? getLocalidadVive().getNombreVive() : "Sin localidad de residencia";
        String nacido = (getLocalidadNacido() != null) ? getLocalidadNacido().getNombre() : "Sin localidad de nacimiento";
        return "" + getNombre() + "......... " + getHistoriaClinica() + "......... " + getDomicilio() + "- "
                + vive + " - " + nacido;
    }

}
