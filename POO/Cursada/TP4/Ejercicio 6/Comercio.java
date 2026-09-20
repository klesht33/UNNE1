import java.util.HashMap;
import java.util.Map;

public class Comercio {
    private String nombre;
    private HashMap<Long, Empleado> empleados;

    public Comercio(String p_nombre) {
        this.setNombre(p_nombre);
        this.setEmpleados(new HashMap<Long, Empleado>());
    }

    public Comercio(String p_nombre, HashMap<Long, Empleado> p_empleados) {
        this.setNombre(p_nombre);
        this.setEmpleados(p_empleados);
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setEmpleados(HashMap<Long, Empleado> p_empleados) {
        this.empleados = p_empleados;
    }

    public String getNombre() {
        return this.nombre;
    }

    public HashMap<Long, Empleado> getEmpleados() {
        return this.empleados;
    }

    public void altaEmpleado(Empleado p_empleado) {
        this.getEmpleados().put(p_empleado.getCuil(), p_empleado);
    }

    public Empleado bajaEmpleado(long p_cuil) {
        return this.getEmpleados().remove(p_cuil);
    }

    public int cantidadDeEmpleados() {
        return this.getEmpleados().size();
    }

    public boolean esEmpleado(long p_cuil) {
        return this.getEmpleados().containsKey(p_cuil);
    }

    public Empleado buscarEmpleado(long p_cuil) {
        return this.getEmpleados().get(p_cuil);
    }

    public void sueldoNeto(long p_cuil) {
        System.out.println(this.buscarEmpleado(p_cuil).sueldoNeto());
    }

    public void nomina() {
        System.out.println("**** Nomina de empleados de " + this.getNombre() + " ****");
        for (Empleado unEmpleado : this.getEmpleados().values()) {
            unEmpleado.mostrarLinea();
        }
    }
}
