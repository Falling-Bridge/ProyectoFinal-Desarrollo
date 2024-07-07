package Logica.Buses;

/**
 * es el primer decorador segun el destino del bus, donde se define que el bus se dirige a Santiago
 */
public class BusDestinoSntg extends BusDecorador {

    public BusDestinoSntg(ModeloBus busforma){
        super(busforma);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 10000 pesos
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 10000;
    }

    /**
     * hace override y cambia la definición del bus va camino a santiago
     */
    @Override
    public String toString(){
        return "Destino: Santiago;\n" + buslaillier.toString();
    }
}
