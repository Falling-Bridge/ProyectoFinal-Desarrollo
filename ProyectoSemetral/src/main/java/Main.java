import Logica.Boleto;
import Logica.Buses.*;
import Logica.Excepciones.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        try {
            ModeloBus Bus = new Bus();
            Bus = new BusLasGalaxias(Bus);
            Boleto boleto = new Boleto();
            boleto.realizarCompra(Bus, 11);
            boleto.getInfoBoleto();
        }
        catch (ComparDenuevoException e){
            System.out.println(e.getMessage());
        }

    }
}