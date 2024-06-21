package Logica.Buses;

public class BusTurbus extends BusDecorador {
    
    public BusTurbus(ModeloBus busforma){
        super(busforma);
        buslaillier.setPrecio(1000);
    }

    @Override
    public String toString(){
        return "Marca: TurBus; " + buslaillier.toString();
    }
}
