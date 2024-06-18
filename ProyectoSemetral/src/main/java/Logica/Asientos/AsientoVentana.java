package Logica.Asientos;

public class AsientoVentana extends AsientoDecorador {

    public AsientoVentana(ModeloAsiento silla){
        super(silla);
    }    

    @Override
    public int getPrecio() {
        return asiento.getPrecio() + 500;
    }
}
