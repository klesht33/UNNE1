public class Rectangulo {

    private punto origen;
    private double ancho;
    private double alto;

    public Rectangulo(punto pOrigen, double pAncho, double pAlto){
        this.setAncho(pAncho);
        this.setAlto(pAlto);
        this.setOrigen(pOrigen);
    }
    
    public Rectangulo(double pAncho, double pAlto){
        this.setAncho(pAncho);
        this.setAlto(pAlto);
    }
    
    public void setAncho(double pAncho){
        this.ancho = pAncho;
    }

    public void setAlto(double pAlto){
        this.alto = pAlto;
    }

    public void setOrigen(punto pOrigen){
        this.origen = pOrigen;
    }

    public double getAncho(){
        return this.ancho; 
    }

    public double getAlto(){
        return this.alto;
    }

    public punto getOrigen(){
        return this.origen;
    }

    public void desplazar(double pDx, double pDy){
        this.origen.desplazar(pDx, pDy);
    }

    public double perimetro(){
        return 2 * getAncho() + 2 * getAlto();
    }

    public double superficie(){
        return getAncho() * getAlto();
    }

    public double distanciaA(Rectangulo otroRectangulo){
        return this.origen.distanciaA(otroRectangulo.origen);
    }

    public Rectangulo elMayor(Rectangulo otroRectangulo){
        if(this.superficie() > otroRectangulo.superficie()){
            return this;
        }
        else{
            return otroRectangulo;
        }
    }

    public void mostrarDatos(){
        System.out.println("***Rectangulo***");
        System.out.println("Origen: "+ origen.coordenadas() + "- Alto" + getAlto() + "-Ancho" + getAncho());
        System.out.println("Superficie: "+ superficie() + "-Perimetro: "+ perimetro() );
    }
}
