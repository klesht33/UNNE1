public class Docente{
    private String nombre;
    private String grado;
    private double sueldoBasico;
    private double asignacionFamiliar;
    
    public Docente(String pNombre, String pGrado, double pSueldoBasico, double pAsignacionFamiliar){
        setNombre(pNombre);
        setGrado(pGrado);
        setSueldoBasico(pSueldoBasico);
        setAsignacionFamiliar(pAsignacionFamiliar);
    }
    
    private void setNombre(String pNombre){
        this.nombre = pNombre;
    }
    
    private void setGrado(String pGrado){
        this.grado = pGrado;
    }
    
    private void setSueldoBasico(double pSueldoBasico){
        this.sueldoBasico = pSueldoBasico;
    }
    
    private void setAsignacionFamiliar(double pAsignacionFamiliar){
        this.asignacionFamiliar = pAsignacionFamiliar;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public String getGrado(){
        return this.grado;
    }
    
    public double getSueldoBasico(){
        return this.sueldoBasico;
    }
    
    public double getAsignacionFamiliar(){
        return this.asignacionFamiliar;
    }
    
    public double calcularSueldo(){
        return getSueldoBasico() + getAsignacionFamiliar();
    }
    
    
    
    
    
    
}