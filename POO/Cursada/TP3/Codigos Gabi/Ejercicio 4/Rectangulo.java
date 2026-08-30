/**
 * Representa una figura geométrica rectangular definida por su punto de origen (esquina inferior izquierda), ancho y alto.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Rectangulo {

    /** Punto de origen del rectángulo. */
    private punto origen;
    /** Ancho del rectángulo. */
    private double ancho;
    /** Alto del rectángulo. */
    private double alto;

    /**
     * Constructor que inicializa el rectángulo con un punto de origen, ancho y alto.
     * 
     * @param pOrigen punto de origen del rectángulo
     * @param pAncho ancho del rectángulo
     * @param pAlto alto del rectángulo
     */
    public Rectangulo(punto pOrigen, double pAncho, double pAlto){
        this.setAncho(pAncho);
        this.setAlto(pAlto);
        this.setOrigen(pOrigen);
    }
    
    /**
     * Constructor que inicializa el rectángulo con ancho y alto, ubicando el origen por defecto.
     * 
     * @param pAncho ancho del rectángulo
     * @param pAlto alto del rectángulo
     */
    public Rectangulo(double pAncho, double pAlto){
        this.setAncho(pAncho);
        this.setAlto(pAlto);
        this.setOrigen(new punto(0, 0));
    }
    
    /**
     * Asigna el ancho del rectángulo.
     * 
     * @param pAncho ancho a asignar
     */
    public void setAncho(double pAncho){
        this.ancho = pAncho;
    }

    /**
     * Asigna el alto del rectángulo.
     * 
     * @param pAlto alto a asignar
     */
    public void setAlto(double pAlto){
        this.alto = pAlto;
    }

    /**
     * Asigna el punto de origen del rectángulo.
     * 
     * @param pOrigen punto de origen a asignar
     */
    public void setOrigen(punto pOrigen){
        this.origen = pOrigen;
    }

    /**
     * Obtiene el ancho del rectángulo.
     * 
     * @return ancho del rectángulo
     */
    public double getAncho(){
        return this.ancho; 
    }

    /**
     * Obtiene el alto del rectángulo.
     * 
     * @return alto del rectángulo
     */
    public double getAlto(){
        return this.alto;
    }

    /**
     * Obtiene el punto de origen del rectángulo.
     * 
     * @return punto de origen
     */
    public punto getOrigen(){
        return this.origen;
    }

    /**
     * Desplaza el rectángulo desplazando su punto de origen.
     * 
     * @param pDx desplazamiento en el eje X
     * @param pDy desplazamiento en el eje Y
     */
    public void desplazar(double pDx, double pDy){
        this.origen.desplazar(pDx, pDy);
    }

    /**
     * Calcula el perímetro del rectángulo.
     * 
     * @return perímetro del rectángulo
     */
    public double perimetro(){
        return 2 * getAncho() + 2 * getAlto();
    }

    /**
     * Calcula la superficie o área del rectángulo.
     * 
     * @return superficie del rectángulo
     */
    public double superficie(){
        return getAncho() * getAlto();
    }

    /**
     * Calcula la distancia entre los orígenes de este rectángulo y otro.
     * 
     * @param otroRectangulo rectángulo con el cual calcular la distancia
     * @return distancia euclídea entre los orígenes
     */
    public double distanciaA(Rectangulo otroRectangulo){
        return this.origen.distanciaA(otroRectangulo.getOrigen());
    }

    /**
     * Compara este rectángulo con otro y retorna el de mayor superficie.
     * 
     * @param otroRectangulo rectángulo a comparar
     * @return el rectángulo de mayor superficie
     */
    public Rectangulo elMayor(Rectangulo otroRectangulo){
        if(this.superficie() > otroRectangulo.superficie()){
            return this;
        }
        else{
            return otroRectangulo;
        }
    }

    /**
     * Muestra por consola las características completas del rectángulo.
     */
    public void mostrarDatos(){
        System.out.println("***Rectangulo***");
        System.out.println("Origen: "+ origen.coordenadas() + " - Alto: " + getAlto() + " - Ancho: " + getAncho());
        System.out.println("Superficie: "+ superficie() + " - Perimetro: "+ perimetro() );
    }
}
