package Logica.Buses;

/**
 * esta es la clase decorador, que se usa para poder modificar una instancia de ModeloBus
 * y añadirle distintas herencias a la vez
 */
public abstract class BusDecorador extends ModeloBus {
    protected ModeloBus buslaillier;
    public BusDecorador(ModeloBus busforma) throws Exception{
        super();
        this.buslaillier = busforma;
    }

    /**
     * hace el Override al metodo getPrecio sin cambiarlo, pero llamando al metodo incial
     * @return el precio base
     */
    @Override
    public int getPrecio(){
        return buslaillier.getPrecio();
    }

    /**
     * hace el Override al metodo toString sin cambiarlo, pero llamando al metodo original
     * @return la descripción origianal
     */
    @Override
    public String toString(){
        return buslaillier.toString();
    }

}
