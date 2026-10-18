public class CajaDeAhorro extends CuentaBancaria {
    private int extraccionesPosibles;

    public CajaDeAhorro(int p_nroCuenta, Persona p_titular) {
        super(p_nroCuenta, p_titular);
        this.extraccionesPosibles = 0;
    }

    public CajaDeAhorro(int p_nroCuenta, Persona p_titular, double p_saldo) {
        super(p_nroCuenta, p_titular, p_saldo);
        this.extraccionesPosibles = 0;
    }

    public int getExtraccionesPosibles() { return this.extraccionesPosibles; }
    private void setExtraccionesPosibles(int p_extracciones) { this.extraccionesPosibles = p_extracciones; }

    @Override
    protected boolean puedeExtraer(double p_importe) {
        return (getSaldo() >= p_importe) && (this.extraccionesPosibles > 0);
    }

    @Override
    public boolean extraer(double p_importe) {
        if (puedeExtraer(p_importe)) {
            setSaldo(getSaldo() - p_importe);
            this.extraccionesPosibles--;
            return true;
        }
        return false;
    }

    @Override
    public String xQNoPuedeExtraer(double p_importe) {
        if (this.extraccionesPosibles <= 0) {
            return "No tiene extracciones posibles habilitadas.";
        } else if (getSaldo() < p_importe) {
            return "Saldo insuficiente.";
        }
        return "Puede extraer.";
    }

    @Override
    public void mostrar() {
        System.out.println("Caja de Ahorro Nro: " + getNroCuenta());
        System.out.println("Titular: " + getTitular().getNombre());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Extracciones Posibles: " + getExtraccionesPosibles());
    }
}