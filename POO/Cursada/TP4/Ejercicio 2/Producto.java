import javax.swing.JOptionPane;

/**
 * Representa un producto comercial con su información de costos, stock y
 * laboratorio proveedor.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Producto {

    /** Código numérico identificador del producto. */
    private int codigo;
    /** Rubro o categoría del producto. */
    private String rubro;
    /** Descripción o nombre del producto. */
    private String descripcion;
    /** Precio de costo del producto. */
    private double costo;
    /** Cantidad disponible en stock. */
    private int stock;
    /** Porcentaje de punto de reposición. */
    private double porcPtoRepo;
    /** Cantidad mínima requerida en stock. */
    private int existMinima;
    /** Laboratorio fabricante o proveedor del producto. */
    private Laboratorio laboratorio;

    /**
     * Constructor que inicializa un producto con sus datos comerciales y stock
     * inicial.
     * 
     * @param p_codigo      código identificador del producto
     * @param p_rubro       rubro o categoría del producto
     * @param p_descripcion descripción del producto
     * @param p_costo       precio de costo unitario
     * @param p_stock       cantidad inicial en stock
     * @param p_porcPtoRepo porcentaje para el punto de reposición
     */
    public Producto(int p_codigo, String p_rubro, String p_descripcion, double p_costo, int p_stock,
            double p_porcPtoRepo) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_descripcion);
        this.setCosto(p_costo);
        this.setStock(p_stock);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExistenciaMinima(0);
        this.setLaboratorio(null);
    }

    /**
     * Constructor sobrecargado que asocia un laboratorio y existencia mínima.
     * 
     * @param p_codigo      código identificador del producto
     * @param p_descripcion descripción del producto
     * @param p_costo       precio de costo unitario
     * @param p_laboratorio laboratorio que provee el producto
     * @param p_existMinima cantidad mínima de existencia permitida
     * @param p_rubro       rubro o categoría del producto
     */
    public Producto(int p_codigo, String p_descripcion, double p_costo, Laboratorio p_laboratorio, int p_existMinima,
            String p_rubro) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_descripcion);
        this.setCosto(p_costo);
        this.setLaboratorio(p_laboratorio);
        this.setExistenciaMinima(p_existMinima);
        this.setStock(0);
        this.setPorcPtoRepo(0.0);
    }

    /**
     * Asigna el código del producto.
     * 
     * @param p_codigo código a asignar
     */
    private void setCodigo(int p_codigo) {
        this.codigo = p_codigo;
    }

    /**
     * Asigna el rubro del producto.
     * 
     * @param p_rubro rubro a asignar
     */
    private void setRubro(String p_rubro) {
        this.rubro = p_rubro;
    }

    /**
     * Asigna la descripción del producto.
     * 
     * @param p_descripcion descripción a asignar
     */
    private void setDescripcion(String p_descripcion) {
        this.descripcion = p_descripcion;
    }

    /**
     * Asigna el precio de costo del producto.
     * 
     * @param p_costo costo a asignar
     */
    private void setCosto(double p_costo) {
        this.costo = p_costo;
    }

    /**
     * Asigna la cantidad en stock.
     * 
     * @param p_stock stock a asignar
     */
    private void setStock(int p_stock) {
        this.stock = p_stock;
    }

    /**
     * Asigna el porcentaje de punto de reposición.
     * 
     * @param p_porcPtoRepo porcentaje a asignar
     */
    private void setPorcPtoRepo(double p_porcPtoRepo) {
        this.porcPtoRepo = p_porcPtoRepo;
    }

    /**
     * Asigna la existencia mínima requerida.
     * 
     * @param p_existMinima existencia mínima a asignar
     */
    private void setExistenciaMinima(int p_existMinima) {
        this.existMinima = p_existMinima;
    }

    /**
     * Asigna el laboratorio proveedor.
     * 
     * @param p_laboratorio laboratorio a asignar
     */
    private void setLaboratorio(Laboratorio p_laboratorio) {
        this.laboratorio = p_laboratorio;
    }

    /**
     * Obtiene el código del producto.
     * 
     * @return código del producto
     */
    public int getCodigo() {
        return this.codigo;
    }

    /**
     * Obtiene el rubro del producto.
     * 
     * @return rubro del producto
     */
    public String getRubro() {
        return this.rubro;
    }

    /**
     * Obtiene la descripción del producto.
     * 
     * @return descripción del producto
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Obtiene el precio de costo del producto.
     * 
     * @return costo del producto
     */
    public double getCosto() {
        return this.costo;
    }

    /**
     * Obtiene la cantidad disponible en stock.
     * 
     * @return cantidad en stock
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Obtiene el porcentaje de punto de reposición.
     * 
     * @return porcentaje de punto de reposición
     */
    public double getPorcPtoRepo() {
        return this.porcPtoRepo;
    }

    /**
     * Obtiene la existencia mínima requerida.
     * 
     * @return existencia mínima
     */
    public int getExistenciaMinima() {
        return this.existMinima;
    }

    /**
     * Obtiene el laboratorio proveedor.
     * 
     * @return laboratorio asociado
     */
    public Laboratorio getLaboratorio() {
        return this.laboratorio;
    }

    /**
     * Muestra en pantalla el detalle completo del producto y su laboratorio.
     */
    public void mostrar() {
        if (this.getLaboratorio() != null) {
            this.getLaboratorio().mostrar();
        } else {
            System.out.println("Laboratorio: Sin asignar");
        }
        System.out.println("Rubro: " + getRubro());
        System.out.println("Descripcion: " + getDescripcion());
        System.out.println("Precio Costo: " + getCosto());
        System.out.println("Stock: " + getStock() + " - Stock valorizado: $ " + stockValorizado());
    }

    /**
     * Permite ajustar el stock sumando o restando una cantidad mediante diálogo
     * interactivo.
     * 
     * @param p_cantidad cantidad a modificar en el stock
     */
    public void ajuste(int p_cantidad) {
        if (p_cantidad < 0) {
            System.out.println("La cantidad a ajustar debe ser positiva.");
            return;
        }

        int opcion = Integer
                .parseInt(JOptionPane.showInputDialog("Que desea hacer?: \n 1: Agregar Stock \n 0: Quitar Stock"));

        switch (opcion) {
            case 1:
                setStock(getStock() + p_cantidad);
                break;

            default:
                if (getStock() >= p_cantidad) {
                    setStock(getStock() - p_cantidad);
                    System.out.println("Stock: " + getStock());
                } else {
                    System.out.println("No se puede descontar: el stock actual (" + getStock()
                            + ") es menor a la cantidad solicitada (" + p_cantidad + ").");
                }
                break;
        }

    }

    /**
     * Calcula el valor total del stock multiplicando la cantidad por el precio de
     * costo.
     * 
     * @return valor total del stock en pesos
     */
    public double stockValorizado() {
        return getStock() * getCosto();
    }

    /**
     * Calcula el precio de lista sumando una rentabilidad del 12% sobre el costo.
     * 
     * @return precio de lista
     */
    public double precioLista() {
        return getCosto() * 1.12;
    }

    /**
     * Calcula el precio de contado aplicando un 5% de descuento sobre el precio de
     * lista.
     * 
     * @return precio al contado
     */
    public double precioContado() {
        return (precioLista() - (precioLista() * 0.05));
    }

    /**
     * Devuelve una línea representativa con descripción, precio de lista y precio
     * contado.
     * 
     * @return cadena con la información resumida del producto
     */
    public String mostrarLinea() {
        return getDescripcion() + " " + String.format("%.2f", precioLista()) + " "
                + String.format("%.2f", precioContado());
    }

    /**
     * Modifica el porcentaje del punto de reposición.
     * 
     * @param p_porcPtoRepo nuevo porcentaje de punto de reposición
     */
    public void ajustarPtoRepo(double p_porcPtoRepo) {
        this.porcPtoRepo = p_porcPtoRepo;
    }

    /**
     * Modifica la cantidad de existencia mínima.
     * 
     * @param p_cantidad nueva cantidad de existencia mínima
     */
    public void ajustarExistMin(int p_cantidad) {
        this.existMinima = p_cantidad;
    }

}
