public class Lavarropas extends ArtefactoHogar {
    private int programas;
    private float kilos;
    private boolean automatico;

    public Lavarropas(String p_marca, float p_precio, int p_stock, int p_programas, float p_kilos, boolean p_automatico) {
        super(p_marca, p_precio, p_stock);
        this.programas = p_programas;
        this.kilos = p_kilos;
        this.automatico = p_automatico;
    }

    @Override
    public void imprimir() {
        System.out.println("**** Lavarropas ****");
        super.imprimir();
        System.out.println("Programas: " + this.programas);
        System.out.println("Kilos: " + this.kilos);
        System.out.println("Automatico: " + (this.automatico ? "Si" : "No"));
    }

    @Override
    public float creditoConAdicional(int p_cuotas, float p_interes) {
        float cuotaBase = this.cuotaCredito(p_cuotas, p_interes);
        if (!this.automatico) {
            cuotaBase -= (cuotaBase * 0.02f); // Descuento del 2%[cite: 7]
        }
        return cuotaBase;
    }
}