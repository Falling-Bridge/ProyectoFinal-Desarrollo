package Logica.Asientos;

public class AsientoSemiCama extends AsientoDecorador{
    
    public AsientoSemiCama(ModeloAsiento silla){
        super(silla);
        this.SumarPrecio();
    }

    @Override
    public void SumarPrecio() {
        asiento.precio += 2000;
    }
}
