/**
 * Representa un laboratorio con sus datos de contacto y condiciones de compra.
 *
 * @version 1.0
 */
public class laboratorio{
    
    /** Nombre del laboratorio. */
    private String nombre;
    /** Domicilio del laboratorio. */
    private String domicilio;
    /** Teléfono de contacto del laboratorio. */
    private String telefono;
    /** Importe mínimo requerido para realizar una compra. */
    private int compraMinima;
    /** Día programado para la entrega. */
    private int diaEntrega;

    /**
     * Crea un laboratorio con sus condiciones comerciales y datos de contacto.
     *
     * @param domicilio domicilio del laboratorio
     * @param telefono teléfono de contacto del laboratorio
     * @param compraMinima importe mínimo de compra
     * @param diaEntrega día programado para la entrega
     */
    public laboratorio(String domicilio, String telefono, int compraMinima, int diaEntrega){

        setDomicilio(domicilio);
        setTelefono(telefono);
        setCompraMinima(compraMinima);
        setDiaEntrega(diaEntrega);

    }

    /**
     * Crea un laboratorio con su nombre y datos de contacto.
     *
     * @param nombre nombre del laboratorio
     * @param domicilio domicilio del laboratorio
     * @param telefono teléfono de contacto del laboratorio
     */
    public laboratorio(String nombre, String domicilio, String telefono){
        setNombre(nombre);
        setDomicilio(domicilio);
        setTelefono(telefono);
    }

    /**
     * Actualiza el importe mínimo de compra.
     *
     * @param compraMinima nuevo importe mínimo de compra
     */
    public void nuevaCompraMinima(int compraMinima){
        this.compraMinima = compraMinima;

    }
    
    /**
     * Actualiza el día programado para la entrega.
     *
     * @param diaEntrega nuevo día de entrega
     */
    public void nuevoDiaEntrega(int diaEntrega){
        this.diaEntrega = diaEntrega;

    }

    /**
     * Muestra por consola los datos principales del laboratorio.
     */
    public void mostrar(){

        System.out.println("Laboratorio: " + getNombre());
        System.out.println("Domicilio: " + getDomicilio() + " Telefono: " + getTelefono());

    }

    /**
     * Asigna el nombre del laboratorio.
     *
     * @param nombre nombre que se asignará
     */
    private void setNombre(String nombre){

        this.nombre = nombre;
    }

    /**
     * Asigna el domicilio del laboratorio.
     *
     * @param domicilio domicilio que se asignará
     */
    private void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }

    /**
     * Asigna el teléfono de contacto del laboratorio.
     *
     * @param telefono teléfono que se asignará
     */
    private void setTelefono(String telefono){
        this.telefono = telefono;
    }

    /**
     * Asigna el importe mínimo de compra.
     *
     * @param compraMinima importe mínimo que se asignará
     */
    private void setCompraMinima(int compraMinima){
        this.compraMinima = compraMinima;
    }

    /**
     * Asigna el día de entrega.
     *
     * @param diaEntrega día de entrega que se asignará
     */
    private void setDiaEntrega(int diaEntrega){
        this.diaEntrega = diaEntrega;
    }

    /**
     * Obtiene el nombre del laboratorio.
     *
     * @return nombre del laboratorio
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Obtiene el domicilio del laboratorio.
     *
     * @return domicilio del laboratorio
     */
    public String getDomicilio(){
        return domicilio;
    }

    /**
     * Obtiene el teléfono de contacto del laboratorio.
     *
     * @return teléfono del laboratorio
     */
    public String getTelefono(){
        return telefono;
    }

    /**
     * Obtiene el importe mínimo de compra.
     *
     * @return importe mínimo de compra
     */
    public int getCompraMinima(){
        return compraMinima;
    }
    
    /**
     * Obtiene el día programado para la entrega.
     *
     * @return día de entrega
     */
    public int getDiaEntrega(){
        return diaEntrega;
    }

}

