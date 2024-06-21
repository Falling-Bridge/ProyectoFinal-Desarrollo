package Logica;

import Logica.Asientos.ModeloAsiento;
import Logica.Buses.ModeloBus;

/**
 * es la clase donde se guardan los datos de la compra
 */
public class Boleto {
    private ModeloBus buslaitllier;
    private ModeloAsiento asiento;
    private int precio;
    /** el constructor no hace nada pq no hace falta xd*/
    public Boleto(){
    }

    /**
     * metodo para poder comprar los asientos, pr
     * @param bus el bus q despues se guarda para obtener los datos, y se llama al metodo para comprar
     * @param numero el numero del asiento
     */
    public void realizarCompra(ModeloBus bus, int numero){
        buslaitllier = bus;
        asiento = bus.ComprarAsiento(numero-1);/** se llama al numero -1, ya q los valores del arreglo parten desde 0 */
        precio = bus.getPrecio() + asiento.getPrecio(); /** se calcula el precio */
    }

    /**
     * entrega info del bus, el asiento y el precio total del pasaje
     */
    public void getInfoBoleto(){
        System.out.println("Bus: " + buslaitllier.toString() + "Busprecio: "+ buslaitllier.getPrecio() + " " + asiento.toString() + "; Asientoprecio: " + asiento.getPrecio() + "; Precio: " + precio);
    }
}