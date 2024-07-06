package Logica.Buses;

public class BusFecha2 extends BusDecorador{
    
    private String fechaselect;
    public BusFecha2(ModeloBus busforma, String fecha){
        super(busforma);
        fechaselect = fecha;
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
     * hace override y cambia la definición del bus sale el día indicado
     */
    @Override
    public String toString(){
        return " Fecha Viaje: "+ fechaselect + ";" + buslaillier.toString();
    }
}
