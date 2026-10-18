public class AplicacionFacultad {
    public static void main(String[] args) {
        // 1. Instanciamos la Facultad
        Facultad facena = new Facultad("FaCENA");

        // 2. Creamos al Profesor Juan Perez (Nace en 1989 para tener 37 años en 2026)
        Profesor prof1 = new Profesor(28596132, "Juan", "Perez", 1989, "Lic. en Sistemas de Información");
        // Cargos de Juan (calculando años de ingreso desde 2026 para que la antigüedad dé 10, 12 y 20)
        prof1.agregarCargo(new Cargo("JTP-Programación OO", 800.0, 2016, 10)); // Cargo Simple (10 años ant)
        prof1.agregarCargo(new Cargo("Titular-TFA", 1400.0, 2014, 20)); // Cargo Simple (12 años ant)
        prof1.agregarCargo(new SemiExclusivo("JTP-Analisis de Sistemas", 800.0, 2006, 10, 0)); // SemiExclusivo (20 años ant)
        
        facena.agregarProfesor(prof1);

        // 3. Creamos a la Profesora Mirta Lopez (Nace en 1996 para tener 30 años en 2026)
        Profesor prof2 = new Profesor(34519921, "Mirta", "Lopez", 1996, "Lic. en Sistemas de Información");
        // Cargos de Mirta (calculando años de ingreso para que la antigüedad dé 11 y 10)
        prof2.agregarCargo(new Cargo("JTP-TP-II", 1200.0, 2015, 10)); // Cargo Simple (11 años ant)
        prof2.agregarCargo(new Exclusivo("JTP-Ing.Soft", 1800.0, 2016, 10, 20, 10)); // Exclusivo (10 años ant)
        
        facena.agregarProfesor(prof2);

        // 4. Emitir el listado de profesores con cargos
        facena.listarProfesorCargos();

        System.out.println("\n-------------------------------------------------\n");

        // 5. Emitir la nómina para el pago del mes
        facena.nominaProfesores();
    }
}