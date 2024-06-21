package Logica.Asientos;

/**
 * es el segundo decorador segun el tipo de asiento, donde se define que es de tipo VIP
 */
public class AsientoVIP extends AsientoDecorador{
    
    public AsientoVIP(ModeloAsiento silla){
        super(silla);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 3000 pesos
     */
    @Override
    public int getPrecio() {
        return asiento.precio + 3000;
    }

    /**
     * se hace override al metodo de la clase ModeloAsiento, y se añade es q es tipo VIP
     * @return el toString original mas q es tipo VIP
     */
    @Override
    public String toString(){
        return asiento.toString() + "; Modelo: VIP";
    }
}
