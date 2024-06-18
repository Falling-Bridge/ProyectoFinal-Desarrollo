package Logica.Asientos;

public abstract class AsientoDecorador extends ModeloAsiento{
    protected ModeloAsiento asiento;
    public AsientoDecorador(ModeloAsiento silla){
        super(silla.Numero);
        this.asiento = silla;
    }
    public int getPrecio(){
        return asiento.getPrecio();
    }
    public String getDescription(){
        return asiento.getDescription();
    }
}
