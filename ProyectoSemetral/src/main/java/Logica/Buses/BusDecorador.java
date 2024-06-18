package Logica.Buses;

public abstract class BusDecorador extends ModeloBus {
    protected ModeloBus buslaillier;
    public BusDecorador(ModeloBus busforma){
        super();
        this.buslaillier = busforma;
    }

    @Override
    public int getPrecio(){
        return buslaillier.precio;
    }

    @Override
    public String toString(){
        return buslaillier.toString();
    }
}
