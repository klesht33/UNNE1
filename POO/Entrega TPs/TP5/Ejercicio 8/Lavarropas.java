public class Lavarropas extends ArtefactoHogar {

    private int programas;
    private float kilos;
    private boolean automatico;

    public Lavarropas(String p_marca, float p_precio, int p_stock, int p_programas, float p_kilos, boolean p_automatico) {
        super(p_marca, p_precio, p_stock);
        this.setProgramas(p_programas);
        this.setKilos(p_kilos);
        this.setAutomatico(p_automatico);
    }

    private void setProgramas(int p_programas) {
        this.programas = p_programas;
    }

    private void setKilos(float p_kilos) {
        this.kilos = p_kilos;
    }

    private void setAutomatico(boolean p_automatico) {
        this.automatico = p_automatico;
    }

    public int getProgramas() {
        return this.programas;
    }

    public float getKilos() {
        return this.kilos;
    }

    public boolean getAutomatico() {
        return this.automatico;
    }

    public void imprimir() {
        System.out.println("**** Lavarropas ****");
        super.imprimir();
        System.out.println("Programas: " + this.getProgramas());
        System.out.println("Kilos: " + this.getKilos());
        System.out.println("Automatico: " + (this.getAutomatico() ? "Si" : "No"));
    }

    public float creditoConAdicional(int p_cuotas, float p_interes) {
        if (this.getAutomatico()) {
            return super.cuotaCredito(p_cuotas, p_interes);
        } else {
            return super.cuotaCredito(p_cuotas, p_interes) - (super.cuotaCredito(p_cuotas, p_interes) * 0.02f);
        }
    }
}
