public class laboratorio{
    
    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima;
    private int diaEntrega;

    public laboratorio(String domicilio, String telefono, int compraMinima, int diaEntrega){

        setDomicilio(domicilio);
        setTelefono(telefono);
        setCompraMinima(compraMinima);
        setDiaEntrega(diaEntrega);

    }

    public laboratorio(String nombre, String domicilio, String telefono){
        setNombre(nombre);
        setDomicilio(domicilio);
        setTelefono(telefono);
    }

    public void nuevaCompraMinima(int compraMinima){
        this.compraMinima = compraMinima;

    }
    
    public void nuevoDiaEntrega(int diaEntrega){
        this.diaEntrega = diaEntrega;

    }

    public void mostrar(){

        System.out.println("Laboratorio: " + getNombre());
        System.out.println("Domicilio: " + getDomicilio() + " Telefono: " + getTelefono());

    }

    private void setNombre(String nombre){

        this.nombre = nombre;
    }

    private void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }

    private void setTelefono(String telefono){
        this.telefono = telefono;
    }

    private void setCompraMinima(int compraMinima){
        this.compraMinima = compraMinima;
    }

    private void setDiaEntrega(int diaEntrega){
        this.diaEntrega = diaEntrega;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDomicilio(){
        return domicilio;
    }

    public String getTelefono(){
        return telefono;
    }

    public int getCompraMinima(){
        return compraMinima;
    }
    
    public int getDiaEntrega(){
        return diaEntrega;
    }

}

