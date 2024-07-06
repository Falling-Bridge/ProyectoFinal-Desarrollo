import Logica.Boleto;
import Logica.Buses.*;
import Logica.Excepciones.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        ModeloBus Bus = new Bus();
        Bus = new BusLasGalaxias(Bus);
        try {
            Bus = new Bus1Piso(Bus);
        }
        catch (ComparDenuevoException e){
            System.out.println(e.getMessage());
        }
        Boleto boleto = new Boleto();

        boleto.realizarCompra(Bus, 11);
        boleto.getInfoBoleto();
    }
}