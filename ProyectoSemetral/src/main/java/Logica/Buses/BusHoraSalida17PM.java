package Logica.Buses;

/**
 * es el tercer decorador segun el horariode salida del bus, donde se define que el bus sale a las 17 PM
 */
public class BusHoraSalida17PM extends BusDecorador{
    
    public BusHoraSalida17PM(ModeloBus busforma){
        super(busforma);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 3000 pesos
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 3000;
    }

    /**
     * hace override y cambia la definición del bus sale a las 17 PM
     */
    @Override
    public String toString(){
        return "Hora Salida: 17:00 PM;\n" + buslaillier.toString();
    }
}
