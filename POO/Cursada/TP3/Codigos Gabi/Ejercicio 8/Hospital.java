public class Hospital {

    private String nombreHospital;
    private String nombreDirector;

    public Hospital(String p_nombreHospital, String p_nombreDirector) {
        this.setNombreHospital(p_nombreHospital);
        this.setNombreDirector(p_nombreDirector);
    }

    private void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    private void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void consultaDatosFilatorios(Paciente p_paciente) {
        System.out.println("Hospital: " + getNombreHospital() + " Director: " + getNombreDirector());
        p_paciente.mostrarDatosPantalla();
    }
}
