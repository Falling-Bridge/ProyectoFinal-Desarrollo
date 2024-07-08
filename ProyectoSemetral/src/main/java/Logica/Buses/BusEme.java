package Logica.Buses;

/**
 * es el primer decorador segun la marca del bus, donde se define el bus como bus marca eme,
 */
public class BusEme extends BusDecorador {
    
    public BusEme(ModeloBus busforma) throws Exception{
        super(busforma);
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
     * hace override y cambia la definición del bus
     * @return le añade a la descripción que el bus es de marca EME
     */
    @Override
    public String toString(){
        return "Marca: EME;\n" + buslaillier.toString();
    }
}
