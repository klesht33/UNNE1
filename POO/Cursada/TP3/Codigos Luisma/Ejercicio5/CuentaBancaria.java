

public class CuentaBancaria{
    private int nroCuenta;
    private double saldo;
    private Persona titular;
    
    public CuentaBancaria(int pNroCuenta, Persona pTitular){
        setNroCuenta(pNroCuenta);
        setTitular(pTitular);
    }
    
    public CuentaBancaria(int pNroCuenta, Persona pTitular, double pSaldo){
        setNroCuenta(pNroCuenta);
        setSaldo(pSaldo);
        setTitular(pTitular);
    }
    
    private void setNroCuenta(int pNroCuenta){
        this.nroCuenta = pNroCuenta;
    }
    
    private void setSaldo(double pSaldo){
        this.saldo = pSaldo;
    }
    
    private void setTitular(Persona pTitular){
        this.titular = pTitular;
    }
    
    public int getNroCuenta(){
        return this.nroCuenta;
    }
    
    public double getSaldo(){
        return this.saldo;
    }

    public Persona getTitular(){
        return this.titular;
    }
    
    public double depositar(double pImporte){
        return this.saldo += pImporte;
    }
    
    public double extraer(double pImporte){
        return this.saldo -= pImporte;
    }
    
    public void mostrarDatos(){
        System.out.println("-Cuenta Bancaria-");
        System.out.println("Titular: "+ titular.nomYAp()  + "(" + titular.edad() + " anios)");
        System.out.println("Saldo: "+ getSaldo());
    }
    
    public String toString(){
        return getNroCuenta() + " " + titular.nomYAp() + " " + getSaldo();
    }
}