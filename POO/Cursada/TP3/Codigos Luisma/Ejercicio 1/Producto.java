

public class Producto {
    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock = 0;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio lab;
    

    
   public Producto(int codigo, String rubro, String descripcion, double costo, double porcPtoRepo, int existMinima, Laboratorio lab){
    this.setCodigo(codigo);
    this.setRubro(rubro);
    this.setDescripcion(descripcion);
    this.setCosto(costo);
    this.setPorcPtoRepo(porcPtoRepo);
    this.setExistMinima(existMinima);
    this.setLab(lab);
    this.setStock(0); 
}

public Producto(int codigo, String rubro, String descripcion, double costo, Laboratorio lab){
    this.setCodigo(codigo);
    this.setRubro(rubro);
    this.setDescripcion(descripcion);
    this.setCosto(costo);
    this.setLab(lab); 
    this.setPorcPtoRepo(15.0);
    this.setExistMinima(10);
    this.setStock(0);
}
    
    private void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    private void setRubro(String rubro){
        this.rubro = rubro;
    }
    
    private void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    private void setCosto(double costo){
        this.costo = costo;
    }
    
    private void setLab(Laboratorio lab){
        this.lab = lab;
    }
    
    private void setPorcPtoRepo(double porcPtoRepo){
    this.porcPtoRepo = porcPtoRepo;
}

private void setExistMinima(int existMinima){
    this.existMinima = existMinima;
}

private void setStock(int stock){
    this.stock = stock;
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
    public double getporcPtoRepo(){
        return this.porcPtoRepo;
    }
    public int getExistMinima (){
        return this.existMinima;
    }
    public Laboratorio getLab(){
        return this.lab;
    }
    public void ajuste(int cantidad){
        this.stock += cantidad;
    }
    
    public double precioLista(){
        return this.costo * 1.12;
    }
    
    public double precioContado(){
        return this.precioLista() - (this.precioLista() * 0.05);
    }
    
    public double stockValorizado(){
        return this.stock * this.precioLista();
    }
    
    public void ajustarPtoRepo(double porcPtoRepo){
        this.porcPtoRepo = porcPtoRepo;
    }
    
    public void ajustarExistMin(int cantidad){
        this.existMinima = cantidad;
    }
    public void mostrar(){
        this.lab.mostrar();
        System.out.println("Rubro: "+ this.getRubro());
        System.out.println("Descripcion: "+ this.getDescripcion());
        System.out.println("Precio costo: "+ this.getCosto());
        System.out.println("Stock: "+ this.getStock() + " - Stock Valorizado: $" + this.stockValorizado());
        
    }
    
    public String mostrarLinea() {
    return this.descripcion + " " + this.precioLista() + " " + this.precioContado();
    }
}