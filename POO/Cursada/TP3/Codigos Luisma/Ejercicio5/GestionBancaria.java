public class GestionBancaria{
    public static void main(String [] args){
        Persona p1 = new Persona(46773971, "Luis Maria" , "Bonessi", 2005);
        
        CuentaBancaria c1 = new CuentaBancaria(81, p1);
        
        c1.mostrarDatos();
        
        c1.depositar(500);
        
        c1.mostrarDatos();
        
        c1.extraer(250);
        
        c1.mostrarDatos();
    }
}