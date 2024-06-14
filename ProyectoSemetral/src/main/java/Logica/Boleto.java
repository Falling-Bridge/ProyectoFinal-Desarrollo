package Logica;

public class Boleto {
    private Bus bus;
    private Asiento asiento;
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
