public class Rectangulo extends FiguraGeometrica {
    private double ancho;
    private double alto;

    public Rectangulo(Punto pOrigen, double pAncho, double pAlto) {
        super(pOrigen); // Llama al constructor de FiguraGeometrica
        this.setAncho(pAncho);
        this.setAlto(pAlto);
    }

    public Rectangulo(double pAncho, double pAlto) {
        super(new Punto(0, 0));
        this.setAncho(pAncho);
        this.setAlto(pAlto);
    }

    public void setAncho(double pAncho) {
        this.ancho = Math.max(0.0, pAncho);
    }

    public void setAlto(double pAlto) {
        this.alto = Math.max(0.0, pAlto);
    }

    public double getAncho() { return this.ancho; }
    public double getAlto() { return this.alto; }

    public void desplazar(double pDx, double pDy) {
        this.getOrigen().desplazar(pDx, pDy);
    }

    public double perimetro() {
        return 2 * getAncho() + 2 * getAlto();
    }

    @Override
    public double superficie() {
        return getAncho() * getAlto();
    }

    public double distanciaA(Rectangulo pOtroRectangulo) {
        if (pOtroRectangulo == null || pOtroRectangulo.getOrigen() == null || this.getOrigen() == null) {
            return 0.0;
        }
        return this.getOrigen().distanciaA(pOtroRectangulo.getOrigen());
    }

    public Rectangulo elMayor(Rectangulo pOtroRectangulo) {
        if (pOtroRectangulo == null) return this;
        return (this.superficie() >= pOtroRectangulo.superficie()) ? this : pOtroRectangulo;
    }

    @Override
    public String nombreFigura() {
        return "****** Rectangulo ******";
    }

    public void caracteristicas() {
        System.out.println(this.nombreFigura());
        String coord = this.getOrigen().coordenadas();
        System.out.println("Origen: " + coord + " - Alto: " + getAlto() + " - Ancho: " + getAncho());
        System.out.println("Superficie: " + superficie() + " - Perimetro: " + perimetro());
    }
}