/**
 * Representa una cuenta bancaria con número de cuenta, persona titular y saldo administrable.
 * 
 * @author Gabi
 * @version 1.0
 */
public class CuentaBancaria {

    /** Número identificador de la cuenta bancaria. */
    private int nroCuenta;
    /** Titular de la cuenta bancaria. */
    private persona titular;
    /** Saldo actual de la cuenta bancaria. */
    private double saldo;

    /**
     * Constructor que crea una cuenta con saldo inicial en cero.
     * 
     * @param p_nroCuenta número de la cuenta
     * @param p_titular persona titular de la cuenta
     */
    public CuentaBancaria(int p_nroCuenta, persona p_titular){
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
    }

    /**
     * Constructor que crea una cuenta bancaria con un saldo inicial determinado.
     * 
     * @param p_nroCuenta número de la cuenta
     * @param p_titular persona titular de la cuenta
     * @param p_saldo saldo inicial de la cuenta
     */
    public CuentaBancaria(int p_nroCuenta, persona p_titular, double p_saldo){
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }

    /**
     * Asigna el número de cuenta.
     * 
     * @param nroCuenta número de cuenta a asignar
     */
    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    /**
     * Asigna el titular de la cuenta.
     * 
     * @param titular persona titular a asignar
     */
    public void setTitular(persona titular) {
        this.titular = titular;
    }

    /**
     * Asigna el saldo de la cuenta.
     * 
     * @param saldo saldo a asignar
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el número de cuenta.
     * 
     * @return número de cuenta
     */
    public int getNroCuenta() {
        return nroCuenta;
    }

    /**
     * Obtiene el titular de la cuenta.
     * 
     * @return objeto persona titular
     */
    public persona getTitular() {
        return titular;
    }

    /**
     * Obtiene el saldo disponible de la cuenta.
     * 
     * @return saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Realiza un depósito sumando el importe al saldo actual.
     * 
     * @param p_importe monto a depositar
     * @return saldo actualizado luego del depósito
     */
    public double despositar(double p_importe){
        this.saldo += p_importe;
        return this.saldo;
    }

    /**
     * Realiza una extracción restando el importe al saldo si hay fondos suficientes.
     * 
     * @param p_importe monto a extraer
     * @return saldo actualizado luego de la operación
     */
    public double extraer(double p_importe){
        if (p_importe <= this.saldo){
            this.saldo -= p_importe;
            return this.saldo;
        }else{
            System.out.println("Saldo insuficiente");
            return this.saldo;
        }
    }

    /**
     * Muestra por consola la información básica de la cuenta bancaria.
     */
    public void mostrar(){
        System.out.println("- Cuenta Bancaria -");
        System.out.println("Titular: " + this.titular.getNombre() + " ( " + this.titular.edad() + " )");
        System.out.println("Saldo: " + this.saldo);
    }

    /**
     * Retorna una representación en cadena con los datos principales de la cuenta.
     * 
     * @return cadena con el formato "nroCuenta - Apellido y Nombre - saldo"
     */
    public String toString(){
        return this.nroCuenta + " - " + this.titular.nomYAp() + " - " + this.saldo;
    }
}
