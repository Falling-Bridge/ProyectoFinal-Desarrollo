package Logica.Buses;

public class BusFecha1 extends BusDecorador{
    
    private String fechaselect;
    public BusFecha1(ModeloBus busforma, String fecha){
        super(busforma);
        fechaselect = fecha;
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 1500 pesos
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 1500;
    }

    /**
     * hace override y cambia la definición del bus sale el día indicado
     */
    @Override
    public String toString(){
        return " Fecha Viaje: "+ fechaselect + ";" + buslaillier.toString();
    }
}
