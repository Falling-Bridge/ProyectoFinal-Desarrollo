package Logica.Asientos;

public class AsientoVIP extends AsientoDecorador{
    
    public AsientoVIP(ModeloAsiento silla){
        super(silla);
    }

    @Override
    public int getPrecio() {
        return asiento.precio + 3000;
    }
}
