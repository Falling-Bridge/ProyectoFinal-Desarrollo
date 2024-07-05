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

    /**
     * es un metodo que se usa para q algunos asientos esten comprados al momento de comprar
     * el cual toma un valor random con un randomizador, revisa si es igual a 0
     * y si no es igual retorna false y no se compra en asiento al momento de decorar el bus
     * @return true o false dependiendo si el número era 0 o no
     */
    public boolean llenado_de_asientos(){
        Random random = new Random();
        int randomizador = random.nextInt(2);
        System.out.println(randomizador);
        return (randomizador == 0);
    }

    /**
     * método con el cual se toma un numero de asiento y se marca como comprado, verificando de q piso es primero
     * @param numeroasiento es el asiento q se quiere comprar
     * @return al asiento ya comprado
     */
    public ModeloAsiento ComprarAsiento(int numeroasiento) throws Exception{
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