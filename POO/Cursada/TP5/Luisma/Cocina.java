public class Cocina extends ArtefactoHogar {
    private int hornallas;
    private int calorias;
    private String dimensiones;

    public Cocina(String p_marca, float p_precio, int p_stock, int p_hornallas, int p_calorias, String p_dimensiones) {
        super(p_marca, p_precio, p_stock);
        this.hornallas = p_hornallas;
        this.calorias = p_calorias;
        this.dimensiones = p_dimensiones;
    }

    @Override
    public void imprimir() {
        System.out.println("**** Cocina ****");
        super.imprimir();
        System.out.println("Hornallas: " + this.hornallas);
        System.out.println("Calorias: " + this.calorias);
        System.out.println("Dimensiones: " + this.dimensiones);
    }

    @Override
    public float creditoConAdicional(int p_cuotas, float p_interes) {
        // La cocina no tiene adicionales ni descuentos
        return this.cuotaCredito(p_cuotas, p_interes);
    }
}