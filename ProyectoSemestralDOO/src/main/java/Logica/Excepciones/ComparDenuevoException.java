package Logica.Excepciones;

public class ComparDenuevoException extends Exception{
    public ComparDenuevoException(){
        super("Al asiento ya a sido comprado, intente con otro");
    }
}
