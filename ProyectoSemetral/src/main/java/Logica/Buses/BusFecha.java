package Logica.Buses;

/**
 * es el decorador segun la fecha de salida del bus, donde se define que el bus sale segun la fecha dada en el constructor
 * y se le añade un precio, para q si el pasaje se compra para días posteriores, entonces es mas barato
 */
public class BusFecha extends BusDecorador{
    
    private String fechaselect;
    private int precioextra;
    public BusFecha(ModeloBus busforma, String fecha, int precio){
        super(busforma);
        fechaselect = fecha;
        precioextra = precio;
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas el precio q se pasa en el constructor
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + precioextra;
    }

    /**
     * hace override y cambia la definición del bus sale el día indicado
     */
    @Override
    public String toString(){
        return "Fecha Viaje: "+ fechaselect + ";\n" + buslaillier.toString();
    }
}
