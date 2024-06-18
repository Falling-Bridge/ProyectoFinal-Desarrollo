package Logica.Asientos;

public class AsientoVIP extends AsientoDecorador{
    
    public AsientoVIP(ModeloAsiento silla){
        super(silla);
    }

    @Override
    public int getPrecio() {
        return asiento.precio + 3000;
    }

    @Override
    public String getDescription(){
        return asiento.getDescription() + ", Asiento VIP";
    }
}
