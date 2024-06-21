package Logica.Asientos;

/**
 * es el primer decorador segun el tipo de asiento, donde se define que es de tipo SemiCama
 */
public class AsientoSemiCama extends AsientoDecorador{
    
    public AsientoSemiCama(ModeloAsiento silla){
        super(silla);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 2000 pesos
     */
    @Override
    public int getPrecio() {
        return asiento.precio + 2000;
    }

    /**
     * se hace override al metodo de la clase ModeloAsiento, y se añade es q es tipo SemiCama
     * @return el toString original mas q es tipo SemiCama
     */
    @Override
    public String toString(){
        return asiento.toString() + "; Modelo: SemiCama";
    }
}
