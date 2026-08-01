package persona;

public class clase2 {

    public static void main(String[] args) {
        clase1 objeto1 = new clase1();

        objeto1.SetEdad(89);
        System.out.println("La edad es: " + objeto1.GetEdad());

        objeto1.SetNombre("Juan");
        System.out.println("El nombre es: " + objeto1.GetNombre());

    }

}
