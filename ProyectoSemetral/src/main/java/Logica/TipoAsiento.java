package Logica;

public enum TipoAsiento {
    
    VIP(4000),
    CAMA(2500),
    SEMICAMA(3200);
    private int valorasiento;

    private TipoAsiento(final int precio){
        valorasiento = precio;
    }

    public int getPrecio(){
        return valorasiento;
    }
}
