package Logica;

import Logica.Asientos.ModeloAsiento;

public class Boleto {
    private Bus bus;
    private ModeloAsiento asiento;
    public Boleto(Bus buslaitllier){
        bus = buslaitllier;
    }

    public void realizarCompra(int x){
        asiento = bus.ComprarAsiento(x);
    }

    public void getInfoBoleto(){
        System.err.println("Bus: " + bus);
    }
}
