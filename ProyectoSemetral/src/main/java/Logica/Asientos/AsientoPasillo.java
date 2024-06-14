package Logica.Asientos;

public class AsientoPasillo extends AsientoDecorador {
    public AsientoPasillo(ModeloAsiento silla){
        super(silla);
        asiento = silla;
    }    
    asiento.SumarPrecio(500);
}
