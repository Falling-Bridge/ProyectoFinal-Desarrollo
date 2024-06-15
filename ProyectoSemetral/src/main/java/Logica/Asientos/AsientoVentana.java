package Logica.Asientos;

public class AsientoVentana extends AsientoDecorador {

    public AsientoVentana(ModeloAsiento silla){
        super(silla);
        this.SumarPrecio();
    }    

    @Override
    public void SumarPrecio() {
        asiento.precio += 500;
    }
}
