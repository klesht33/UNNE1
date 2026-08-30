/**
 * Representa una localidad geográfica con su nombre y provincia.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Localidad {

    /** Nombre de la localidad. */
    private String nombre;
    /** Nombre de la provincia. */
    private String provincia;
    /** Nombre de referencia del lugar de residencia. */
    private String nombreVive;

    /**
     * Constructor que inicializa los atributos de la localidad.
     * 
     * @param p_nombre nombre de la localidad
     * @param p_provincia provincia a la que pertenece
     * @param p_nombreVive nombre descriptivo de residencia
     */
    public Localidad(String p_nombre, String p_provincia, String p_nombreVive) {
        this.setNombre(p_nombre);
        this.setNombreVive(p_nombreVive);
        this.setProvincia(p_provincia);
    }

    /**
     * Asigna el nombre descriptivo de residencia.
     * 
     * @param p_nombreVive nombre descriptivo a asignar
     */
    public void setNombreVive(String p_nombreVive) {
        this.nombreVive = p_nombreVive;
    }

    /**
     * Obtiene el nombre descriptivo de residencia.
     * 
     * @return nombre descriptivo
     */
    public String getNombreVive() {
        return nombreVive;
    }

    /**
     * Asigna el nombre de la localidad.
     * 
     * @param p_nombre nombre de localidad a asignar
     */
    public void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /**
     * Asigna la provincia de la localidad.
     * 
     * @param p_provincia provincia a asignar
     */
    public void setProvincia(String p_provincia) {
        this.provincia = p_provincia;
    }

    /**
     * Obtiene el nombre de la localidad.
     * 
     * @return nombre de la localidad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la provincia de la localidad.
     * 
     * @return provincia de la localidad
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Muestra por consola la localidad y provincia.
     */
    public void mostrar() {
        System.out.println("Localidad: " + getNombre() + " Provincia: " + getProvincia());
    }
}
