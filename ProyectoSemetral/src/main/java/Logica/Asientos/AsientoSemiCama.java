package Logica.Asientos;

public class AsientoSemiCama extends AsientoDecorador{
    
    public AsientoSemiCama(ModeloAsiento silla){
        super(silla);
    }

    @Override
    public int getPrecio() {
        return asiento.precio + 2000;
    }

    @Override
    public String toString(){
        return asiento.toString() + ", Asiento SemiCama";
    }
}
