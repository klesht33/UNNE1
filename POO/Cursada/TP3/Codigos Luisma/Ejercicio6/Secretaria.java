import java.util.Scanner;


public class Secretaria{
    public static void main(String [] args){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre del docente: ");
        
        String nombre = teclado.nextLine();
        
        System.out.println("Ingrese grado: ");
        
        String grado = teclado.nextLine();
        
        System.out.println("Ingrese el sueldo basico: ");
        
        double sueldoBasico = teclado.nextDouble();
        
        System.out.println("Ingrese asignacion familiar: ");
        
        double asignacionFamiliar = teclado.nextDouble();

        teclado.nextLine();
        
        Docente d1 = new Docente (nombre, grado, sueldoBasico, asignacionFamiliar);
        
        System.out.println("Ingrese nombre de la escuela: ");
        
        String nombreEscuela = teclado.nextLine();
        
        System.out.println("Ingrese domicilio: ");
        
        String domicilio = teclado.nextLine();
        
        System.out.println("Ingrese nombre del director: ");
        
        String director = teclado.nextLine();
        
        Escuela escuela1 = new Escuela (nombreEscuela, domicilio, director);
        
        escuela1.imprimirRecibo(d1);
    }
}