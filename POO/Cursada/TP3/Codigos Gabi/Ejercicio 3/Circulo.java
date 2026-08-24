public class Circulo {
    private double radio;
    private punto centro;

    public Circulo(double p_radio, punto p_centro){
        this.setRadio(p_radio);
        this.setCentro(p_centro);
    }

    public Circulo(){
        this.radio = 0;
        this.centro = new punto (0, 0);
    }

    private setCentro(punto p_centro){
        this.centro = p_centro;
    }

    private setRadio(double p_radio){
        this.radio = p_radio;
    }
    
    public punto getCentro(){
        return this.centro;
    }

    public double getRadio(){
        return this.radio;
    }

    public void desplazar(double p_dx, double p_dy){
        centro.desplazar(p_dx, p_dy);
    }

    public void caracteristicas(){
        System.out.println("******Circulo*****");
        System.out.println("Centro: " + centro.coordenadas() + " - Radio" + getRadio());
        System.out.println("Superficie: " + superficie() + " - Perimetro: " + perimetro());
    }

    public double superficie(){
        return 2 * Math.PI * getRadio();
    }

    public double DistanciaA(Circulo otroCirculo){
        return otroCirculo.DistanciaA(otroCirculo.getCentro());
    }

      public Circulo elMayor(Circulo otroCirculo){
        if(this.superficie() > otroCirculo.superficie()){
            return this;
        }
            else {
                return otroCirculo;
            }
    }

     public double perimetro(){
        return 2 * Math.PI * getRadio();
    }



    
}
