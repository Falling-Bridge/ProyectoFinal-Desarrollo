package Logica.Buses;


public class Bus extends ModeloBus {
    public Bus(){
    }
    
    @Override
    public int getPrecio(){
        return precio;
    }

    @Override
    public String getDescription(){
        return "Precio: " + getPrecio();
    }
}