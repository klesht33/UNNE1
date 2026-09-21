import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmpleadoConJefe{
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private Calendar fechaIngreso;
    private EmpleadoConJefe jefe;
    private int anioIngreso;
    public EmpleadoConJefe(long pCuil,String pApellido ,String pNombre,  double pImporte, Calendar pFecha, EmpleadoConJefe pJefe ){
        this.setCuil(pCuil);
        this.setApellido(pApellido);
        this.setNombre(pNombre);
        this.setSueldoBasico(pImporte);
        this.setSueldoBasico(pImporte);
        this.setFechaIngreso(pFecha);
        this.setJefe(pJefe);
    }
    
    public EmpleadoConJefe(long pCuil,String pApellido , String pNombre, double pImporte, Calendar pFecha){
        this.setCuil(pCuil);
        this.setApellido(pApellido);
        this.setNombre(pNombre);
        this.setSueldoBasico(pImporte);
        this.setFechaIngreso(pFecha);
    }

    public EmpleadoConJefe(long pCuil,String pApellido ,String pNombre, double pImporte, int pAnio){
        this.setCuil(pCuil);
        this.setApellido(pApellido);
        this.setNombre(pNombre);
        this.setSueldoBasico(pImporte);
        this.setAnioIngreso(pAnio);
    }
    public void setCuil(long pCuil) {
    this.cuil = pCuil;
}

public void setApellido(String pApellido) {
    this.apellido = pApellido;
}

public void setNombre(String pNombre) {
    this.nombre = pNombre;
}

public void setSueldoBasico(double pSueldoBasico) {
    this.sueldoBasico = pSueldoBasico;
}

public void setFechaIngreso(Calendar pFechaIngreso) {
    this.fechaIngreso = pFechaIngreso;
}

public void setJefe(EmpleadoConJefe pJefe) {
    this.jefe = pJefe;
}

public void setAnioIngreso(int pAnioIngreso) {
    this.anioIngreso = pAnioIngreso;
}

    public long getCuil() {
    return this.cuil;
}

public String getApellido() {
    return this.apellido;
}

public String getNombre() {
    return this.nombre;
}

public double getSueldoBasico() {
    return this.sueldoBasico;
}

public Calendar getFechaIngreso() {
    return this.fechaIngreso;
}

public EmpleadoConJefe getJefe() {
    return this.jefe;
}

public int getAnioIngreso() {
    return this.anioIngreso;
}

public int antiguedad() {
        GregorianCalendar fechaActual = new GregorianCalendar();
        return fechaActual.get(GregorianCalendar.YEAR) - getFechaIngreso().get(Calendar.YEAR);
    }
    
private double descuento() {
        return getSueldoBasico() * 0.02 + 1500;
    }
    
private double adicional() {

        if (antiguedad() >= 10) {
            return getSueldoBasico() * 0.06;
        } else if (antiguedad() >= 2) {
            return getSueldoBasico() * 0.04;
        } else {
            return getSueldoBasico() * 0.02;
        }

    }
    
public double sueldoNeto() {
        return getSueldoBasico() + adicional() - descuento();
    } 
    
public String getNomYApe() {
        return getNombre() + " " + getApellido();
    }
    
public void mostrarLinea() {
        System.out.println("" + getCuil() + " " + getApellido() + ", " + " " + getNombre() + " " + " $" + sueldoNeto());
    }
    
 public void mostrar(){
    System.out.println("Nombre y Apellido: "+ getNomYApe());
    System.out.println("CUIL: "+ getCuil());
    System.out.println("Sueldo Neto: " + sueldoNeto());
    if (getJefe() != null) {
            System.out.println("Responde a: " + getJefe().getNomYApe());
        } else {
            System.out.println("Responde a: GERENTE GENERAL");
        }
        
    
    }   
    
}


