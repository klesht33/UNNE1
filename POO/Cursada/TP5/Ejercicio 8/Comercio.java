import java.util.Locale;

/**
 * Clase ejecutable para verificar el funcionamiento de las clases
 * ArtefactoHogar,
 * Cocina, Heladera y Lavarropas según la consigna del Trabajo Práctico 5
 * Ejercicio 8.
 * 
 * Instancia varios artefactos que ofrece el comercio y simula consultas de
 * clientes
 * para diferentes situaciones, variando la cantidad de cuotas y el interés
 * aplicado.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Comercio {

    /**
     * Simula la consulta de un cliente para un artefacto determinado, mostrando
     * sus datos, el detalle de la financiación (cuotas e interés) y los importes
     * de la cuota base y de la cuota con adicionales según las reglas de cada
     * artefacto.
     * 
     * @param p_artefacto artefacto sobre el que se consulta
     * @param p_cuotas    cantidad de cuotas pactadas
     * @param p_interes   tasa de interés porcentual por cuota
     */
    public static void simularCredito(ArtefactoHogar p_artefacto, int p_cuotas, float p_interes) {
        p_artefacto.imprimir();
        System.out.printf(Locale.US, "Cuotas: %d  - Interes: %.2f%%%n", p_cuotas, p_interes);
        System.out.printf(Locale.US, "Valor Cuota: %.2f%n", p_artefacto.cuotaCredito(p_cuotas, p_interes));
        System.out.printf(Locale.US, "Valor Cuota Con Adicionales: %.2f%n%n",
                p_artefacto.creditoConAdicional(p_cuotas, p_interes));
    }

    public static void main(String[] args) {
        // Se instancian los artefactos ofrecidos por el comercio:
        // 1. Cocina (valores de prueba de la consigna)
        Cocina cocina = new Cocina("Volcan", 600.0f, 15, 4, 2000, "80*60*60cm");

        // 2. Heladera con compresor (valores de prueba de la consigna)
        Heladera heladera = new Heladera("Gafa", 1200.0f, 8, 11, 2, true);

        // 3. Lavarropas no automático (aplica 2% de descuento por cada cuota)
        Lavarropas lavarropasSemi = new Lavarropas("Drean", 1000.0f, 5, 15, 6.5f, false);

        // 4. Lavarropas automático
        Lavarropas lavarropasAuto = new Lavarropas("Whirlpool", 1500.0f, 4, 20, 8.0f, true);

        // Simulación de consultas de clientes variando cuotas e interés:

        // Consulta 1: Cocina a 6 cuotas al 2.53% (Caso del enunciado)
        simularCredito(cocina, 6, 2.53f);

        // Consulta 2: Heladera a 6 cuotas al 2.53% (Caso del enunciado: suma $50 por
        // compresor)
        simularCredito(heladera, 6, 2.53f);

        // Consulta 3: Lavarropas no automático a 12 cuotas al 3.0% (Descuenta 2% por no
        // ser automático)
        simularCredito(lavarropasSemi, 12, 3.0f);

        // Consulta 4: Lavarropas automático a 6 cuotas al 2.53%
        simularCredito(lavarropasAuto, 6, 2.53f);
    }
}
