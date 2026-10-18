public class Cocina extends ArtefactoHogar {

    private int hornallas;
    private int calorias;
    private String dimensiones;

    public Cocina(String p_marca, float p_precio, int p_stock, int p_hornallas, int p_calorias, String p_dimensiones) {
        super(p_marca, p_precio, p_stock);
        this.setHornallas(p_hornallas);
        this.setCalorias(p_calorias);
        this.setDimensiones(p_dimensiones);
    }

    public Cocina(int p_hornallas, int p_calorias, String p_dimensiones, String p_marca, float p_precio, int p_stock) {
        super(p_marca, p_precio, p_stock);
        this.setHornallas(p_hornallas);
        this.setCalorias(p_calorias);
        this.setDimensiones(p_dimensiones);
    }

    private void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    private void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    private void setHornallas(int hornallas) {
        this.hornallas = hornallas;
    }

    public int getCalorias() {
        return calorias;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public int getHornallas() {
        return hornallas;
    }

    public void imprimir() {
        System.out.println("**** Cocina ****");
        super.imprimir();
        System.out.println("Hornallas: " + getHornallas());
        System.out.println("Calorias: " + getCalorias());
        System.out.println("Dimensiones: " + getDimensiones() + (getDimensiones().endsWith("cm") ? "" : "cm"));
    }

    public float creditoConAdicional(int p_cuotas, float p_interes) {
        return super.cuotaCredito(p_cuotas, p_interes);
    }

}
