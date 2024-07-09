package Logica.Asientos;

/**
 * es el segundo decorador segun la pocición del asiento, donde se define que está en la ventana
 */
public class AsientoVentana extends AsientoDecorador {

    public AsientoVentana(ModeloAsiento silla){
        super(silla);
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 500 pesos
     */
    @Override
    public int getPrecio() {
        return asiento.getPrecio() + 500;
    }

    /**
     * se hace override al metodo de la clase ModeloAsiento, y se añade es q está ubicado en la ventana
     * @return el toString original mas q está en la ventana
     */
    @Override
    public String toString(){
        return asiento.toString() + "; Lugar: ventana";
    }
}