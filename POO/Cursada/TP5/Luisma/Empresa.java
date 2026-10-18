public class Empresa {
    public static void main(String[] args) {
        
        System.out.println("--- Prueba de objeto Persona ---");
        // Instanciamos una Persona sola (Nació en el 2000 para tener 26 años)[cite: 1]
        Persona persona1 = new Persona(13549867, "Dario", "Perez", 2000);
        persona1.mostrar();

        System.out.println("\n--- Prueba de objeto Empleado ---");
        // Instanciamos un Empleado. 
        // Ingresó en 2015 para tener 11 años de antigüedad. Nació en 2000[cite: 1].
        // El sueldo básico (2630.77) está calculado a ojo para que el método sueldoNeto() devuelva aprox 1236.0[cite: 1, 13].
        Empleado empleado1 = new Empleado(27135498678L, "Perez", "Dario", 2630.77, 2015, 13549867, 2000);
        
        empleado1.mostrar();
    }
}