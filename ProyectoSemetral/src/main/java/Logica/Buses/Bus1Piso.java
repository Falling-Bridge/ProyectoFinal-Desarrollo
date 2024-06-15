package Logica.Buses;

public class Bus1Piso extends BusDecorador{
    
    public Bus1Piso(ModeloBus busforma){
        super(busforma);
    }

    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 1000;
    }

    @Override
    public String getDescription(){
        return "Pisos: 1" + buslaillier.getDescription();
    }
}