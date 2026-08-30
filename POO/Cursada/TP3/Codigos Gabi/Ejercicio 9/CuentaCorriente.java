/**
 * Representa una Cuenta Corriente bancaria que permite giros al descubierto hasta un límite determinado.
 * 
 * @author Gabi
 * @version 1.0
 */
public class CuentaCorriente{
    /** Número identificador de la cuenta corriente. */
    private int nroCuenta;
    /** Saldo actual en la cuenta corriente. */
    private double saldo = 0;
    /** Límite de descubierto permitido para extracciones. */
    private double limiteDescubierto;
    /** Titular de la cuenta corriente. */
    private Persona titular;
    
    /**
     * Constructor que inicializa la cuenta corriente con saldo cero y límite de descubierto por defecto de $500.
     * 
     * @param pNroCuenta número de la cuenta
     * @param pTitular persona titular de la cuenta
     */
    public CuentaCorriente(int pNroCuenta, Persona pTitular){
        this.setNroCuenta(pNroCuenta);
        this.setTitular(pTitular);
        this.setLimiteDescubierto();
    }
    
    /**
     * Constructor que inicializa la cuenta corriente con un saldo inicial y límite de descubierto por defecto de $500.
     * 
     * @param pNroCuenta número de la cuenta
     * @param pTitular persona titular de la cuenta
     * @param pSaldo saldo inicial de la cuenta
     */
    public CuentaCorriente(int pNroCuenta, Persona pTitular, double pSaldo){
        setNroCuenta(pNroCuenta);
        setTitular(pTitular);
        setSaldo(pSaldo);
        this.setLimiteDescubierto();
    }
    
    /**
     * Asigna el número de cuenta corriente.
     * 
     * @param pNroCuenta número de cuenta a asignar
     */
    private void setNroCuenta(int pNroCuenta ){
        this.nroCuenta = pNroCuenta;
    }

    /**
     * Asigna el titular de la cuenta corriente.
     * 
     * @param pTitular titular a asignar
     */
    private void setTitular(Persona pTitular){
        this.titular = pTitular;
    }
    
    /**
     * Asigna el saldo de la cuenta corriente.
     * 
     * @param pSaldo saldo a asignar
     */
    private void setSaldo(double pSaldo){
        this.saldo = pSaldo;
    }
    
    /**
     * Asigna el límite de descubierto fijándolo en 500.
     */
    private void setLimiteDescubierto(){
        this.limiteDescubierto = 500;
    }
    
    /**
     * Obtiene el número de cuenta.
     * 
     * @return número de cuenta
     */
    public int getNroCuenta(){
        return this.nroCuenta;
    }
    
    /**
     * Obtiene el titular de la cuenta corriente.
     * 
     * @return objeto persona titular
     */
    public Persona getTitular(){
        return this.titular;
    }
    
    /**
     * Obtiene el saldo de la cuenta corriente.
     * 
     * @return saldo actual
     */
    public double getSaldo(){
        return this.saldo;
    }
    
    /**
     * Obtiene el límite de descubierto permitido.
     * 
     * @return límite de descubierto
     */
    public double getLimiteDescubierto(){
        return this.limiteDescubierto;
    }
    
    /**
     * Evalúa si es posible realizar una extracción considerando saldo más descubierto.
     * 
     * @param pImporte importe a extraer
     * @return true si los fondos más el descubierto son suficientes, false de lo contrario
     */
    private boolean puedeExtraer(double pImporte){
        return pImporte <= (getSaldo() + getLimiteDescubierto());
    }
    
    /**
     * Realiza un depósito sumando el importe al saldo actual.
     * 
     * @param pImporte importe a depositar
     */
    public void depositar(double pImporte){
         this.saldo += pImporte;
    }
    
    /**
     * Realiza una extracción descontando el saldo si se encuentra dentro del saldo más el descubierto.
     * 
     * @param pImporte importe a extraer
     */
    public void extraer(double pImporte){
        if(puedeExtraer(pImporte)){
            extraccion(pImporte);
        }
        else{
            System.out.println("No se pudo realizar la extraccion porque el importe supera el saldo mas el limite descubierto ");
        }
    }
    
    /**
     * Aplica la extracción descontando el importe del saldo.
     * 
     * @param pImporte importe a descontar
     */
    private void extraccion (double pImporte){
        this.saldo -= pImporte;
    }
    
    /**
     * Muestra por consola los datos detallados de la cuenta corriente.
     */
    public void mostrar(){
        System.out.println("-Cuenta Corriente-");
        System.out.println("Nro.Cuenta: "+ getNroCuenta() + "- Saldo:" + getSaldo());
        System.out.println("Titular: "+ getTitular().nomYAp());
        System.out.println("Descubierto: "+ getLimiteDescubierto());
    }
}   