package Logica.Asientos;

/**
 * esta es la clase decorador, que se usa para poder modificar una instancia de ModeloAsiento
 * y añadirle distintas herencias a la vez
 */
public abstract class AsientoDecorador extends ModeloAsiento{
    protected ModeloAsiento asiento;
    public AsientoDecorador(ModeloAsiento silla){
        super(silla.Numero);
        this.asiento = silla;
    }

    /**
     * se declara el metodo para cambiarlo en las clases decoradoras
     * @return el getPrecio original
     */
    public int getPrecio(){
        return asiento.getPrecio();
    }

    /**
     * se declara el metodo para cambiarlo en las clases decoradoras
     * @return el toString original
     */
    public String toString(){
        return asiento.toString();
    }
}