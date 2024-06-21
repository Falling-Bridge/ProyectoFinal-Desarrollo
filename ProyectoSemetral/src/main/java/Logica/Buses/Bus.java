package Logica.Buses;

public class Bus extends ModeloBus {
    public Bus(){
        super();
    }
    
    @Override
    public int getPrecio(){
        return precio;
    }

    @Override
    public String toString(){
        return " Precio: " + getPrecio();
    }
}