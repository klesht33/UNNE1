import javax.swing.JOptionPane;


public class GestionStock {
    public static void main(String[] args){
        Laboratorio colgate = new Laboratorio("Colgate S.A.", "Scalabrini Ortiz 5524", "54-11 -4239-8447");
        
        Producto jabon = new Producto(1, "Perfumería", "Jabón Deluxe", 5.25, colgate);
        
        jabon.ajuste(500);
        
        jabon.mostrar();
        
        System.out.println("\nPara lista: " + jabon.mostrarLinea());
    }
}