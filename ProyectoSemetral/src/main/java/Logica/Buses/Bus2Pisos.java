package Logica.Buses;

import Logica.Asientos.*;

import java.util.Random;

/**
 * es el segundo decorador segun el tipo de bus, donde se define el bus como uno de dos pisos,
 * y se llenan los Arraylists con asientos variados
 */
public class Bus2Pisos extends BusDecorador {
    
    public Bus2Pisos(ModeloBus busforma) throws Exception{
        super(busforma);

        /**
         * el bus tiene 50 asientos y se llena con distinto tipos
         * va verificando segun su pocición si va a ser ventana o pasillo,
         * primero llenando el primer piso, y luego el segundo
         * añadiendo los decoradores a los asientos en ambos casos
         * el llenado random se basa en usar el metodo llenado_de_asientos
         */
        Random random = new Random();
        int numrandom = random.nextInt(7);
        for(int i = 1; i <= 30; i++){
            if(i <= 16){
                if(i % 4 == 1 || i % 4 == 0){
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoSemiCama(silla);
                    silla = new AsientoVentana(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    System.out.println("i: "+ i + silla.getComprado());
                    AsientosPiso1.add(silla);
                }
                else{
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoSemiCama(silla);
                    silla = new AsientoPasillo(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    System.out.println("i: "+ i + silla.getComprado());
                    AsientosPiso1.add(silla);
                }
            }
            else if(i > 16 && i < 24){
                if(i % 4 == 1 || i % 4 == 0){
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoCama(silla);
                    silla = new AsientoVentana(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    System.out.println("i: "+ i + silla.getComprado());
                    AsientosPiso1.add(silla);
                }
                else{
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoCama(silla);
                    silla = new AsientoPasillo(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    System.out.println("i: "+ i + silla.getComprado());
                    AsientosPiso1.add(silla);
                }
            }
            else{
                if(i % 4 == 1 || i % 4 == 0){
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoVIP(silla);
                    silla = new AsientoVentana(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    System.out.println("i: "+ i + silla.getComprado());
                    AsientosPiso1.add(silla);
                }
                else{
                    ModeloAsiento silla = new Asiento(i);
                    silla = new AsientoVIP(silla);
                    silla = new AsientoPasillo(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    System.out.println("i: "+ i + silla.getComprado());
                    AsientosPiso1.add(silla);
                }
            }
        }
        for(int i = 1; i <= 20; i++){
            if(i<10){
                if(i % 4 == 1 || i % 4 == 0){
                    ModeloAsiento silla = new Asiento(i+50);
                    silla = new AsientoCama(silla);
                    silla = new AsientoVentana(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    System.out.println("i: "+ i + silla.getComprado());
                    AsientosPiso1.add(silla);
                }
                else{
                    ModeloAsiento silla = new Asiento(i+50);
                    silla = new AsientoCama(silla);
                    silla = new AsientoPasillo(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    System.out.println("i: "+ i + silla.getComprado());
                    AsientosPiso1.add(silla);
                }
            }
            else{
                if(i % 4 == 1 || i % 4 == 0){
                    ModeloAsiento silla = new Asiento(i+50);
                    silla = new AsientoVIP(silla);
                    silla = new AsientoVentana(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    System.out.println("i: "+ i + silla.getComprado());
                    AsientosPiso2.add(silla);
                }
                else{
                    ModeloAsiento silla = new Asiento((i+50));
                    silla = new AsientoVIP(silla);
                    silla = new AsientoPasillo(silla);
                    if(llenado_de_asientos()) {
                        silla.comprar();
                    }
                    System.out.println("i: "+ i + silla.getComprado());
                    AsientosPiso2.add(silla);
                }
            }
        }
    }

    /**
     * hace override del metodo getPrecio, esta vez modificandolo
     * @return el precio ya establecido mas 1300 pesos
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio() + 1300;
    }

    /**
     * hace override y cambia la definición del bus
     * @return le añade a la descripción que el bus tiene dos pisos con asientos
     */
    @Override
    public String toString(){
        return "Pisos: 2; " + buslaillier.toString();
    }
}