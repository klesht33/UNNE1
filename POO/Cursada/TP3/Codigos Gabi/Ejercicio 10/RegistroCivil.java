import java.util.Scanner;

public class RegistroCivil {

    public static void main(String[] args) {

        Scanner unScann = new Scanner(System.in);

        String nombreHombre = unScann.nextLine();
        String apellidoHombre = unScann.nextLine();
        int edadHombre = unScann.nextInt();
        String nombreMujer = unScann.nextLine();
        String apellidoMujer = unScann.nextLine();
        int edadMujer = unScann.nextInt();

        Hombre unHombre = new Hombre(nombreHombre, apellidoHombre, edadHombre);
        Mujer unaMujer = new Mujer(nombreMujer, apellidoMujer, edadMujer);

        unHombre.casarseCon(unaMujer);
        unaMujer.casarseCon(unHombre);
        unHombre.casadoCon();
        unaMujer.casadaCon();
        unHombre.mostrarEstadoCivil();
        unaMujer.mostrarEstadoCivil();

        unHombre.divorcio();
        unaMujer.divorcio();
        unHombre.mostrarEstadoCivil();
        unaMujer.mostrarEstadoCivil();

        unScann.close();
    }

}
