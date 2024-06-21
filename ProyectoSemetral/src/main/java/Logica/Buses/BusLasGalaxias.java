package Logica.Buses;

/**
 * es el tercerr decorador segun la marca del bus, donde se define el bus como bus marca LAS GALAXIAS,
 */
public class BusLasGalaxias extends BusDecorador{

    public BusLasGalaxias(ModeloBus busforma){
        super(busforma);
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
     * hace override y cambia la definición del bus
     * @return le añade a la descripción que el bus es de la increible mara
     * LAS GALAXIAS
     */
    @Override
    public String toString(){
        return "Marca: Las Galaxias; " + buslaillier.toString();
    }

}
