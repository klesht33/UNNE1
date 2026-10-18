import java.util.ArrayList;

/**
 * Clase ejecutable para verificar el funcionamiento de las clases Cargo,
 * SemiExclusivo, Exclusivo, Profesor y Facultad según la consigna del
 * Trabajo Práctico 5 Ejercicio 5.
 * 
 * Funciona simplemente creando los objetos e invocando sus métodos.
 * 
 * @author Gabi
 * @version 1.0
 */
public class AplicacionFacultad {

    public static void main(String[] args) {

        Cargo cargoJuan1 = new Cargo("JTP-Programación OO", 800.0, 2010, 10);
        SemiExclusivo cargoJuan2 = new SemiExclusivo("Titular-TFA", 1400.0, 2017, 20, 0, 0);
        Cargo cargoJuan3 = new Cargo("JTP-Analisis de Sistemas", 800.0, 2014, 10);

        ArrayList<Cargo> cargosJuan = new ArrayList<Cargo>();
        cargosJuan.add(cargoJuan1);
        cargosJuan.add(cargoJuan2);
        cargosJuan.add(cargoJuan3);

        Profesor juan = new Profesor("Lic. en Sistemas de Información", 28596132, "Juan", "Perez", 1986, cargosJuan);

        Cargo cargoMirta1 = new Cargo("JTP-TP-II", 1200.0, 2011, 10);
        Exclusivo cargoMirta2 = new Exclusivo("JTP-Ing.Soft", 1800.0, 2014, 10, 20, 10);

        ArrayList<Cargo> cargosMirta = new ArrayList<Cargo>();
        cargosMirta.add(cargoMirta1);
        cargosMirta.add(cargoMirta2);

        Profesor mirta = new Profesor("Lic. en Sistemas de Información", 34519921, "Mirta", "Lopez", 1993, cargosMirta);

        ArrayList<Profesor> listaProfesores = new ArrayList<Profesor>();
        listaProfesores.add(juan);
        listaProfesores.add(mirta);

        Facultad facultad = new Facultad("FaCENA", listaProfesores);

        System.out.println("===============================================================================");
        System.out.println("              DETALLE DE PROFESORES Y CARGOS DE LA FACULTAD                   ");
        System.out.println("===============================================================================");
        facultad.listarProfesorCargos();

        System.out.println();

        System.out.println("===============================================================================");
        System.out.println("                NÓMINA DE PROFESORES (DPTO. CONTABLE)                         ");
        System.out.println("===============================================================================");
        facultad.nominaProfesores();
    }
}
