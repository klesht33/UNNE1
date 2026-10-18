public abstract class CuentaBancaria {
    private int nroCuenta;
    private double saldo;
    private Persona titular;

    public CuentaBancaria(int p_nroCuenta, Persona p_titular) {
        this.nroCuenta = p_nroCuenta;
        this.titular = p_titular;
        this.saldo = 0.0;
    }

    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.nroCuenta = p_nroCuenta;
        this.titular = p_titular;
        this.saldo = p_saldo;
    }

    public int getNroCuenta() { return this.nroCuenta; }
    private void setNroCuenta(int p_nroCuenta) { this.nroCuenta = p_nroCuenta; }
    
    public double getSaldo() { return this.saldo; }
    protected void setSaldo(double p_saldo) { this.saldo = p_saldo; }
    
    public Persona getTitular() { return this.titular; }
    private void setTitular(Persona p_titular) { this.titular = p_titular; }

    public double depositar(double p_importe) {
        this.saldo += p_importe;
        return this.saldo;
    }

    protected abstract boolean puedeExtraer(double p_importe);
    public abstract boolean extraer(double p_importe);
    public abstract String xQNoPuedeExtraer(double p_importe);
    public abstract void mostrar();
}