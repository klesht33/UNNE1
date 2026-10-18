/**
 * Representa una Caja de Ahorro bancaria con límite de extracciones y control
 * de saldo.
 * 
 * @author Gabi
 * @version 1.0
 */
public class CajaDeAhorro extends CuentaBancaria {

    /** Cantidad de extracciones restantes permitidas. */
    private int extraccionesPosibles;

    /**
     * Constructor que inicializa la caja de ahorro con saldo cero y 10 extracciones
     * posibles.
     * 
     * @param pNroCuenta número de la cuenta
     * @param pTitular   persona titular de la cuenta
     */
    public CajaDeAhorro(int pNroCuenta, Persona pTitular) {
        super(pNroCuenta, pTitular);
        this.setExtraccionesPosibles(10);
    }

    /**
     * Constructor que inicializa la caja de ahorro con un saldo determinado y 10
     * extracciones posibles.
     * 
     * @param pNroCuenta número de la cuenta
     * @param pTitular   persona titular de la cuenta
     * @param pSaldo     saldo inicial de la cuenta
     */
    public CajaDeAhorro(int pNroCuenta, Persona pTitular, double pSaldo) {
        super(pNroCuenta, pTitular, pSaldo);
        this.setExtraccionesPosibles(10);
    }

    /**
     * Asigna la cantidad de extracciones posibles.
     * 
     * @param pExtraccionesPosibles cantidad de extracciones a asignar
     */
    private void setExtraccionesPosibles(int pExtraccionesPosibles) {
        this.extraccionesPosibles = pExtraccionesPosibles;
    }

    /**
     * Obtiene la cantidad de extracciones posibles restantes.
     * 
     * @return cantidad de extracciones posibles
     */
    public int getExtraccionesPosibles() {
        return this.extraccionesPosibles;
    }

    /**
     * Realiza una extracción si las condiciones de saldo y extracciones disponibles
     * lo permiten.
     * 
     * @param pImporte importe a extraer
     */
    public boolean extraer(double pImporte) {

        if (this.puedeExtraer(pImporte)) {
            extraccion(pImporte);
            return true;
        } else {
            String motivo = (pImporte > super.getSaldo())
                    ? "No puede extraer mas que el saldo!"
                    : "No tiene mas extracciones disponibles!";

            System.out.println(motivo);
            return false;
        }
    }

    /**
     * Evalúa si es posible realizar una extracción por el importe dado según saldo
     * y extracciones restantes.
     * 
     * @param pImporte importe a evaluar
     * @return true si es posible extraer, false de lo contrario
     */
    private boolean puedeExtraer(double pImporte) {
        return (pImporte > 0) && (pImporte <= super.getSaldo()) && (getExtraccionesPosibles() >= 1);
    }

    /**
     * Aplica la extracción descontando el saldo y decrementando en 1 las
     * extracciones disponibles.
     * 
     * @param pImporte importe a descontar
     */
    private void extraccion(double pImporte) {
        this.setSaldo(super.getSaldo() - pImporte);
        this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
    }

    /**
     * Muestra por consola el estado detallado de la caja de ahorro.
     */
    public void mostrar() {
        System.out.println("-Caja de Ahorro-");
        System.out.println("Nro.Cuenta: " + super.getNroCuenta() + " - Saldo: $" + super.getSaldo());
        String nombreTitular = (super.getTitular() != null) ? super.getTitular().nomYAp() : "Sin titular";
        System.out.println("Titular: " + nombreTitular);
        System.out.println("Extracciones posibles: " + getExtraccionesPosibles());
    }
}