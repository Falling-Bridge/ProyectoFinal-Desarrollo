package Logica;

import Logica.Asientos.ModeloAsiento;
import Logica.Buses.ModeloBus;

public class Boleto {
    private ModeloBus bus;
    private ModeloAsiento asiento;
    public Boleto(ModeloBus buslaitllier){
        bus = buslaitllier;
    }

    public void realizarCompra(int x){
        asiento = bus.ComprarAsiento(x);
    }

    public void getInfoBoleto(){
        System.err.println("Bus: " + bus);
    }
}