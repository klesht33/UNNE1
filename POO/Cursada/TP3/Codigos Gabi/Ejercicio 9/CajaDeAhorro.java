/**
 * Representa una Caja de Ahorro bancaria con límite de extracciones y control de saldo.
 * 
 * @author Gabi
 * @version 1.0
 */
public class CajaDeAhorro{
    /** Número identificador de la cuenta. */
    private int nroCuenta;
    /** Saldo actual en la caja de ahorro. */
    private double saldo = 0;
    /** Cantidad de extracciones restantes permitidas. */
    private int extraccionesPosibles;
    /** Titular de la caja de ahorro. */
    private Persona titular;

    /**
     * Constructor que inicializa la caja de ahorro con saldo cero y 10 extracciones posibles.
     * 
     * @param pNroCuenta número de la cuenta
     * @param pTitular persona titular de la cuenta
     */
    public CajaDeAhorro(int pNroCuenta, Persona pTitular){
        this.setNroCuenta(pNroCuenta);
        this.setTitular(pTitular);
        this.setExtraccionesPosibles(10);
    }

    /**
     * Constructor que inicializa la caja de ahorro con un saldo determinado y 10 extracciones posibles.
     * 
     * @param pNroCuenta número de la cuenta
     * @param pTitular persona titular de la cuenta
     * @param pSaldo saldo inicial de la cuenta
     */
    public CajaDeAhorro(int pNroCuenta, Persona pTitular, double pSaldo){
        this.setNroCuenta(pNroCuenta);
        this.setTitular(pTitular);
        this.setSaldo(pSaldo);
        this.setExtraccionesPosibles(10);
    }

    /**
     * Asigna el número de cuenta.
     * 
     * @param pNroCuenta número de cuenta a asignar
     */
    private void setNroCuenta(int pNroCuenta){
        this.nroCuenta = pNroCuenta;
    }

    /**
     * Asigna la persona titular de la cuenta.
     * 
     * @param pTitular titular a asignar
     */
    private void setTitular (Persona pTitular){
        this.titular = pTitular;
    }

    /**
     * Asigna el saldo de la cuenta.
     * 
     * @param pSaldo saldo a asignar
     */
    private void setSaldo(double pSaldo){
        this.saldo = pSaldo;
    }
    
    /**
     * Asigna la cantidad de extracciones posibles.
     * 
     * @param pExtraccionesPosibles cantidad de extracciones a asignar
     */
    private void setExtraccionesPosibles(int pExtraccionesPosibles){
        this.extraccionesPosibles = pExtraccionesPosibles;
    }
    
    /**
     * Obtiene la cantidad de extracciones posibles restantes.
     * 
     * @return cantidad de extracciones posibles
     */
    public int getExtraccionesPosibles(){
        return this.extraccionesPosibles;
    }
    
    /**
     * Obtiene el número de cuenta.
     * 
     * @return número de cuenta
     */
    public int getNroCuenta(){
        return  this.nroCuenta;
    }
    
    /**
     * Obtiene la persona titular de la cuenta.
     * 
     * @return persona titular
     */
    public Persona getTitular(){
        return this.titular;
    }
    
    /**
     * Obtiene el saldo disponible de la cuenta.
     * 
     * @return saldo de la cuenta
     */
    public double getSaldo(){
        return this.saldo;
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
     * Realiza una extracción si las condiciones de saldo y extracciones disponibles lo permiten.
     * 
     * @param pImporte importe a extraer
     */
    public void extraer (double pImporte){
        if(this.puedeExtraer(pImporte)){
            extraccion(pImporte);
        }
        else {
            String motivo = (pImporte > this.getSaldo())
            ? "No puede extraer mas que el saldo!"
            : "No tiene mas extracciones disponibles!";
            
            System.out.println(motivo);
            
        }
    }
    
    /**
     * Evalúa si es posible realizar una extracción por el importe dado según saldo y extracciones restantes.
     * 
     * @param pImporte importe a evaluar
     * @return true si es posible extraer, false de lo contrario
     */
    private boolean puedeExtraer(double pImporte){
        return (pImporte <= getSaldo()) && (getExtraccionesPosibles() >= 1 );
    }
    
    /**
     * Aplica la extracción descontando el saldo y decrementando en 1 las extracciones disponibles.
     * 
     * @param pImporte importe a descontar
     */
    private void extraccion (double pImporte){
        this.setSaldo (this.getSaldo() - pImporte);
        this.setExtraccionesPosibles (this.getExtraccionesPosibles() - 1);
    }
    
    /**
     * Muestra por consola el estado detallado de la caja de ahorro.
     */
    public void mostrar(){
        System.out.println("-Caja de Ahorro-");
        System.out.println("Nro.Cuenta: "+ getNroCuenta() + "- Saldo:" + getSaldo());
        System.out.println("Titular: "+ getTitular().nomYAp());
        System.out.println("Extracciones posibles: "+ getExtraccionesPosibles());
    }
}