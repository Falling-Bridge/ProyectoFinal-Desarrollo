package Logica.Asientos;

import Logica.TipoAsiento;
import Logica.TipoBus;

//esta es la clase q se instancia, y que despues adquiere las cualidades atravez del decorador
public class Asiento extends ModeloAsiento{
    
    public Asiento(int numero, TipoBus bus, TipoAsiento asiento){
        super(numero, bus, asiento);
    }
}
