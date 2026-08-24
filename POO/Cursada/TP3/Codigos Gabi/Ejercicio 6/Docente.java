public class Docente {
    private String nombre;
    private String grado;
    private double sueldoBasico;
    private double asignacionFamiliar;

    public Docente(String p_nombre, String p_grado, double p_sueldoBasico, double p_asignacionFamiliar){
        setNombre(p_nombre);
        setGrado(p_grado);
        setSueldoBasico(p_sueldoBasico);
        setAsignacionFamiliar(p_asignacionFamiliar);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAsignacionFamiliar(double asignacionFamiliar) {
        this.asignacionFamiliar = asignacionFamiliar;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public double getAsignacionFamiliar() {
        return this.asignacionFamiliar;
    }

    public String getGrado() {
        return this.grado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    public double calcularSueldo(){
        return getAsignacionFamiliar() + getSueldoBasico();
    }    
}
