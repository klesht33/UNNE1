public class CuentaBancaria {

    private int nroCuenta;
    private persona titular;
    private double saldo;

    public CuentaBancaria(int p_nroCuenta, persona p_titular){
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
    }

    public CuentaBancaria(int p_nroCuenta, persona p_titular, double p_saldo){
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public void setTitular(persona titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public persona getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double despositar(double p_importe){
        this.saldo += p_importe;
        return this.saldo;
    }

    public double extraer(double p_importe){
        if (p_importe <= this.saldo){
            this.saldo -= p_importe;
            return this.saldo;
        }else{
            System.out.println("Saldo insuficiente");
            return this.saldo;
        }
    }

    public void mostrar(){
        System.out.println("- Cuenta Bancaria -");
        System.out.println("Titular: " + this.titular.getNombre() + " ( " + this.titular.edad() + " )");
        System.out.println("Saldo: " + this.saldo);
    }

    public String toString(){
        return this.nroCuenta + " - " + this.titular.nomYAp() + " - " + this.saldo;
    }
}
