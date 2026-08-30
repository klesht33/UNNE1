public class Escuela{
    private String nombre;
    private String domicilio;
    private String director;
    private Docente docente;

    public Escuela(String pNombre, String pDomicilio, String pDirector){
        setNombre(pNombre);
        setDomicilio(pDomicilio);
        setDirector(pDirector);
    }
    
    private void setNombre( String pNombre){
        this.nombre = pNombre;
    }
    private void setDomicilio(String pDomicilio){
        this.domicilio = pDomicilio;
    }
    
    private void setDirector(String pDirector){
        this.director = pDirector;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public String getDomicilio(){
        return this.domicilio;
    }
    public String getDirector(){
        return this.director;
    }
    
    public void imprimirRecibo(Docente pDocente){
        System.out.println("Escuela: "+ getNombre() + " " + "Domicilio: "+ getDomicilio() + " " + "Director: "+ getDirector());
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Docente: "+ pDocente.getNombre());
        System.out.println("Sueldo: "+ pDocente.calcularSueldo());
        System.out.println("Sueldo Basico: "+ pDocente.getSueldoBasico());
        System.out.println("Asignacion familiar: "+ pDocente.getAsignacionFamiliar());
    }
}