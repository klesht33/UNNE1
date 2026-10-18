public class Exclusivo extends Cargo {
    private int horasDeInvestigacion;
    private int horasDeExtension;

    public Exclusivo(String p_nombreCargo, double p_sueldoBasico, int p_anioIngreso, int p_horasDocencia, int p_horasInv, int p_horasExt) {
        super(p_nombreCargo, p_sueldoBasico, p_anioIngreso, p_horasDocencia);
        this.horasDeInvestigacion = p_horasInv;
        this.horasDeExtension = p_horasExt;
    }

    @Override
    public void mostrarCargo() {
        super.mostrarCargo();
        System.out.println("----Cargo de caracter Exclusivo----");
        System.out.println("Horas investigación: " + this.horasDeInvestigacion);
        System.out.println("Horas extension: " + this.horasDeExtension);
    }
}