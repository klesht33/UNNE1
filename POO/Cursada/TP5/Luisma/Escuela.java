public class Escuela {
    public static void main(String[] args) {
        
        System.out.println("--- Prueba de objeto Persona ---");
        // Instanciamos una Persona (Nacida en 1985 para que tenga 41 años)[cite: 1, 12]
        Persona persona1 = new Persona(25365902, "Maria", "Lopez", 1985);
        persona1.mostrar();

        System.out.println("\n--- Prueba de objeto Alumno ---");
        // Instanciamos un Alumno (Nacido en 2007 para que tenga 19 años)[cite: 1, 12]
        Alumno alumno1 = new Alumno(28325402, "Luis", "Gomez", 2007, 2345, 5.0, 9.0);
        alumno1.mostrar();
    }
}