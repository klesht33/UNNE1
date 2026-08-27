public class Localidad {

    private String nombre;
    private String provincia;
    private String nombreVive;

    public Localidad(String p_nombre, String p_provincia, String p_nombreVive) {
        this.setNombre(p_nombre);
        this.setNombreVive(p_nombreVive);
        this.setProvincia(p_provincia);
    }

    public void setNombreVive(String p_nombreVive) {
        this.nombreVive = p_nombreVive;
    }

    public String getNombreVive() {
        return nombreVive;
    }

    public void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    public void setProvincia(String p_provincia) {
        this.provincia = p_provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void mostrar() {
        System.out.println("Localidad: " + getNombre() + " Provincia: " + getProvincia());
    }
}
