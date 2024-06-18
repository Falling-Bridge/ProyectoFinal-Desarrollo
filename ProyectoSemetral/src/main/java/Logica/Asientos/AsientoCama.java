package Logica.Asientos;

public class AsientoCama extends AsientoDecorador {

    public AsientoCama(ModeloAsiento silla){
        super(silla);
    }

    @Override
    public int getPrecio() {
        return asiento.precio + 1000;
    }

    @Override
    public String getDescription(){
        return asiento.getDescription() + ", Asiento Cama";
    }
}
