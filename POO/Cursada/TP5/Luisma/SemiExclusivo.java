public class SemiExclusivo extends Cargo {
    private int horasDeInvestigacion;

    public SemiExclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDocencia, int p_horasInv) {
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, p_horasDocencia);
        this.horasDeInvestigacion = p_horasInv;
    }

    @Override
    public void mostrarCargo() {
        super.mostrarCargo();
        System.out.println("----Cargo de caracter SemiExclusivo----");
        System.out.println("Horas investigación: " + this.horasDeInvestigacion);
    }
}