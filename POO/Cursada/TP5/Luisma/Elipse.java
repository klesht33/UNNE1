public class Elipse extends FiguraGeometrica {
    private double sEjeMayor;
    private double sEjeMenor;

    public Elipse(double p_sEjeMayor, double p_sEjeMenor, Punto p_centro) {
        // El "centro" de la elipse se guardará en el "origen" de la superclase
        super(p_centro); 
        this.setSEjeMayor(p_sEjeMayor);
        this.setSEjeMenor(p_sEjeMenor);
    }

    private void setSEjeMayor(double p_sEjeMayor) {
        this.sEjeMayor = Math.max(0.0, p_sEjeMayor);
    }

    private void setSEjeMenor(double p_sEjeMenor) {
        this.sEjeMenor = Math.max(0.0, p_sEjeMenor);
    }

    public double getSEjeMayor() { return this.sEjeMayor; }
    public double getSEjeMenor() { return this.sEjeMenor; }
    
    // Método de conveniencia para mantener compatibilidad con tu código anterior
    public Punto getCentro() { return this.getOrigen(); }

    @Override
    public String nombreFigura() {
        return "****** Elipse ******";
    }

    @Override
    public double superficie() {
        return Math.PI * this.getSEjeMayor() * this.getSEjeMenor();
    }

    public void desplazar(double p_dx, double p_dy) {
        this.getOrigen().desplazar(p_dx, p_dy);
    }

    public double distanciaA(Elipse otraElipse) {
        if (otraElipse == null || otraElipse.getCentro() == null || this.getCentro() == null) {
            return 0.0;
        }
        return this.getCentro().distanciaA(otraElipse.getCentro());
    }

    public Elipse elMayor(Elipse otraElipse) {
        if (otraElipse == null) return this;
        return (this.superficie() >= otraElipse.superficie()) ? this : otraElipse;
    }

    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        String coord = this.getCentro().coordenadas();
        System.out.println("Centro: " + coord + " - Semieje Mayor: " + this.getSEjeMayor() + " - Semieje Menor: " + this.getSEjeMenor());
        System.out.println("Superficie: " + this.superficie());
    }
}