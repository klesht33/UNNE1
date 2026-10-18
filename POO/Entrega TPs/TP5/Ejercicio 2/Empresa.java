
public class Empresa {

    public static void main(String[] args) {

        Persona persona = new Persona(
                25365902, "Maria", "Lopez", 1985);

        Empleado empleado = new Empleado(
                2036982345L, "Perez", "Juan",
                250000, 2020, 35365902, 1985);

        System.out.println("--- PERSONA ---");
        persona.mostrar();

        System.out.println();

        System.out.println("--- EMPLEADO ---");
        empleado.mostrar();
    }
}
