import Logica.Asientos.Asiento;
import Logica.Asientos.AsientoVIP;
import Logica.Asientos.AsientoVentana;
import Logica.Asientos.ModeloAsiento;
import Logica.Buses.Bus;
import Logica.Buses.BusDestinoSntg;
import Logica.Buses.BusEme;
import Logica.Buses.ModeloBus;

public class Main {
    public static void main(String[] args) throws Exception{
        ModeloBus bus = new Bus();
        bus = new BusEme(bus);
        bus = new BusDestinoSntg(bus);
        System.out.println(bus.toString());

    }
}