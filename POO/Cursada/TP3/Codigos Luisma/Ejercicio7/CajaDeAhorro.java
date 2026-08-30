public class CajaDeAhorro{
    private int nroCuenta;
    private double saldo = 0;
    private int extraccionesPosibles;
    private Persona titular;

    public CajaDeAhorro(int pNroCuenta, Persona pTitular){
        this.setNroCuenta(pNroCuenta);
        this.setTitular(pTitular);
        this.setExtraccionesPosibles(10);
    }

    public CajaDeAhorro(int pNroCuenta, Persona pTitular, double pSaldo){
        this.setNroCuenta(pNroCuenta);
        this.setTitular(pTitular);
        this.setSaldo(pSaldo);
        this.setExtraccionesPosibles(10);
    }

    private void setNroCuenta(int pNroCuenta){
        this.nroCuenta = pNroCuenta;
    }

    private void setTitular (Persona pTitular){
        this.titular = pTitular;
    }

    private void setSaldo(double pSaldo){
        this.saldo = pSaldo;
    }
    
    private void setExtraccionesPosibles(int pExtraccionesPosibles){
        this.extraccionesPosibles = pExtraccionesPosibles;
    }
    
    public int getExtraccionesPosibles(){
        return this.extraccionesPosibles;
    }
    
    public int getNroCuenta(){
        return  this.nroCuenta;
    }
    
    public Persona getTitular(){
        return this.titular;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public void depositar(double pImporte){
         this.saldo += pImporte;
    }
    
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
    
    
    private boolean puedeExtraer(double pImporte){
    //Es un método auxiliar interno: Su única función es ayudar al método principal extraer(p_importe) a tomar una decisión.
    //Los usuarios externos de la clase no necesitan invocar puedeExtraer() directamente; ellos solo llaman a extraer().

    //Encapsulamiento: Oculta la lógica interna de validación. Si el día de mañana la regla para permitir una extracción cambia,
    //solo modificas este método interno sin afectar el resto del programa.
        return (pImporte <= getSaldo()) && (getExtraccionesPosibles() >= 1 );
    }
    
    private void extraccion (double pImporte){
        this.setSaldo (this.getSaldo() - pImporte);
        this.setExtraccionesPosibles (this.getExtraccionesPosibles() - 1);
    }
    
public void mostrar(){
        System.out.println("-Caja de Ahorro-");
        System.out.println("Nro.Cuenta: "+ getNroCuenta() + "- Saldo:" + getSaldo());
        System.out.println("Titular: "+ getTitular().nomYAp());
        System.out.println("Extracciones posibles: "+ getExtraccionesPosibles());
    }
}