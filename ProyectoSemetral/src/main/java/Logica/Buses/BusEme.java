package Logica.Buses;

public class BusEme extends BusDecorador {
    
    public BusEme(ModeloBus busforma){
        super(busforma);
    }

    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 1500;
    }

    @Override
    public String toString(){
        return "Marca: EME" + buslaillier.toString();
    }
}
