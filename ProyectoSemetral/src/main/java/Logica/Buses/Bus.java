package Logica.Buses;

/**es la clase q se instancia y se va decorando*/
public class Bus extends ModeloBus {
    public Bus(){
        super();
    }

    /**
     * hace override al metodo toString, pero no cambia la info, ya q esta cambia solo
     * en las decoraciones
     * @return
     */
    @Override
    public String toString(){
        return "";
    }
}