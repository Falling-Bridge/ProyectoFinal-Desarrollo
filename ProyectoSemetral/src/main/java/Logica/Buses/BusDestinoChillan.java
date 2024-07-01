package Logica.Buses;

/**
 * es el primer segundo segun el destino del bus, donde se define que el bus se dirige a Chillan
 */
public class BusDestinoChillan extends BusDecorador {

    public BusDestinoChillan(ModeloBus busforma){
        super(busforma);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 8000 pesos
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 8000;
    }

    /**
     * hace override y cambia la definición del busva camino a santiago
     */
    @Override
    public String toString(){
        return " Destino: Chillan; " + buslaillier.toString();
    }
}