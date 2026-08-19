import javax.swing.JOptionPane;

public class autor{
    private String nombre;
    private String institucion;
    private String mail;

    public autor(String nombre, String institucion, String mail){

        setNombre(nombre);
        setInstitucion(institucion);
        setMail(mail);

    }

    private void setNombre(String nombre){
        this.nombre = nombre;

    }

    private void setInstitucion(String institucion){
        this.institucion = institucion;
    }

    private void setMail(String mail){
        this.mail = mail;
    }

    public String getNombre(){
        return nombre;
    }

    public String getInstitucion(){
        return institucion;
    }

    public String getMail(){
        return mail;
    }

    public void mostrar(){
        System.out.println("Autor: " + getNombre());
        System.out.println("Institucion: " + getInstitucion());
        System.out.println("Mail: " + getMail());
    }

    public static autor ingresarAutor(){
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del autor:");
        String institucion = JOptionPane.showInputDialog("Ingrese el nombre de la institucion:");
        String mail = JOptionPane.showInputDialog("Ingrese el mail del usuario: ");

        return new autor(nombre, institucion, mail);
    }
}
