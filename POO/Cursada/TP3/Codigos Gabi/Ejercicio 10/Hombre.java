public class Hombre {

    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private Mujer esposa;

    public Hombre(String p_nombre, String p_apellido, int p_edad) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltero");
    }

    public Hombre(String p_nombre, String p_apellido, int p_edad, Mujer p_esposa) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Casado");
        this.setEsposa(p_esposa);
    }

    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }
    
    private void setEdad(int p_edad) {
        this.edad = p_edad;
    }

    private void setEstadoCivil(String p_estadoCivil) {
        this.estadoCivil = p_estadoCivil;
    }
    
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setEsposa(Mujer p_esposa) {
        this.esposa = p_esposa;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Mujer getEsposa() {
        return this.esposa;
    }

    public void casarseCon(Mujer p_mujer) {
        this.setEsposa(p_mujer);
        this.setEstadoCivil("Casado");
    }

    public void casadoCon() {
        System.out.println(this.datos() + " está casado con " + this.getEsposa().datos());
    }

    public String datos() {
        return this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años";
    }

    public void mostrarEstadoCivil() {
        System.out.println(this.datos() + " - " + this.getEstadoCivil());
    }

    public void divorcio() {
        this.setEstadoCivil("Divorciado");
        this.setEsposa(null); 
    }

}
