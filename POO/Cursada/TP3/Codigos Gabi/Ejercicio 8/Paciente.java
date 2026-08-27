
public class Paciente {
    private int historiaClinica;
    private String nombre;
    private String domicilio;
    private Localidad localidadNacido;
    private Localidad localidadVive;

    public Paciente(int p_historiaClinica, String p_nombre, String p_domicilio, Localidad p_localidadNacido,
            Localidad p_localidadVive) {

        this.setHistoriaClinica(p_historiaClinica);
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setLocalidadNacido(p_localidadNacido);
        this.setLocalidadVive(p_localidadVive);
    }

    private void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    private void setHistoriaClinica(int historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    private void setLocalidadNacido(Localidad localidadNacido) {
        this.localidadNacido = localidadNacido;
    }

    private void setLocalidadVive(Localidad localidadVive) {
        this.localidadVive = localidadVive;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getHistoriaClinica() {
        return historiaClinica;
    }

    public Localidad getLocalidadNacido() {
        return localidadNacido;
    }

    public Localidad getLocalidadVive() {
        return localidadVive;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarDatosPantalla() {

        System.out.println("Paciente: " + getNombre() + " Historia Clinica: " + getHistoriaClinica() + " Domicilio: "
                + getDomicilio());
        getLocalidadNacido().mostrar();
    }

    public String cadenaDeDatos() {
        return "" + getNombre() + "......... " + getHistoriaClinica() + "......... " + getDomicilio() + "- "
                + getLocalidadVive().getNombreVive() + " - " + getLocalidadNacido().getNombre();
    }

}
