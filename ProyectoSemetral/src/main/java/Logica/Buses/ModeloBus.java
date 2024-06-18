package Logica.Buses;
import Logica.TipoAsiento;
import Logica.TipoBus;
import Logica.Asientos.*;
import java.util.ArrayList;

import Logica.Asientos.ModeloAsiento;
public abstract class ModeloBus {
    protected TipoBus modelo;
    protected int precio = 0;
    protected ArrayList<ModeloAsiento> AsientosPiso1;
    protected ArrayList<ModeloAsiento> AsientosPiso2;

    public ModeloBus(){
        AsientosPiso1 = new ArrayList<ModeloAsiento>();
        AsientosPiso2 = new ArrayList<ModeloAsiento>();
    }

   /* public ModeloAsiento ComprarAsiento(int numeroasiento){
        if(!Asientos.get(numeroasiento).getComprado()){
            Asientos.get(numeroasiento).comprar(); 
        }
        return Asientos.get(numeroasiento);
    }*/

    public int getPrecio(){
        return precio;
    }

    public abstract String toString();
}