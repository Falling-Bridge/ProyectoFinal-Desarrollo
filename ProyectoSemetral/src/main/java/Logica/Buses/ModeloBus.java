package Logica.Buses;

import java.util.ArrayList;

import Logica.Asientos.Asiento;
import Logica.Asientos.AsientoCama;
import Logica.Asientos.AsientoPasillo;
import Logica.Asientos.AsientoSemiCama;
import Logica.Asientos.AsientoVIP;
import Logica.Asientos.AsientoVentana;
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

    public ModeloBus() throws Exception{
        /**
         * se inicializan los arreglos q se llenan al momento de crear un bus de 1 o 2 pisos
         */
        AsientosPiso1 = new ArrayList<ModeloAsiento>();
        AsientosPiso2 = new ArrayList<ModeloAsiento>();

         /**
         * el bus tiene 30 asientos y se llena con distinto tipos
         * va verificando segun su pocición si va a ser ventana o pasillo,
         * y lo añade con esa decoración
          * el llenado random se basa en usar el metodo llenado_de_asientos
         */
        for (int i = 1; i <= 40; i++) {
            if (i <= 5 || (16 <= i && i <= 20) ) {
                if (i % 3 == 0) {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoVIP(silla);
                    silla = new AsientoVentana(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    AsientosPiso1.add(silla);
                    
                }
                else if (i % 3 == 1) {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoSemiCama(silla);
                    silla = new AsientoVentana(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    AsientosPiso1.add(silla);
                } 
                else {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoCama(silla);
                    silla = new AsientoVentana(silla);
                    if(llenado_de_asientos()){
                        silla.comprar();
                    }
                    AsientosPiso1.add(silla);
                }
            } 
            else if ((i >= 6 && i <= 15)) {
                if (i % 3 == 0) {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoVIP(silla);
                    silla = new AsientoPasillo(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    AsientosPiso1.add(silla);
                    
                }
                else if (i % 3 == 1) {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoSemiCama(silla);
                    silla = new AsientoPasillo(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    AsientosPiso1.add(silla);
                } 
                else {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoCama(silla);
                    silla = new AsientoPasillo(silla);
                    if(llenado_de_asientos()){
                        silla.comprar();
                    }
                    AsientosPiso1.add(silla);
                }
            }
            else if ((i >= 21 && i <= 25)|| (36 <= i) ) {
                if (i % 3 == 0) {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoVIP(silla);
                    silla = new AsientoVentana(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    AsientosPiso2.add(silla);
                    
                }
                else if (i % 3 == 1) {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoSemiCama(silla);
                    silla = new AsientoVentana(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    AsientosPiso2.add(silla);
                } 
                else {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoCama(silla);
                    silla = new AsientoVentana(silla);
                    if(llenado_de_asientos()){
                        silla.comprar();
                    }
                    AsientosPiso2.add(silla);
                }
            } 
            else if ((i >= 26 && i <= 35)) {
                if (i % 3 == 0) {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoVIP(silla);
                    silla = new AsientoPasillo(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    AsientosPiso2.add(silla);
                    
                }
                else if (i % 3 == 1) {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoSemiCama(silla);
                    silla = new AsientoPasillo(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    AsientosPiso2.add(silla);
                } 
                else {
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoCama(silla);
                    silla = new AsientoPasillo(silla);
                    if(llenado_de_asientos()){
                        silla.comprar();
                    }
                    AsientosPiso2.add(silla);
                }
            }
        }
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
        return (randomizador == 0);
    }

    public boolean getestadoAsiento(int index, int piso){
        if(piso == 0 && index < AsientosPiso1.size()){
            return AsientosPiso1.get(index).getComprado();
        } else if (piso == 20 && index < AsientosPiso2.size()) {
            return AsientosPiso2.get(index).getComprado();
        } else {
            // Manejar el caso fuera de los límites
            return false;
        }
    }
     

    /**
     * método con el cual se toma un numero de asiento y se marca como comprado, verificando de q piso es primero
     * @param numeroasiento es el asiento q se quiere comprar
     * @return al asiento ya comprado
     */
    public ModeloAsiento ComprarAsiento(int numeroasiento) throws Exception{
        if(numeroasiento >= AsientosPiso1.size()){
            AsientosPiso2.get(numeroasiento - AsientosPiso1.size()).comprar(); // Ajusta el índice
            return  AsientosPiso2.get(numeroasiento - AsientosPiso1.size());
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