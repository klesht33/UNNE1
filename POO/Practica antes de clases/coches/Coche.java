package coches;

public class Coche {
    //atributos
    String color;
    String marca;
    int km;

    //Metodo
    public static void main(String[] args) {
        Coche auto1 = new Coche();
        auto1.color = "rojo";
        auto1.marca = "fiat";
        auto1.km = 10;

        System.out.println("el color del primer auto es: "+auto1.color);
        System.out.println("La marca del auto 1 es: " +auto1.marca);
        System.out.println("el kilometraje del auto 1 es: "+auto1.km);

        Coche auto2 = new Coche();

        auto2.color = "azul";
        auto2.marca = "ford";
        auto2.km = 200;

         System.out.println("\nel color del segundo auto es: "+auto2.color);
        System.out.println("La marca del auto 2 es: " +auto2.marca);
        System.out.println("el kilometraje del auto 2 es: "+auto2.km);

    }
}
