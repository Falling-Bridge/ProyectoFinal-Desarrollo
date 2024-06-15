package Logica.Asientos;

import Logica.TipoAsiento;
import Logica.TipoBus;

//esta clase es la base de mi decorador, a fin de cuentas sería como la interfaz, 
//ya q despues los asientos van a ir implementado los metodos de este y las otras tipos de asientos
public abstract class ModeloAsiento {
    protected int Numero;
    protected TipoAsiento asientotipo;
    protected int precio = 0;
    protected String marca;
    protected boolean comprado;
    
    public ModeloAsiento(int numero, TipoBus bus, TipoAsiento asiento){
        Numero = numero;
        asientotipo = asiento;
        precio = bus.getPrecio() + asiento.getPrecio()*(bus.getPrecio()/2000);
        comprado = false;
    }

    public void comprar(){
        comprado = true;
    }
    public boolean getComprado(){
        return comprado;
    }
    public int getPrecio() {
        return precio;
    }
}
