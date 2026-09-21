import java.util.ArrayList;
import java.util.HashSet;

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
    private ArrayList<CuentaCorriente> cuentas;

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
        this.setCuentas(new ArrayList<CuentaCorriente>());
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
        this.setCuentas(new ArrayList<CuentaCorriente>());
    }

    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados,
            ArrayList<CuentaCorriente> p_cuentas) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList<Empleado>());
        this.setCuentas(new ArrayList<CuentaCorriente>());
    }

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

    private void setCuentas(ArrayList<CuentaCorriente> p_cuentas) {
        this.cuentas = p_cuentas;

    }

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

    public ArrayList<CuentaCorriente> getCuenta() {
        return this.cuentas;
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
     * Muestra la información completa de la sucursal bancaria según el diseño
     * requerido:
     * Banco, Sucursal, Localidad, Provincia, nómina de sueldos y Total a Pagar.
     */
    public void mostrar() {
        System.out.println("Banco: " + this.getNombre() + "      Sucursal: " + this.getNroSucursal());
        System.out.println("Localidad: " + this.getLocalidad().getNombre() + "   Provincia: "
                + this.getLocalidad().getProvincia() + "\n");
        this.listarSueldos();
        System.out.println(
                "\nTotal a Pagar------------------------------------------------------------$" + this.sueldosAPagar());
    }

    public boolean agregarCuentaBancaria(CuentaCorriente p_cuenta) {
        return this.getCuenta().add(p_cuenta);
    }

    public boolean quitarCuentaBancaria(CuentaCorriente p_cuenta) {
        return this.getCuenta().remove(p_cuenta);
    }

    public void cuentasSinSaldo() {

        System.out.println("Cuentas sin Saldo: ");
        for (CuentaCorriente cuenta : this.getCuenta()) {
            if (cuenta.getSaldo() == 0) {
                System.out.println(cuenta.getNroCuenta() + " " + cuenta.getTitular().getApellido() + ", "
                        + cuenta.getTitular().getNombre());
                System.out.println("\n");
            }
        }

    }

    public HashSet<Persona> listaTitulares() {
        HashSet<Persona> titulares = new HashSet<Persona>();

        for (CuentaCorriente cuenta : this.getCuenta()) {
            titulares.add(cuenta.getTitular());
        }

        return titulares;
    }

    private int cuentasSaldoActivo() {

        int cuentasActivas = 0;
        for (CuentaCorriente cuenta : this.getCuenta()) {
            if (cuenta.getSaldo() > 0) {
                cuentasActivas++;
            }
        }
        return cuentasActivas;
    }

    private int cuentasSaldoInactivo() {

        int cuentasActivas = 0;
        for (CuentaCorriente cuenta : this.getCuenta()) {
            if (cuenta.getSaldo() == 0) {
                cuentasActivas++;
            }
        }
        return cuentasActivas;
    }

    public void mostrarResumen() {
        System.out.println("Banco: " + this.getNombre() + "      Sucursal: " + this.getNroSucursal());
        System.out.println("Localidad: " + this.getLocalidad().getNombre() + "   Provincia: "
                + this.getLocalidad().getProvincia());

        System.out.println("RESUMEN CUENTAS BANCARIAS");
        System.out.println("Total de cuentas: " + (cuentasSaldoActivo() + cuentasSaldoInactivo()));
        System.out.println("Cuentas Activas:" + cuentasSaldoActivo());
        System.out.println("Cuentas Inactivas:" + cuentasSaldoInactivo());

        cuentasSinSaldo();

        System.out.println("Listado de Clientes: ");
        int i = 0;

        for (Persona titular : this.listaTitulares()) {
            System.out.print(titular.apeYnom());
            if (i < this.listaTitulares().size() - 1) {
                System.out.print(";");

            }
            i++;
        }

    }

}
