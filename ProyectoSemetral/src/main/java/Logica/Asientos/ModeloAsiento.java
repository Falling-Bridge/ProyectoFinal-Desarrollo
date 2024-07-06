package Logica.Asientos;

import Logica.Excepciones.*;

/**
 * esta clase es la base de mi decorador, a fin de cuentas sería como la interfaz,
 * ya q despues los asientos van a ir implementado los metodos de este y las otras tipos de asientos
 */
public abstract class ModeloAsiento {
    protected int Numero;
    protected int precio = 0;
    protected boolean comprado;
    
    public ModeloAsiento(int numero){
        Numero = numero;
        comprado = false;
    }

    /**
     * metodo para señalar q el asiento está comprado
     */
    public void comprar() throws ComparDenuevoException{
        if(comprado == false) {
            comprado = true;
        }
        else{
            throw new ComparDenuevoException();
        }
    }

    /**
     * metodo para verficar si un asiento está comprado o no
     * @return el valor del boolean comprado
     */
    public boolean getComprado(){
        return comprado;
    }

    /**
     * metodo q se altera en las otras clases al igual q en los buses
     * @return el valor del asiento q se le añade valor dependiendo de
     * las decoraciones q tenga encima
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * metodo q contempla la descripción del asiento, se modifica en los decoradores
     * @return el numero del asiento
     */
    public String toString(){
        return "Asiento número: " + Numero;
    }
}
