public class Heladera extends ArtefactoHogar {
    private int pies;
    private int puertas;
    private boolean compresor;

    public Heladera(String p_marca, float p_precio, int p_stock, int p_pies, int p_puertas, boolean p_compresor) {
        super(p_marca, p_precio, p_stock);
        this.pies = p_pies;
        this.puertas = p_puertas;
        this.compresor = p_compresor;
    }

    @Override
    public void imprimir() {
        System.out.println("**** Heladera ****");
        super.imprimir();
        System.out.println("Pies: " + this.pies);
        System.out.println("Puertas: " + this.puertas);
        System.out.println("Compresor: " + (this.compresor ? "Si" : "No"));
    }

    @Override
    public float creditoConAdicional(int p_cuotas, float p_interes) {
        float cuotaBase = this.cuotaCredito(p_cuotas, p_interes);
        if (this.compresor) {
            cuotaBase += 50.0f; // Adicional de $50 por el compresor
        }
        return cuotaBase;
    }
}