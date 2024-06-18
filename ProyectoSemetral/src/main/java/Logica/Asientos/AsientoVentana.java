package Logica.Asientos;

public class AsientoVentana extends AsientoDecorador {

    public AsientoVentana(ModeloAsiento silla){
        super(silla);
    }    

    @Override
    public int getPrecio() {
        return asiento.getPrecio() + 500;
    }

    @Override
    public String getDescription(){
        return asiento.getDescription() + ", Asiento ventana";
    }
}
