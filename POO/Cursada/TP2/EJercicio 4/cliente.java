
/**
 * Representa a un cliente con sus datos de identificación y saldo.
 *
 * @version 1.0
 */
public class cliente {

    /** Número de Documento Nacional de Identidad del cliente. */
    private int nroDNI;
    /** Apellido del cliente. */
    private String apellido;
    /** Nombre del cliente. */
    private String nombre;
    /** Saldo actual del cliente. */
    private double saldo;

    /**
     * Crea un cliente con sus datos personales y saldo inicial.
     *
     * @param dni Documento Nacional de Identidad del cliente
     * @param apellido apellido del cliente
     * @param nombre nombre del cliente
     * @param importe saldo inicial del cliente
     */
    public cliente(int dni, String apellido, String nombre, double importe){
        setNroDNI(dni);
        setApellido(apellido);
        setNombre(nombre);
        setSaldo(importe);
    }
    /**
     * Muestra por consola los datos principales del cliente.
     */
    public void mostrar(){
        System.out.println("- Cliente -");
        System.out.println("Nombre y Apellido: " + nomYAp() + " (" + getNroDNi() + ")");
        System.out.println("Saldo: " + getSaldo());
    }

    /**
     * Asigna el número de Documento Nacional de Identidad del cliente.
     *
     * @param nroDNI número de Documento Nacional de Identidad que se asignará
     */
    private void setNroDNI(int nroDNI){
        this.nroDNI = nroDNI;
    }

    /**
     * Asigna el nombre del cliente.
     *
     * @param nombre nombre que se asignará
     */
    private void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Asigna el apellido del cliente.
     *
     * @param apellido apellido que se asignará
     */
    private void setApellido(String apellido){
        this.apellido = apellido;
    }

    /**
     * Asigna el saldo del cliente.
     *
     * @param saldo saldo que se asignará
     */
    private void setSaldo(double saldo){
        this.saldo = saldo;
    }

    /**
     * Obtiene el número de Documento Nacional de Identidad del cliente.
     *
     * @return número de Documento Nacional de Identidad del cliente
     */
    public int getNroDNi(){
        return nroDNI;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre del cliente
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene el apellido del cliente.
     *
     * @return apellido del cliente
     */
    public String getApellido(){
        return apellido;
    }

    /**
     * Construye el nombre y apellido del cliente.
     *
     * @return nombre y apellido del cliente
     */
    public String nomYAp(){
        return getNombre() + "" + getApellido();
    }

    /**
     * Obtiene el saldo actual del cliente.
     *
     * @return saldo del cliente
     */
    public double getSaldo(){
        return saldo;
    }

    /**
     * Calcula un nuevo saldo sumando un importe al saldo actual.
     *
     * @param importe importe que se sumará al saldo
     * @return resultado de sumar el importe al saldo actual
     */
    public double agregarSaldo(double importe){
        return getSaldo() + importe;
    }

    /**
     * Solicita la actualización del saldo con un importe.
     *
     * @param importe importe utilizado para la actualización
     */
    public void nuevoSaldo(double importe){
        agregarSaldo(importe);
    }


    



    
}
