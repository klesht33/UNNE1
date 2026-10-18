import java.util.ArrayList;

public class Jardin {
    private String nombre;
    private ArrayList<FiguraGeometrica> figuras;

    public Jardin(String p_nombre) {
        this.nombre = p_nombre;
        this.figuras = new ArrayList<>();
    }

    public boolean agregarFigura(FiguraGeometrica p_figura) {
        return this.figuras.add(p_figura);
    }

    public boolean quitarFigura(FiguraGeometrica p_figura) {
        return this.figuras.remove(p_figura);
    }

    /**
     * Calcula la superficie total a cubrir sumando la superficie de todas las figuras.
     */
    public double cuantosMetros() {
        double totalMetros = 0.0;
        for (FiguraGeometrica figura : this.figuras) {
            totalMetros += figura.superficie();
        }
        return totalMetros;
    }

    /**
     * Sabiendo que 4 litros cubren 20 m2, calcula cuántos litros se necesitan[cite: 6].
     * (4 litros / 20 m2 = 0.2 litros por m2).
     */
    private double cuantosLitros() {
        return this.cuantosMetros() * 0.2; // o (cuantosMetros() * 4) / 20
    }

    /**
     * Calcula la cantidad de latas de 4 litros necesarias.
     * Usa Math.ceil() para redondear hacia arriba si sobra pintura.
     */
    public int cuantasLatas() {
        // Dividimos los litros necesarios por 4 (capacidad de la lata)
        return (int) Math.ceil(this.cuantosLitros() / 4.0);
    }

    /**
     * Emite el listado de las figuras a pintar, el total a cubrir y las latas a comprar[cite: 6].
     */
    public void detalleFiguras() {
        System.out.println("Presupuesto: " + this.nombre);
        
        // Gracias al polimorfismo, mostrarSuperficie() ejecutará el método de la figura específica[cite: 6]
        for (FiguraGeometrica figura : this.figuras) {
            figura.mostrarSuperficie();
        }
        
        // Se formatea a 2 decimales para que coincida con la salida esperada del TP
        System.out.printf("Total a cubrir: %.2f%n", this.cuantosMetros());
        System.out.println("Comprar " + this.cuantasLatas() + " latas");
    }
}