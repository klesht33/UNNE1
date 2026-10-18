public class EtiquetAR {
    public static void main(String[] args) {
        Pedido miPedido = new Pedido();

        // Item 1: 7 Premium, costo base 200, 10 colores[cite: 10]
        Etiqueta etiqueta1 = new Premium(200.0, 10);
        Renglon renglon1 = new Renglon(7, etiqueta1);

        // Item 2: 57 Común, costo base 100, plus de diseño 100[cite: 10]
        // Se asume costo base de 100 según el enunciado ("Las etiquetas comunes tienen hoy un costo de $100")[cite: 10].
        Etiqueta etiqueta2 = new Comun(100.0, 100.0); 
        Renglon renglon2 = new Renglon(57, etiqueta2);

        // Item 3: 94 Premium, costo base 200, 7 colores[cite: 10]
        Etiqueta etiqueta3 = new Premium(200.0, 7);
        Renglon renglon3 = new Renglon(94, etiqueta3);

        miPedido.agregarRenglon(renglon1);
        miPedido.agregarRenglon(renglon2);
        miPedido.agregarRenglon(renglon3);

        // Muestra el resultado final
        miPedido.mostrar();
    }
}