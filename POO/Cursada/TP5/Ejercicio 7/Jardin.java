import java.util.ArrayList;
import java.util.Locale;

/**
 * Representa un jardín de niños que desea pintar figuras geométricas en el piso,
 * calculando la superficie total a cubrir, los litros de pintura necesarios y la cantidad
 * de latas a comprar (sabiendo que una lata de 4 litros cubre 20 m²).
 * 
 * @author Gabi
 * @version 1.0
 */
public class Jardin {

    /** Nombre del jardín. */
    private String nombre;

    /** Colección de figuras geométricas que se pintarán en el piso del jardín. */
    private ArrayList<FiguraGeometrica> figuras;

    /**
     * Constructor que inicializa el jardín con su nombre y una colección vacía de figuras.
     * 
     * @param p_nombre nombre del jardín
     */
    public Jardin(String p_nombre) {
        this.setNombre(p_nombre);
        this.setFiguras(new ArrayList<FiguraGeometrica>());
    }

    /**
     * Constructor que inicializa el jardín con su nombre y una colección dada de figuras geométricas.
     * 
     * @param p_nombre  nombre del jardín
     * @param p_figuras lista de figuras geométricas inicial
     */
    public Jardin(String p_nombre, ArrayList<FiguraGeometrica> p_figuras) {
        this.setNombre(p_nombre);
        this.setFiguras(p_figuras != null ? p_figuras : new ArrayList<FiguraGeometrica>());
    }

    /**
     * Asigna el nombre del jardín.
     * 
     * @param p_nombre nombre a asignar
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /**
     * Asigna la colección de figuras geométricas del jardín.
     * 
     * @param p_figuras lista de figuras geométricas a asignar
     */
    private void setFiguras(ArrayList<FiguraGeometrica> p_figuras) {
        this.figuras = p_figuras;
    }

    /**
     * Obtiene el nombre del jardín.
     * 
     * @return nombre del jardín
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la colección de figuras geométricas del jardín.
     * 
     * @return lista de figuras geométricas
     */
    public ArrayList<FiguraGeometrica> getFiguras() {
        return this.figuras;
    }

    /**
     * Calcula la superficie total a cubrir sumando la superficie de todas las figuras
     * geométricas que pertenecen al jardín.
     * 
     * @return total de metros cuadrados a pintar
     */
    public double cuantosMetros() {
        double totalMetros = 0.0;
        for (FiguraGeometrica unaFigura : this.getFiguras()) {
            totalMetros += unaFigura.superficie();
        }
        return totalMetros;
    }

    /**
     * Calcula la cantidad total de litros de pintura requeridos para cubrir la superficie total,
     * considerando que 4 litros cubren 20 m² (0.2 litros por cada metro cuadrado).
     * 
     * @return cantidad de litros de pintura requeridos
     */
    private double cuantosLitros() {
        return (this.cuantosMetros() * 4.0) / 20.0;
    }

    /**
     * Calcula la cantidad entera de latas de pintura a comprar (de 4 litros cada una),
     * redondeando hacia arriba para garantizar la cobertura de toda la superficie.
     * 
     * @return cantidad de latas de pintura a comprar
     */
    public int cuantasLatas() {
        return (int) Math.ceil(this.cuantosLitros() / 4.0);
    }

    /**
     * Emite un listado de todas las figuras que pintará el jardín mostrando la superficie
     * de cada una mediante polimorfismo, e incluye el total de metros cuadrados a cubrir
     * y la cantidad de latas de pintura necesarias para comprar.
     */
    public void detalleFiguras() {
        System.out.println("Presupuesto: " + this.getNombre() + "\n");
        for (FiguraGeometrica unaFigura : this.getFiguras()) {
            unaFigura.mostrarSuperficie();
        }
        System.out.println("----------------------------------");
        System.out.printf(Locale.US, "Total a cubrir: %.2f%n", this.cuantosMetros());
        System.out.println("Comprar " + this.cuantasLatas() + " latas");
    }
}
