/**
 * Representa a un hombre con sus datos personales, estado civil y relación de matrimonio con una Mujer.
 * 
 * @author Gabi
 * @version 1.0
 */
public class Hombre {

    /** Nombre del hombre. */
    private String nombre;
    /** Apellido del hombre. */
    private String apellido;
    /** Edad en años del hombre. */
    private int edad;
    /** Estado civil actual (Soltero, Casado, Divorciado). */
    private String estadoCivil;
    /** Esposa actual si está casado, o null si no lo está. */
    private Mujer esposa;

    /**
     * Constructor que inicializa al hombre como soltero.
     * 
     * @param p_nombre nombre del hombre
     * @param p_apellido apellido del hombre
     * @param p_edad edad del hombre
     */
    public Hombre(String p_nombre, String p_apellido, int p_edad) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltero");
    }

    /**
     * Constructor que inicializa al hombre casado con una esposa.
     * 
     * @param p_nombre nombre del hombre
     * @param p_apellido apellido del hombre
     * @param p_edad edad del hombre
     * @param p_esposa objeto Mujer que es su esposa
     */
    public Hombre(String p_nombre, String p_apellido, int p_edad, Mujer p_esposa) {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltero");
        if (p_esposa != null) {
            this.casarseCon(p_esposa);
        }
    }

    /**
     * Asigna el apellido del hombre.
     * 
     * @param p_apellido apellido a asignar
     */
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }
    
    /**
     * Asigna la edad del hombre.
     * 
     * @param p_edad edad a asignar
     */
    private void setEdad(int p_edad) {
        this.edad = p_edad;
    }

    /**
     * Asigna el estado civil del hombre.
     * 
     * @param p_estadoCivil estado civil a asignar
     */
    private void setEstadoCivil(String p_estadoCivil) {
        this.estadoCivil = p_estadoCivil;
    }
    
    /**
     * Asigna el nombre del hombre.
     * 
     * @param p_nombre nombre a asignar
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /**
     * Asigna la esposa del hombre.
     * 
     * @param p_esposa esposa a asignar
     */
    private void setEsposa(Mujer p_esposa) {
        this.esposa = p_esposa;
    }

    /**
     * Obtiene el apellido del hombre.
     * 
     * @return apellido del hombre
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * Obtiene la edad del hombre.
     * 
     * @return edad del hombre
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Obtiene el estado civil del hombre.
     * 
     * @return estado civil
     */
    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    /**
     * Obtiene el nombre del hombre.
     * 
     * @return nombre del hombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la esposa del hombre.
     * 
     * @return objeto Mujer correspondiente a la esposa, o null
     */
    public Mujer getEsposa() {
        return this.esposa;
    }

    /**
     * Contrae matrimonio con la mujer indicada, actualizando el estado civil a "Casado"
     * y actualizando automáticamente el estado civil de la mujer a "Casada".
     * No permite el matrimonio si alguno de los dos ya está casado con otra persona.
     * 
     * @param p_mujer mujer con la que se casa
     */
    public void casarseCon(Mujer p_mujer) {
        if (p_mujer == null) {
            System.out.println("No se puede contraer matrimonio: la persona no existe.");
            return;
        }

        // Si ya están casados entre sí, no hace falta volver a ejecutar
        if (this.getEsposa() == p_mujer && p_mujer.getEsposo() == this) {
            return;
        }

        // Verificación de si el hombre ya está casado con otra persona
        if (("Casado".equalsIgnoreCase(this.getEstadoCivil()) || this.getEsposa() != null) && this.getEsposa() != p_mujer) {
            System.out.println("No se puede realizar el matrimonio: " + this.getNombre() + " " + this.getApellido() + " ya está casado.");
            return;
        }

        // Verificación de si la mujer ya está casada con otra persona
        if (("Casada".equalsIgnoreCase(p_mujer.getEstadoCivil()) || p_mujer.getEsposo() != null) && p_mujer.getEsposo() != this) {
            System.out.println("No se puede realizar el matrimonio: " + p_mujer.getNombre() + " " + p_mujer.getApellido() + " ya está casada.");
            return;
        }

        this.setEsposa(p_mujer);
        this.setEstadoCivil("Casado");

        // Se sincroniza el matrimonio en el objeto par (Mujer)
        if (p_mujer.getEsposo() != this) {
            p_mujer.casarseCon(this);
        }
    }

    /**
     * Muestra por consola la información de matrimonio del hombre con su esposa.
     */
    public void casadoCon() {
        if (this.getEsposa() != null) {
            System.out.println(this.datos() + " está casado con " + this.getEsposa().datos());
        } else {
            System.out.println(this.datos() + " no está casado.");
        }
    }

    /**
     * Retorna una cadena con nombre, apellido y edad del hombre.
     * 
     * @return cadena con el formato "Nombre Apellido de X años"
     */
    public String datos() {
        return this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años";
    }

    /**
     * Muestra por pantalla los datos del hombre junto con su estado civil.
     */
    public void mostrarEstadoCivil() {
        System.out.println(this.datos() + " - " + this.getEstadoCivil());
    }

    /**
     * Realiza el divorcio, cambiando el estado civil a "Divorciado", desvinculando a la esposa,
     * y actualizando automáticamente el estado de la esposa a "Divorciada".
     */
    public void divorcio() {
        if (this.getEsposa() != null) {
            Mujer exEsposa = this.getEsposa();
            this.setEsposa(null);
            this.setEstadoCivil("Divorciado");
            if (exEsposa.getEsposo() == this) {
                exEsposa.divorcio();
            }
        } else if ("Casado".equalsIgnoreCase(this.getEstadoCivil())) {
            this.setEstadoCivil("Divorciado");
        } else if ("Soltero".equalsIgnoreCase(this.getEstadoCivil())) {
            System.out.println(this.getNombre() + " es soltero/a, no puede divorciarse.");
        }
    }

}
