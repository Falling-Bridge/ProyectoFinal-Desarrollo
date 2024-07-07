package Logica.Buses;
/**
 * es el segundo decorador segun la marca del bus, donde se define el bus como bus marca turbus,
 */
public class BusTurbus extends BusDecorador {
    
    public BusTurbus(ModeloBus busforma){
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
     * hace override y cambia la definición del bus
     * @return le añade a la descripción que el bus es de marca TurBus
     */
    @Override
    public String toString(){
        return "Marca: TurBus;\n" + buslaillier.toString();
    }
}
