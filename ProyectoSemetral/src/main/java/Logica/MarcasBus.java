package Logica;

public enum MarcasBus {
    
    EME(3000),
    TURBUS(2500),
    LASGALAXIAS(1000);
    private int valor;
    
    private MarcasBus(int x){
        valor = x;
    }

}
