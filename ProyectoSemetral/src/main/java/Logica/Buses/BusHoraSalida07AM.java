package Logica.Buses;

/**
 * es el primer decorador segun el horariode salida del bus, donde se define que el bus sale a las 7 AM
 */
public class BusHoraSalida07AM extends BusDecorador{
    
    public BusHoraSalida07AM(ModeloBus busforma) throws Exception{
        super(busforma);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 2000 pesos
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 2000;
    }

    /**
     * hace override y cambia la definición del bus sale a las 7 AM
     */
    @Override
    public String toString(){
        return "Hora Salida: 07:00 AM;\n" + buslaillier.toString();
    }
}
