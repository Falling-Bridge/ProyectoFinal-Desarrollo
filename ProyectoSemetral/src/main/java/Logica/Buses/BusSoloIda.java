package Logica.Buses;

/**
 * es el primer decorador segun el tipo de pasaje, donde se define que el pasaje es de solo ida
 */
public class BusSoloIda extends BusDecorador {

    public BusSoloIda(ModeloBus busforma){
        super(busforma);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 1000 pesos
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 1000;
    }

    /**
     * hace override y cambia la definición del bus, señalando que el pasaje es solo de ida
     */
    @Override
    public String toString(){
        return "Pasaje de solo ida;\n"  + buslaillier.toString();
    }
}