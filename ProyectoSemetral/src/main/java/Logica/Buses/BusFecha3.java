package Logica.Buses;

public class BusFecha3 extends BusDecorador{
    
    private String fechaselect;
    public BusFecha3(ModeloBus busforma, String fecha){
        super(busforma);
        fechaselect = fecha;
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 500 pesos
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 500;
    }

    /**
     * hace override y cambia la definición del bus sale en el día indicado
     */
    @Override
    public String toString(){
        return " Fecha Viaje: "+ fechaselect + ";" + buslaillier.toString();
    }
}
