public class Circulo {
    private double radio;
    private punto centro;
    
    public Circulo(double pRadio, punto pCentro){
        this.setRadio(pRadio);
        this.setCentro(pCentro);
    }
    
    public Circulo(){
        this.radio = 0;
        this.centro = new punto (0, 0);
    }
    
    private void setRadio(double pRadio){   
        this.radio = pRadio;

    }
    
    private void setCentro(punto pCentro){
        this.centro = pCentro;
    }
    
    public double getRadio(){
        return radio;
    }
    
    public punto getCentro(){
        return centro;
    }
    
    public void desplazar(double pdx, double pdy){
        this.centro.desplazar(pdx, pdy);
    }
    
    public double perimetro(){
        return 2 * Math.PI * getRadio();
    }
    
    public double superficie (){
        return Math.PI * getRadio() * getRadio();
    }
    
    public double distanciaA(Circulo otroCirculo){
        return this.centro.distanciaA(otroCirculo.getCentro());
    }
    
    public Circulo elMayor(Circulo otroCirculo){
        if(this.superficie() > otroCirculo.superficie()){
            return this;
        }
            else {
                return otroCirculo;
            }
    }
    
      public void caracteristicas() {
        System.out.println("****** Circulo ******");
        System.out.println("Centro: " + centro.coordenadas() + " - Radio: " + radio);
        System.out.println("Superficie: " + superficie() +  " - Perimetro: " + perimetro());
    }
}