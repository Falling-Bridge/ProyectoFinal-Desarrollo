import Logica.Asientos.*;
import Logica.Boleto;
import Logica.Buses.*;
import Logica.Excepciones.*;

public class Main {
    public static void main(String[] args) throws Exception{

        ModeloAsiento silla = new Asiento(1);
        silla = new AsientoVIP(silla);
        silla = new AsientoVentana(silla);
        System.out.println(silla.toString());

    }
}