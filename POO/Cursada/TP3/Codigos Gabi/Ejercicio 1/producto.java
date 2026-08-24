import javax.swing.JOptionPane;

public class producto {

    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio laboratorio;

    public producto(int p_codigo, String p_rubro, String p_descripcion, double p_costo, int p_stock, double p_porcPtoRepo){ 
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_descripcion);
        this.setCosto(p_costo);
        this.setStock(p_stock);
        this.setPorcPtoRepo(p_porcPtoRepo);
    }

    public producto(int p_codigo, String p_descripcion, double p_costo, Laboratorio p_laboratorio, int p_existMinima, String p_rubro){
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_descripcion);
        this.setCosto(p_costo);
        this.setLaboratorio(p_laboratorio);
        this.setExistenciaMinima(p_existMinima);
    }

    private void setCodigo(int p_codigo){
        this.codigo = p_codigo;
    }

    private void setRubro(String p_rubro){
        this.rubro = p_rubro;
    }

    private void setDescripcion(String p_descripcion){
        this.descripcion = p_descripcion;
    }

    private void setCosto(double p_costo){
        this.costo = p_costo;
    }

    private void setStock(int p_stock){
        this.stock = p_stock;
    }

    private void setPorcPtoRepo(double p_porcPtoRepo){
        this.porcPtoRepo = p_porcPtoRepo;
    }

    private void setExistenciaMinima(int p_existMinima){
        this.existMinima = p_existMinima;
    }

    private void setLaboratorio(Laboratorio p_laboratorio){
        this.laboratorio = p_laboratorio;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getRubro(){
        return this.rubro;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public double getCosto(){
        return this.costo;
    }

    public int getStock(){
        return this.stock;
    }

    public double getPorcPtoRepo(){
        return this.porcPtoRepo;
    }

    public int getExistenciaMinima(){
        return this.existMinima;
    }

    public Laboratorio getLaboratorio(){
        return this.laboratorio;
    }

    public void mostrar(){

        laboratorio.mostrar();
        System.out.println("Rubro: " + getRubro());
        System.out.println("Descripcion: " + getDescripcion());
        System.out.println("Precio Costo: " + getCosto());
        System.out.println("Stock: " + getStock() + " - Stock valorizado: $ " + stockValorizado());
    }
    
    public void ajuste(int p_cantidad){

        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Que desea hacer?: \n 1: Agregar Stock \n 0: Quitar Stock"));

        switch (opcion) {
            case 1:
                setStock(getStock() + p_cantidad);
                break;
        
            default:
                setStock(getStock() - p_cantidad);
                break;
        }

        System.out.println("Stock: " + getStock());
    }

    public double stockValorizado(){
        return getStock() * getCosto();
    }

    public double precioLista(){
        return getCosto() * 1.12;
    }

    public double precioContado(){
        return (precioLista() - (precioLista() * 0.05));
    }

    public String mostrarLinea(){
        return getDescripcion() + " " + String.format("%.2f", precioLista()) + " " + String.format("%.2f", precioContado()); 
    }

    public void ajustarPtoRepo(double p_porcPtoRepo){
        this.porcPtoRepo = p_porcPtoRepo;
    }
    
    public void ajustarExistMin(int p_cantidad){
        this.existMinima = p_cantidad;
    }

}
