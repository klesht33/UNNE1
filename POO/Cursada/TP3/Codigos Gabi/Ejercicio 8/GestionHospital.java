import javax.swing.JOptionPane;

public class GestionHospital {

    public static void main(String[] args) {

        String nombreLocalidad = JOptionPane.showInputDialog("Ingrese el nombre de la localidad de nacimiento: ");
        String nombreProvincia = JOptionPane.showInputDialog("Ingrese el nombre de la provincia: ");
        String nombreLocalidadVive = JOptionPane.showInputDialog("Ingrese el nombre de la localidad donde vive: ");
        Localidad localidad = new Localidad(nombreLocalidad, nombreProvincia, nombreLocalidadVive);

        String nombreHospital = JOptionPane.showInputDialog("Ingrese el nombre del hospital: ");
        String nombreDirector = JOptionPane.showInputDialog("Ingrese el nombre del director: ");
        Hospital hospital = new Hospital(nombreHospital, nombreDirector);

        String nombrePaciente = JOptionPane.showInputDialog("Ingrese el nombre del paciente: ");
        String domicilio = JOptionPane.showInputDialog("Ingrese el domicilio del paciente: ");
        int historiaClinica = Integer
                .parseInt(JOptionPane.showInputDialog("Ingrese el numero de historia clinica del paciente: "));
        Paciente paciente = new Paciente(historiaClinica, nombrePaciente, domicilio, localidad, localidad);

        hospital.consultaDatosFilatorios(paciente);
        System.out.println(paciente.cadenaDeDatos());
    }

}
