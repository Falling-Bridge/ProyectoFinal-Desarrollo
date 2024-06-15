package Logica.Asientos;

public class AsientoCama extends AsientoDecorador {

    public AsientoCama(ModeloAsiento silla){
        super(silla);
        this.SumarPrecio();
    }

    @Override
    public void SumarPrecio() {
        asiento.precio += 1000;
    }
}
