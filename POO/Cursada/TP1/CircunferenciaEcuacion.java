package Cursada.TP1;

public class CircunferenciaEcuacion {

    float perimetro;
    float radio;

    public CircunferenciaEcuacion(float radio) {
        this.radio = radio;
        this.perimetro = 2 * (float) Math.PI * radio;
    }

}
