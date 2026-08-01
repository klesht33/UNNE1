package calculadora;

public class operacion {

    // metodos

    //metodo para sumar
    public int sumar(int num1, int num2){
        int suma = num1 + num2;
        return suma;
    }

    //metodo para restar

    public int restar(int num1, int num2){
        int resta = num1 - num2;
        return resta;
    }

    //metodo multiplicar

    public int multiplicar(int num1, int num2){
        int multiplicacion = num1 * num2;
        return multiplicacion;
    }

    //metodo para dividir
    public float dividir(int num1, int num2){
        float division = (float)num1 / num2;
        return division;
    }

}
