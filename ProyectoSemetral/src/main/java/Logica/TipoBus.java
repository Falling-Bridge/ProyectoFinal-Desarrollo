package Logica;

public enum TipoBus {

    TIPO1(7000),
    TIPO2(10000);
    private int valorbus;

    private TipoBus(final int preciobus){
        valorbus = preciobus;
    }

    public int getPrecio(){
        return valorbus;
    }
    
}