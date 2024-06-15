package Logica.Asientos;

public class AsientoPasillo extends AsientoDecorador {
    public AsientoPasillo(ModeloAsiento silla){
        super(silla);
        this.SumarPrecio();
    }    
    
    @Override
    public void SumarPrecio() {
        asiento.precio += 500;
    }
}
