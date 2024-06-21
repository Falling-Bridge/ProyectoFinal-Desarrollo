package Logica.Buses;

import Logica.Asientos.*;

public class Bus1Piso extends BusDecorador{
    
    public Bus1Piso(ModeloBus busforma){
        super(busforma);
        busforma.setPrecio(1000);

        for(int i = 1; i <= 50; i++){
            if(i<30){
                if(i % 4 == 1 || i % 4 == 0){
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoSemiCama(silla);
                    silla = new AsientoVentana(silla);
                    AsientosPiso1.add(silla);
                }
                else{
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoSemiCama(silla);
                    silla = new AsientoPasillo(silla);
                    AsientosPiso1.add(silla);
                }
            }
            else if(i>30 && i < 45){
                if(i % 4 == 1 || i % 4 == 0){
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoCama(silla);
                    silla = new AsientoVentana(silla);
                    AsientosPiso1.add(silla);
                }
                else{
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoCama(silla);
                    silla = new AsientoPasillo(silla);
                    AsientosPiso1.add(silla);
                }
            }
            else{
                if(i % 4 == 1 || i % 4 == 0){
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoVIP(silla);
                    silla = new AsientoVentana(silla);
                    AsientosPiso1.add(silla);
                }
                else{
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoVIP(silla);
                    silla = new AsientoPasillo(silla);
                    AsientosPiso1.add(silla);
                }
            }
        }
    }

    @Override
    public String toString(){
        return "Pisos: 1; " + buslaillier.toString();
    }
}