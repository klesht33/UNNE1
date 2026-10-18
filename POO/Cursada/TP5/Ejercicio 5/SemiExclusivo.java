public class SemiExclusivo extends Cargo {
    private int horasDeInvestigacion;

    public SemiExclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDeDocencia,
            int p_horasDeInvestigacion, int p_horasDeExtension) {

        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, p_horasDeDocencia);
        this.setHorasDeInvestigacion(p_horasDeInvestigacion);
    }

    private void setHorasDeInvestigacion(int horasDeInvestigacion) {
        this.horasDeInvestigacion = horasDeInvestigacion;
    }

    public int getHorasDeInvestigacion() {
        return horasDeInvestigacion;
    }

    public void mostrarCargo() {

        super.mostrarCargo();
        System.out.println("----Cargo de caracter SemiExclusivo----");
        System.out.println("Horas de investigacion: " + this.getHorasDeInvestigacion());

    }

}
