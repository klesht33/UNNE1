/**
 * Representa a una mujer con sus datos personales, estado civil y relación de matrimonio con un Hombre.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Mujer {

    /** Nombre de la mujer. */
    private String nombre;
    /** Apellido de la mujer. */
    private String apellido;
    /** Edad en años de la mujer. */
    private int edad;
    /** Estado civil actual (Soltera, Casada, Divorciada). */
    private String estadoCivil;
    /** Esposo actual si está casada, o null si no lo está. */
    private Hombre esposo;

    /**
     * Constructor que inicializa a la mujer como soltera.
     * 
     * @param p_nombre nombre de la mujer
     * @param p_apellido apellido de la mujer
     * @param p_edad edad de la mujer
     */
    public Mujer(String p_nombre, String p_apellido, int p_edad) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltera");
    }

    /**
     * Constructor que inicializa a la mujer casada con un esposo.
     * 
     * @param p_nombre nombre de la mujer
     * @param p_apellido apellido de la mujer
     * @param p_edad edad de la mujer
     * @param p_esposo objeto Hombre que es su esposo
     */
    public Mujer(String p_nombre, String p_apellido, int p_edad, Hombre p_esposo) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Casada");
        this.setEsposo(p_esposo);
    }

    /**
     * Asigna el apellido de la mujer.
     * 
     * @param p_apellido apellido a asignar
     */
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }
    
    /**
     * Asigna la edad de la mujer.
     * 
     * @param p_edad edad a asignar
     */
    private void setEdad(int p_edad) {
        this.edad = p_edad;
    }

    /**
     * Asigna el estado civil de la mujer.
     * 
     * @param p_estadoCivil estado civil a asignar
     */
    private void setEstadoCivil(String p_estadoCivil) {
        this.estadoCivil = p_estadoCivil;
    }
    
    /**
     * Asigna el nombre de la mujer.
     * 
     * @param p_nombre nombre a asignar
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /**
     * Asigna el esposo de la mujer.
     * 
     * @param p_esposo esposo a asignar
     */
    private void setEsposo(Hombre p_esposo) {
        this.esposo = p_esposo;
    }

    /**
     * Obtiene el apellido de la mujer.
     * 
     * @return apellido de la mujer
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * Obtiene la edad de la mujer.
     * 
     * @return edad de la mujer
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Obtiene el estado civil de la mujer.
     * 
     * @return estado civil
     */
    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    /**
     * Obtiene el nombre de la mujer.
     * 
     * @return nombre de la mujer
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene el esposo de la mujer.
     * 
     * @return objeto Hombre correspondiente al esposo, o null
     */
    public Hombre getEsposo() {
        return this.esposo;
    }

    /**
     * Contrae matrimonio con el hombre indicado, actualizando estado civil a "Casada".
     * 
     * @param p_hombre hombre con el que se casa
     */
    public void casarseCon(Hombre p_hombre) {
        this.setEsposo(p_hombre);
        this.setEstadoCivil("Casada");
    }

    /**
     * Muestra por consola la información de matrimonio de la mujer con su esposo.
     */
    public void casadaCon() {
        System.out.println(this.datos() + " está casada con " + this.getEsposo().datos());
    }

    /**
     * Retorna una cadena con nombre, apellido y edad de la mujer.
     * 
     * @return cadena con el formato "Nombre Apellido de X años"
     */
    public String datos() {
        return this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años";
    }

    /**
     * Muestra por pantalla los datos de la mujer junto con su estado civil.
     */
    public void mostrarEstadoCivil() {
        System.out.println(this.datos() + " - " + this.getEstadoCivil());
    }

    /**
     * Realiza el divorcio, cambiando el estado civil a "Divorciada" y desvinculando al esposo.
     */
    public void divorcio() {
        this.setEstadoCivil("Divorciada");
        this.setEsposo(null); 
    }

}
