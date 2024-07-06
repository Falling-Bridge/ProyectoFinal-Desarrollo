package Logica.Buses;

/**
 * es el tercer decorador segun el destino del bus, donde se define que el bus se dirige a Talca
 */
public class BusDestinoTalca extends BusDecorador {

    public BusDestinoTalca(ModeloBus busforma){
        super(busforma);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 6000 pesos
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 6000;
    }

    /**
     * hace override y cambia la definición del busva camino a santiago
     */
    @Override
    public String toString(){
        return " Destino: Talca; " + buslaillier.toString();
    }
}