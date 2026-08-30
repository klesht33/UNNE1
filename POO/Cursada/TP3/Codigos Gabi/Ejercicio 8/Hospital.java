/**
 * Representa una institución hospitalaria con su nombre y su director a cargo.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Hospital {

    /** Nombre del hospital. */
    private String nombreHospital;
    /** Nombre del director del hospital. */
    private String nombreDirector;

    /**
     * Constructor que inicializa el hospital con su nombre y el nombre del director.
     * 
     * @param p_nombreHospital nombre del hospital
     * @param p_nombreDirector nombre del director
     */
    public Hospital(String p_nombreHospital, String p_nombreDirector) {
        this.setNombreHospital(p_nombreHospital);
        this.setNombreDirector(p_nombreDirector);
    }

    /**
     * Asigna el nombre del director.
     * 
     * @param nombreDirector nombre del director a asignar
     */
    private void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    /**
     * Asigna el nombre del hospital.
     * 
     * @param nombreHospital nombre del hospital a asignar
     */
    private void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    /**
     * Obtiene el nombre del director del hospital.
     * 
     * @return nombre del director
     */
    public String getNombreDirector() {
        return nombreDirector;
    }

    /**
     * Obtiene el nombre del hospital.
     * 
     * @return nombre del hospital
     */
    public String getNombreHospital() {
        return nombreHospital;
    }

    /**
     * Consulta y muestra los datos filiatorios y de residencia de un paciente.
     * 
     * @param p_paciente paciente cuyos datos se consultan
     */
    public void consultaDatosFilatorios(Paciente p_paciente) {
        System.out.println("Hospital: " + getNombreHospital() + " Director: " + getNombreDirector());
        p_paciente.mostrarDatosPantalla();
    }
}
