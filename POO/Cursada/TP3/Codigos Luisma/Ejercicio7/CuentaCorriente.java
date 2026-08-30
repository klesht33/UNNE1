public class CuentaCorriente{
    private int nroCuenta;
    private double saldo = 0;
    private double limiteDescubierto;
    private Persona titular;
    
    public CuentaCorriente(int pNroCuenta, Persona pTitular){
        this.setNroCuenta(pNroCuenta);
        this.setTitular(pTitular);
        this.setLimiteDescubierto();
    }
    
    public CuentaCorriente(int pNroCuenta, Persona pTitular, double pSaldo){
        setNroCuenta(pNroCuenta);
        setTitular(pTitular);
        setSaldo(pSaldo);
        this.setLimiteDescubierto();
    }
    
    private void setNroCuenta(int pNroCuenta ){
        this.nroCuenta = pNroCuenta;
    }
    private void setTitular(Persona pTitular){
        this.titular = pTitular;
    }
    
    private void setSaldo(double pSaldo){
        this.saldo = pSaldo;
    }
    
    private void setLimiteDescubierto(){
        this.limiteDescubierto = 500;
    }
    
    public int getNroCuenta(){
        return this.nroCuenta;
    }
    
    public Persona getTitular(){
        return this.titular;
    }
    
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public double getLimiteDescubierto(){
        return this.limiteDescubierto;
    }
    
    private boolean puedeExtraer(double pImporte){
    //Es un método auxiliar interno: Su única función es ayudar al método principal extraer(p_importe) a tomar una decisión.
    //Los usuarios externos de la clase no necesitan invocar puedeExtraer() directamente; ellos solo llaman a extraer().

    //Encapsulamiento: Oculta la lógica interna de validación. Si el día de mañana la regla para permitir una extracción cambia,
    //solo modificas este método interno sin afectar el resto del programa.
        return pImporte <= (getSaldo() + getLimiteDescubierto());
    }
    
    public void depositar(double pImporte){
         this.saldo += pImporte;
    }
    
    public void extraer(double pImporte){
        if(puedeExtraer(pImporte)){
            extraccion(pImporte);
        }
        else{
            System.out.println("No se pudo realizar la extraccion porque el importe supera el saldo mas el limite descubierto ");
        }
    }
    
    private void extraccion (double pImporte){
        this.saldo -= pImporte;
    }
    
    public void mostrar(){
        System.out.println("-Cuenta Corriente-");
        System.out.println("Nro.Cuenta: "+ getNroCuenta() + "- Saldo:" + getSaldo());
        System.out.println("Titular: "+ getTitular().nomYAp());
        System.out.println("Descubierto: "+ getLimiteDescubierto());
    }
}   