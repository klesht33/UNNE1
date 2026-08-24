public class gestionStock {

    public static void main (String[] args){

        Laboratorio p0 = new Laboratorio("Colgate", "Junin", "379523489");
        producto p2 = new producto(123, "Sombra", 100, p0, 100, "Cosmetica");
        p2.ajuste(500);
        p2.mostrar();
        p2.ajuste(200);
        System.out.println(""+ p2.mostrarLinea());
    
    }
    
}
