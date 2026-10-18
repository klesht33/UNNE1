public class Exclusivo extends Cargo {

    private int horasDeInvestigacion;
    private int horasDeExtension;

    public Exclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDeDocencia,
            int p_horasDeInvestigacion, int p_horasDeExtension) {

        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, p_horasDeDocencia);
        this.setHorasDeInvestigacion(p_horasDeInvestigacion);
        this.setHorasDeExtension(p_horasDeExtension);
    }

    private void setHorasDeExtension(int horasDeExtension) {
        this.horasDeExtension = horasDeExtension;
    }

    private void setHorasDeInvestigacion(int horasDeInvestigacion) {
        this.horasDeInvestigacion = horasDeInvestigacion;
    }

    public int getHorasDeExtension() {
        return horasDeExtension;
    }

    public int getHorasDeInvestigacion() {
        return horasDeInvestigacion;
    }

    public void mostrarCargo() {

        super.mostrarCargo();
        System.out.println("----Cargo de caracter Exclusivo----");
        System.out.println("Horas de investigacion: " + this.getHorasDeInvestigacion());
        System.out.println("HOras de extension: " + this.getHorasDeExtension());
    }

}
