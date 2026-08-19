public class Articulo {
    private int codigo;
    private String titulo;
    private String area;
    private autor iniciador;

    public Articulo (int codigo, String titulo, String area, autor iniciador){
        this.setCodigo(codigo);
        this.setTitulo(titulo);
        this.setArea(area);
        this.setIniciador(iniciador);
    }
//setters
    private void setCodigo(int codigo){
        this.codigo = codigo;
    }

    private void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    private void setArea(String area){
        this.area = area;
    }

    private void setIniciador (autor iniciador){
        this.iniciador = iniciador;
    }

//getters
    public int getCodigo(){
        return this.codigo;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public String getArea(){
        return this.area;
    }
    public autor getIniciador(){
        return this.iniciador;
    }

    public void mostrarDatos(){
        System.out.println ("Articulo: "+ this.getTitulo());
        System.out.println ("Area: "+ this.getArea());

    }

}