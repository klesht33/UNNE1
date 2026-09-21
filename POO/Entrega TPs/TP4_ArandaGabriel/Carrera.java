public class Carrera {

    public static void main(String args[]) {

        // 5.1.1. Crear una instancia de Curso y varias de la clase Alumno
        Curso curso = new Curso("Programación Orientada a Objetos");

        Alumno alumno1 = new Alumno(32555, "Pedro", "Gomez");
        Alumno alumno2 = new Alumno(23564, "Maria", "Vasquez");
        Alumno alumno3 = new Alumno(30123, "Juan", "Perez");
        Alumno alumno4 = new Alumno(32655, "Marcela", "Martinez");

        // 5.1.2. Asignarles notas de parciales a los alumnos
        alumno1.setNota1(6.0);
        alumno1.setNota2(7.0);

        alumno2.setNota1(5.0);
        alumno2.setNota2(6.0);

        alumno3.setNota1(7.0);
        alumno3.setNota2(9.0);

        alumno4.setNota1(8.0);
        alumno4.setNota2(8.5);

        // 5.1.3. Inscribir los alumnos al curso creado anteriormente
        curso.inscribirAlumno(alumno1);
        curso.inscribirAlumno(alumno2);
        curso.inscribirAlumno(alumno3);
        curso.inscribirAlumno(alumno4);

        // 5.1.4. Imprimir la cantidad y la lista de alumnos inscriptos al curso
        System.out.println("****-- Cantidad de inscriptos: " + curso.cantidadDeAlumnos());
        curso.mostrarInscriptos();

        // 5.1.5. Dar de baja un alumno del curso, y luego verificar que no esté
        // inscripto
        System.out.println("\n****-- Se da de baja a Pedro porque abandona el curso --****");
        curso.quitarAlumno(32555);
        System.out.println("Está Pedro Gomez inscripto ?? --> " + curso.estaInscripto(32555));

        // 5.1.6. Imprimir nuevamente la lista de alumnos y la cantidad total de alumnos
        // inscriptos
        System.out.println("\n****-- Alumnos inscriptos actualmente: " + curso.cantidadDeAlumnos());
        curso.mostrarInscriptos();

        // 5.1.7. Buscar un alumno por su libreta. Una vez encontrado, mostrarlo con el
        // método apropiado
        System.out.println("\n****-- Busca y muestra el alumno con numero de libreta 30123 --****");
        Alumno alumnoEncontrado = curso.buscarAlumno(30123);
        if (alumnoEncontrado != null) {
            alumnoEncontrado.mostrar();
        }

        // 5.1.8. Mostrar el promedio del alumno solicitado, según libreta
        System.out.println("\n****-- Mostrar promedio del alumno 23564 --****");
        curso.imprimirPromedioDelAlumno(23564);

    }

}
