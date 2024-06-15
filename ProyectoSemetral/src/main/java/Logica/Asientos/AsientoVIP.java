package Logica.Asientos;

public class AsientoVIP extends AsientoDecorador{
    
    public AsientoVIP(ModeloAsiento silla){
        super(silla);
        this.SumarPrecio();
    }

    @Override
    public void SumarPrecio() {
        asiento.precio += 3000;
    }
}
