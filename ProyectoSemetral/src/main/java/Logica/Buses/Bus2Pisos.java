package Logica.Buses;

public class Bus2Pisos extends BusDecorador {
    
    public Bus2Pisos(ModeloBus busforma){
        super(busforma);
    }

    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 1300;
    }

    @Override
    public String getDescription(){
        return "Pisos: 2" + buslaillier.getDescription();
    }
}