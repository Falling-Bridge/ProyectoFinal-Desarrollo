package Logica.Buses;

public class BusHoraSalida12PM extends BusDecorador{
    
    public BusHoraSalida12PM(ModeloBus busforma){
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
     * hace override y cambia la definición del bus sale a las 12 PM
     */
    @Override
    public String toString(){
        return " Hora Salida: 12:00 PM; " + buslaillier.toString();
    }
}
