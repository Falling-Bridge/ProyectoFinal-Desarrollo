package Logica.Asientos;

/**
 * es el tercer decorador segun el tipo de asiento, donde se define que es de tipo Cama
 */
public class AsientoCama extends AsientoDecorador {

    public AsientoCama(ModeloAsiento silla){
        super(silla);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 1000 pesos
     */
    @Override
    public int getPrecio() {
        return asiento.precio + 1000;
    }

    /**
     * se hace override al metodo de la clase ModeloAsiento, y se añade es q es tipo Cama
     * @return el toString original mas q es tipo cama
     */
    @Override
    public String toString(){
        return asiento.toString() + "; Modelo Cama";
    }
}