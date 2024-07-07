package Logica.Buses;

/**
 * es el segundo decorador segun el tipo de pasaje, donde se define que el pasaje es de ida y vuelta
 */
public class BusIdaYVuelta extends BusDecorador {

    public BusIdaYVuelta(ModeloBus busforma) throws Exception{
        super(busforma);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 2500 pesos
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 2500;
    }

    /**
     * hace override y cambia la definición del bus, señalando que el pasaje es solo de ida y vuelta
     */
    @Override
    public String toString(){
        return "Pasaje de ida y vuelta;\n"  + buslaillier.toString();
    }
}