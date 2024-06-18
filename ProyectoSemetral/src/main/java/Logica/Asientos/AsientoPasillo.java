package Logica.Asientos;

public class AsientoPasillo extends AsientoDecorador {
    
    public AsientoPasillo(ModeloAsiento silla){
        super(silla);
    }    
    
    @Override
    public int getPrecio() {
        return asiento.precio + 500;
    }

    @Override
    public String toString(){
        return asiento.toString() + ", Asiento pasillo";
    }
}
