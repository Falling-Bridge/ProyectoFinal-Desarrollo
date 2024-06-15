package Logica.Buses;

import Logica.TipoBus;

public class Bus extends ModeloBus {
    public Bus(TipoBus bustipo){
        super(bustipo);
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