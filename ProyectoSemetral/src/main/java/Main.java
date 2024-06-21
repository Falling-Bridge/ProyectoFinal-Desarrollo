import Logica.Buses.*;
public class Main {
    public static void main(String[] args) {
        
        ModeloBus Bus = new Bus();
        Bus = new BusLasGalaxias(Bus);
        Bus = new Bus1Piso(Bus);
        System.out.println(Bus.toString());
    }
}