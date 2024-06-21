package Logica.Asientos;

/**
 * es el primer decorador segun la pocición del asiento, donde se define que está en el pasillo
 */
public class AsientoPasillo extends AsientoDecorador {
    
    public AsientoPasillo(ModeloAsiento silla){
        super(silla);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 500 pesos
     */
    @Override
    public int getPrecio() {
        return asiento.precio + 500;
    }

    /**
     * se hace override al metodo de la clase ModeloAsiento, y se añade es q está ubicado en el pasillo
     * @return el toString original mas q está en el pasillo
     */
    @Override
    public String toString(){
        return asiento.toString() + "; Lugar: pasillo";
    }
}
