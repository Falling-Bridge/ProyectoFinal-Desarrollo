package Logica.Buses;

public class BusEme extends BusDecorador {
    
    public BusEme(ModeloBus busforma){
        super(busforma);
        buslaillier.setPrecio(1500);
    }

    @Override
    public String toString(){
        return "Marca: EME; " + buslaillier.toString();
    }
}
