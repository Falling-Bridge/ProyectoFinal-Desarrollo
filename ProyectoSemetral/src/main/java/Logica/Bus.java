package Logica;
import Logica.Asientos.*;
import java.util.ArrayList;

import Logica.Asientos.ModeloAsiento;
public class Bus {
    private TipoBus modelo;
    private ArrayList<ModeloAsiento> Asientos;

    public Bus(TipoBus bus){
        modelo = bus;
        //llenamos el bus con diferente cantidades de asientos de pendiendo de el tipo de bus
        if(modelo == TipoBus.TIPO1){
            for(int i = 0; i < 100; i++){
                if(i<20){
                    ModeloAsiento silla = new Asiento(i, bus, TipoAsiento.VIP);
                    Asientos.add(silla);
                }
                else if(i>20 && i < 50){
                    ModeloAsiento silla = new Asiento(i, bus, TipoAsiento.SEMICAMA);
                    Asientos.add(silla);
                }
                else{
                    ModeloAsiento silla = new Asiento(i, bus, TipoAsiento.CAMA);
                    Asientos.add(silla);
                }
            }
        }
        else{
            for(int i = 0; i < 120; i++){
                if(i<25){
                    ModeloAsiento silla = new Asiento(i, bus, TipoAsiento.VIP);
                    Asientos.add(silla);
                }
                else if(i>25 && i < 80){
                    ModeloAsiento silla = new Asiento(i, bus, TipoAsiento.SEMICAMA);
                    Asientos.add(silla);
                }
                else{
                    ModeloAsiento silla = new Asiento(i, bus, TipoAsiento.CAMA);
                    Asientos.add(silla);
                }
            }
        }
    }
    public ModeloAsiento ComprarAsiento(int numeroasiento){
        if(!Asientos.get(numeroasiento).getComprado()){
            Asientos.get(numeroasiento).comprar(); 
        }
        return Asientos.get(numeroasiento);
    }
}
