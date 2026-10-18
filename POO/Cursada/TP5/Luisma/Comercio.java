public class Comercio {
    public static void main(String[] args) {
        // Instanciar los artefactos ofrecidos por el comercio[cite: 7]
        Cocina cocina = new Cocina("Volcan", 600.0f, 15, 4, 2000, "80*60*60cm");
        Heladera heladera = new Heladera("Gafa", 1200.0f, 8, 11, 2, true);
        
        // Simulación para la Cocina
        cocina.imprimir();
        System.out.println("Cuotas: 6 Interes: 2.53%");
        System.out.printf("Valor Cuota: %.2f\n", cocina.cuotaCredito(6, 2.53f));
        System.out.printf("Valor Cuota Con Adicionales: %.2f\n", cocina.creditoConAdicional(6, 2.53f));
        
        System.out.println(); // Salto de línea
        
        // Simulación para la Heladera
        heladera.imprimir();
        System.out.println("Cuotas: 6 Interes: 2.53%");
        System.out.printf("Valor Cuota: %.2f\n", heladera.cuotaCredito(6, 2.53f));
        System.out.printf("Valor Cuota Con Adicionales: %.2f\n", heladera.creditoConAdicional(6, 2.53f));
    }
}