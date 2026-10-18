/**
 * Representa una Cuenta Corriente bancaria que permite giros al descubierto
 * hasta un límite determinado.
 * 
 * @author Gabi
 * @version 1.0
 */
public class CuentaCorriente extends CuentaBancaria {

    /** Límite de descubierto permitido para extracciones. */
    private double limiteDescubierto;

    /**
     * Constructor que inicializa la cuenta corriente con saldo cero y límite de
     * descubierto por defecto de $500.
     * 
     * @param pNroCuenta número de la cuenta
     * @param pTitular   persona titular de la cuenta
     */
    public CuentaCorriente(int pNroCuenta, Persona pTitular) {
        super(pNroCuenta, pTitular);
        this.setLimiteDescubierto();
    }

    /**
     * Constructor que inicializa la cuenta corriente con un saldo inicial y límite
     * de descubierto por defecto de $500.
     * 
     * @param pNroCuenta número de la cuenta
     * @param pTitular   persona titular de la cuenta
     * @param pSaldo     saldo inicial de la cuenta
     */
    public CuentaCorriente(int pNroCuenta, Persona pTitular, double pSaldo) {
        super(pNroCuenta, pTitular, pSaldo);
        this.setLimiteDescubierto();
    }

    /**
     * Asigna el límite de descubierto fijándolo en 500.
     */
    private void setLimiteDescubierto() {
        this.limiteDescubierto = 500;
    }

    /**
     * Obtiene el límite de descubierto permitido.
     * 
     * @return límite de descubierto
     */
    public double getLimiteDescubierto() {
        return this.limiteDescubierto;
    }

    /**
     * Evalúa si es posible realizar una extracción considerando saldo más
     * descubierto y que el importe sea positivo.
     * 
     * @param pImporte importe a extraer
     * @return true si los fondos más el descubierto son suficientes y el importe es
     *         mayor a cero, false de lo contrario
     */
    private boolean puedeExtraer(double pImporte) {
        return (pImporte > 0) && (pImporte <= (super.getSaldo() + getLimiteDescubierto()));
    }

    /**
     * Realiza una extracción descontando el saldo si se encuentra dentro del saldo
     * más el descubierto.
     * 
     * @param pImporte importe a extraer
     */
    public boolean extraer(double pImporte) {
        if (pImporte <= 0) {
            System.out.println("El importe a extraer debe ser mayor a cero.");
            return false;
        }

        if (puedeExtraer(pImporte)) {
            extraccion(pImporte);
            return true;
        } else {
            System.out.println("No se pudo realizar la extraccion: el importe ($" + pImporte
                    + ") supera el saldo disponible ($" + getSaldo()
                    + ") mas el limite descubierto ($" + getLimiteDescubierto() + ").");
            return false;
        }
    }

    /**
     * Aplica la extracción descontando el importe del saldo.
     * 
     * @param pImporte importe a descontar
     */
    private void extraccion(double pImporte) {
        super.setSaldo(this.getSaldo() - pImporte);
    }

    /**
     * Muestra por consola los datos detallados de la cuenta corriente.
     */
    public void mostrar() {
        System.out.println("-Cuenta Corriente-");
        System.out.println("Nro.Cuenta: " + getNroCuenta() + " - Saldo: $" + getSaldo());
        String nombreTitular = (getTitular() != null) ? getTitular().nomYAp() : "Sin titular";
        System.out.println("Titular: " + nombreTitular);
        System.out.println("Descubierto: $" + getLimiteDescubierto());
    }
}