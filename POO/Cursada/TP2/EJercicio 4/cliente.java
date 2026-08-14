
public class cliente {

    private int nroDNI;
    private String apellido;
    private String nombre;
    private double saldo;

    public cliente(int dni, String apellido, String nombre, double importe){
        setNroDNI(dni);
        setApellido(apellido);
        setNombre(nombre);
        setSaldo(importe);
    }
    public void mostrar(){
        System.out.println("- Cliente -");
        System.out.println("Nombre y Apellido: " + getNombreYape() + " (" + getNroDNi() + ")");
        System.out.println("Saldo: " + getSaldo());
    }

    private void setNroDNI(int nroDNI){
        this.nroDNI = nroDNI;
    }

    private void setNombre(String nombre){
        this.nombre = nombre;
    }

    private void setApellido(String apellido){
        this.apellido = apellido;
    }

    private void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public int getNroDNi(){
        return nroDNI;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getNombreYape(){
        return getNombre() + "" + getApellido();
    }

    public double getSaldo(){
        return saldo;
    }

    public double agregarSaldo(double importe){
        return getSaldo() + importe;
    }

    public void nuevoSaldo(double importe){
        agregarSaldo(importe);
    }


    



    
}
