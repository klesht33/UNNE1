/**
 * Representa una institución educativa escolar y gestiona la impresión de recibos de sueldo para sus docentes.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Escuela {

    /** Nombre de la escuela. */
    private String nombre;
    /** Domicilio de la escuela. */
    private String domicilio;
    /** Nombre del director de la escuela. */
    private String director;

    /**
     * Constructor que inicializa los datos institucionales de la escuela.
     * 
     * @param p_nombre nombre de la escuela
     * @param p_domicilio domicilio de la escuela
     * @param p_director nombre del director
     */
    public Escuela(String p_nombre, String p_domicilio, String p_director){
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setDirector(p_director);
    }

    /**
     * Imprime por consola el recibo de sueldo detallado de un docente.
     * 
     * @param p_docente docente del cual se emite el recibo
     */
    public void imprimirRecibo(Docente p_docente){
        System.out.println("Escuela: " + getNombre() + 
                           " Domicilio: " + getDomicilio() + 
                           " Director: " + getDirector());
        System.out.println("--------------------------------");
        System.out.println("Docente: " + p_docente.getNombre());
        System.out.println("Sueldo: ........ $" + p_docente.calcularSueldo());
        System.out.println("Sueldo Basico: ....... $" + p_docente.getSueldoBasico());
        System.out.println("Asignacion Familiar: ..... $" + p_docente.getAsignacionFamiliar());
    }

    /**
     * Asigna el nombre de la escuela.
     * 
     * @param p_nombre nombre a asignar
     */
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    /**
     * Asigna el domicilio de la escuela.
     * 
     * @param p_domicilio domicilio a asignar
     */
    private void setDomicilio(String p_domicilio){
        this.domicilio = p_domicilio;
    }

    /**
     * Asigna el director de la escuela.
     * 
     * @param p_director nombre del director a asignar
     */
    private void setDirector(String p_director){
        this.director = p_director;
    }
    
    /**
     * Obtiene el nombre de la escuela.
     * 
     * @return nombre de la escuela
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Obtiene el domicilio de la escuela.
     * 
     * @return domicilio de la escuela
     */
    public String getDomicilio(){
        return this.domicilio;
    }

    /**
     * Obtiene el director de la escuela.
     * 
     * @return nombre del director
     */
    public String getDirector(){
        return this.director;
    }
}
