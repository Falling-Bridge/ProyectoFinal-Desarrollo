package Logica.Buses;

public class BusTurbus extends BusDecorador {
    
    public BusTurbus(ModeloBus busforma){
        super(busforma);
    }

    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 1000;
    }

    @Override
    public String toString(){
        return "Marca: TurBus" + buslaillier.toString();
    }
}
