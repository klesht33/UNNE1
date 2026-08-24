public class Escuela {

    private String nombre;
    private String domicilio;
    private String director;
    private Docente docente;

    public Escuela(String p_nombre, String p_domicilio, String p_director){
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setDirector(p_director);
    }

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

    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setDomicilio(String p_domicilio){
        this.domicilio = p_domicilio;
    }

    private void setDirector(String p_director){
        this.director = p_director;
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
}
