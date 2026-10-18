public class CuentaCorriente extends CuentaBancaria {
    private double limiteDescubierto;

    public CuentaCorriente(int p_nroCuenta, Persona p_titular) {
        super(p_nroCuenta, p_titular);
        this.limiteDescubierto = 0.0;
    }

    public CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo) {
        super(p_nroCuenta, p_titular, p_saldo);
        this.limiteDescubierto = 0.0;
    }

    public double getLimiteDescubierto() { return this.limiteDescubierto; }
    private void setLimiteDescubierto(double p_limite) { this.limiteDescubierto = p_limite; }

    @Override
    protected boolean puedeExtraer(double p_importe) {
        return (getSaldo() + this.limiteDescubierto) >= p_importe;
    }

    @Override
    public boolean extraer(double p_importe) {
        if (puedeExtraer(p_importe)) {
            setSaldo(getSaldo() - p_importe);
            return true;
        }
        return false;
    }

    @Override
    public String xQNoPuedeExtraer(double p_importe) {
        if (!puedeExtraer(p_importe)) {
            return "El importe supera el saldo más el límite de descubierto.";
        }
        return "Puede extraer.";
    }

    @Override
    public void mostrar() {
        System.out.println("Cuenta Corriente Nro: " + getNroCuenta());
        System.out.println("Titular: " + getTitular().getNombre());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Límite Descubierto: " + getLimiteDescubierto());
    }
}