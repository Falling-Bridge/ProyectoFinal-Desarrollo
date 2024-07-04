package Logica.Buses;

import java.util.ArrayList;
import Logica.Asientos.ModeloAsiento;
import java.util.Random;

public abstract class ModeloBus {
    /**
     * clase modelo, para usar en el decorador, la cual guarda los arreglos con los asientos
     * y los metodos principales
     */
    protected int precio = 0;
    protected ArrayList<ModeloAsiento> AsientosPiso1;
    protected ArrayList<ModeloAsiento> AsientosPiso2;

    public ModeloBus(){
        /**
         * se inicializan los arreglos q se llenan al momento de crear un bus de 1 o 2 pisos
         */
        AsientosPiso1 = new ArrayList<ModeloAsiento>();
        AsientosPiso2 = new ArrayList<ModeloAsiento>();
    }
    public boolean llenado_de_asientos(int randomizador){
        Random random = new Random();
        if(randomizador == 0){
            randomizador = random.nextInt(5);
            return true;
        }
        else{
            randomizador --;
            return false;
        }
    }

    /**
     * método con el cual se toma un numero de asiento y se marca como comprado, verificando de q piso es primero
     * @param numeroasiento es el asiento q se quiere comprar
     * @return al asiento ya comprado
     */
    public ModeloAsiento ComprarAsiento(int numeroasiento){
        if(numeroasiento > AsientosPiso1.size()){
            AsientosPiso2.get(numeroasiento).comprar();/**se marca el boolean del asiento como true*/
            return  AsientosPiso2.get(numeroasiento);
        }
        else{
            AsientosPiso1.get(numeroasiento).comprar();
            return AsientosPiso1.get(numeroasiento);
        }
    }

    /**
     * metodo para saber el precio
     * @return 0, pero el preico aumenta a medida q se van añadiendo decoraciones
     */
    public int getPrecio(){
        return precio;
    }

    /**
     * metodo abstracto q devuelve una descripción de la clases
     * @return el return es un string q se modifica euna vez añadidas las decoraciones
     */
    public abstract String toString();

}