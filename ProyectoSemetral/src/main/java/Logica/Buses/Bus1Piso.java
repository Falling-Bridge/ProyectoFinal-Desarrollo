package Logica.Buses;

import Logica.Asientos.*;

/**
 * es el primer decorador segun el tipo de bus, donde se define el bus como uno de un solo piso,
 * y se llena el Arraylist con asientos variados
 */
public class Bus1Piso extends BusDecorador{
    
    public Bus1Piso(ModeloBus busforma){
        super(busforma);

        /**
         * el bus tiene 30 asientos y se llena con distinto tipos
         * va verificando segun su pocición si va a ser ventana o pasillo,
         * y lo añade con esa decoración
         */
        for(int i = 1; i <= 30; i++){
            if(i <= 16){
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
            else if(i > 16 && i < 24){
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

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 1000 pesos
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 1000;
    }

    /**
     * hace override y cambia la definición del bus
     * @return le añade a la descripción que el bus tiene un solo piso
     */
    @Override
    public String toString(){
        return "Pisos: 1" + buslaillier.toString();
    }
}