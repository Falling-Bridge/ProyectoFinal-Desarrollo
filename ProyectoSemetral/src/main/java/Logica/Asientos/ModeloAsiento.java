package Logica.Asientos;


//esta clase es la base de mi decorador, a fin de cuentas sería como la interfaz, 
//ya q despues los asientos van a ir implementado los metodos de este y las otras tipos de asientos
public abstract class ModeloAsiento {
    protected int Numero;
    protected int precio = 0;
    protected boolean comprado;
    
    public ModeloAsiento(int numero){
        Numero = numero;
        comprado = false;
    }

    public void comprar(){
        comprado = true;
    }
    public boolean getComprado(){
        return comprado;
    }
    public int getPrecio() {
        return precio;
    }
    public String getDescription(){
        return "Asiento número: " + Numero;
    }
}
