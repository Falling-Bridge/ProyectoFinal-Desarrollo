import Logica.Boleto;
import Logica.Buses.*;
public class Main {
    public static void main(String[] args) {
        
        ModeloBus Bus = new Bus();
        Bus = new BusLasGalaxias(Bus);
        Bus = new Bus1Piso(Bus);
        Boleto boleto = new Boleto();

        boleto.realizarCompra(Bus, 11);
        boleto.getInfoBoleto();
    }
}