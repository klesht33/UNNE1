import java.util.ArrayList;

/**
 * Representa una entidad bancaria que liquida sueldos de sus empleados.
 * Posee al menos un empleado desde su creación (relación 1..*).
 * 
 * @author Gabi
 * @version 1.0
 */
public class Banco {

    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList<Empleado> empleados;

    /**
     * Constructor que inicializa el banco con un único empleado.
     * Cumple con la restricción de poseer al menos un empleado al crearse.
     * 
     * @param p_nombre      Nombre del banco
     * @param p_localidad   Localidad de la sucursal
     * @param p_nroSucursal Número identificador de la sucursal
     * @param p_empleado    Empleado inicial del banco
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList<Empleado>());
        this.agregarEmpleado(p_empleado);
    }

    /**
     * Constructor que inicializa el banco con una lista de empleados.
     * 
     * @param p_nombre      Nombre del banco
     * @param p_localidad   Localidad de la sucursal
     * @param p_nroSucursal Número identificador de la sucursal
     * @param p_empleados   Lista con los empleados iniciales
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
    }

    // Setters (mutadores privados según diagrama)
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setNroSucursal(int p_nroSucursal) {
        this.nroSucursal = p_nroSucursal;
    }

    private void setLocalidad(Localidad p_localidad) {
        this.localidad = p_localidad;
    }

    private void setEmpleados(ArrayList<Empleado> p_empleados) {
        this.empleados = p_empleados;
    }

    // Getters (observadores)
    public String getNombre() {
        return this.nombre;
    }

    public int getNroSucursal() {
        return this.nroSucursal;
    }

    public Localidad getLocalidad() {
        return this.localidad;
    }

    public ArrayList<Empleado> getEmpleados() {
        return this.empleados;
    }

    /**
     * Agrega un empleado a la nómina del banco.
     * 
     * @param p_empleado Empleado a contratar
     * @return true si se agregó correctamente
     */
    public boolean agregarEmpleado(Empleado p_empleado) {
        return this.getEmpleados().add(p_empleado);
    }

    /**
     * Da de baja a un empleado de la nómina del banco.
     * Respeta la restricción de mantener al menos 1 empleado en el banco.
     * 
     * @param p_empleado Empleado a despedir
     * @return true si se pudo despedir, false si no se encontró o si solo queda 1
     *         empleado
     */
    public boolean quitarEmpleado(Empleado p_empleado) {
        if (this.getEmpleados().size() > 1) {
            return this.getEmpleados().remove(p_empleado);
        }
        return false;
    }

    /**
     * Calcula la suma total de los sueldos netos a pagar a todos los empleados.
     * 
     * @return Monto total en concepto de sueldos netos
     */
    public double sueldosAPagar() {
        double total = 0.0;
        for (Empleado empleado : this.getEmpleados()) {
            total += empleado.sueldoNeto();
        }
        return total;
    }

    /**
     * Lista por pantalla los sueldos de cada uno de los empleados con el formato:
     * CUIL Apellido, Nombre -------------------- $sueldoNeto
     */
    public void listarSueldos() {
        for (Empleado empleado : this.getEmpleados()) {
            System.out.println(empleado.getCuil() + "  " + empleado.getApellido() + ", " + empleado.getNombre()
                    + " ----------------------------------------$" + empleado.sueldoNeto());
        }
    }

    /**
     * Muestra la información completa de la sucursal bancaria según el diseño requerido:
     * Banco, Sucursal, Localidad, Provincia, nómina de sueldos y Total a Pagar.
     */
    public void mostrar() {
        System.out.println("Banco: " + this.getNombre() + "      Sucursal: " + this.getNroSucursal());
        System.out.println("Localidad: " + this.getLocalidad().getNombre() + "   Provincia: " + this.getLocalidad().getProvincia() + "\n");
        this.listarSueldos();
        System.out.println("\nTotal a Pagar------------------------------------------------------------$" + this.sueldosAPagar());
    }

}
