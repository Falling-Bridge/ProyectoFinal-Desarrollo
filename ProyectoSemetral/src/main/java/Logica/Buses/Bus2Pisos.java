package Logica.Buses;

import Logica.TipoAsiento;
import Logica.TipoBus;
import Logica.Asientos.Asiento;
import Logica.Asientos.AsientoCama;
import Logica.Asientos.AsientoPasillo;
import Logica.Asientos.AsientoSemiCama;
import Logica.Asientos.AsientoVIP;
import Logica.Asientos.AsientoVentana;
import Logica.Asientos.ModeloAsiento;

public class Bus2Pisos extends BusDecorador {
    
    public Bus2Pisos(ModeloBus busforma){
        super(busforma);

        for(int i = 1; i <= 50; i++){
            if(i<25){
                if(i % 4 == 1 || i % 4 == 0){
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoSemiCama(silla);
                    silla = new AsientoVentana(silla);
                    AsientosPiso1.add(silla);
                    System.out.println(silla.get);
                }
                else{
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoSemiCama(silla);
                    silla = new AsientoPasillo(silla);
                    AsientosPiso1.add(silla);
                }
            }
            else if(i>25 && i < 40){
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
        for(int i = 1; i <= 20; i++){
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
            else{
                if(i % 4 == 1 || i % 4 == 0){
                    ModeloAsiento silla = new Asiento(i+50);
                    silla = new AsientoVIP(silla);
                    silla = new AsientoVentana(silla);
                    AsientosPiso2.add(silla);
                }
                else{
                    ModeloAsiento silla = new Asiento(i+50);
                    silla = new AsientoVIP(silla);
                    silla = new AsientoPasillo(silla);
                    AsientosPiso2.add(silla);
                }
            }
        }
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