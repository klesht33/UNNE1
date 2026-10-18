/**
 * Representa un triángulo geométrico definido por su base, altura y punto de origen.
 */
public class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Triangulo(Punto p_origen, double p_base, double p_altura) {
        super(p_origen);
        this.base = Math.max(0.0, p_base);
        this.altura = Math.max(0.0, p_altura);
    }

    @Override
    public String nombreFigura() {
        return "****** Triangulo ******";
    }

    @Override
    public double superficie() {
        // Área del triángulo: (base * altura) / 2
        return (this.base * this.altura) / 2.0;
    }
}