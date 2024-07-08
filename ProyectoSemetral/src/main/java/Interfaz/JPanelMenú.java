package Interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que permite al usuario navegar entre el panel compra y el panel mispasajes
 */
public class JPanelMenú extends JPanel {

    // Instancias de otras clases relacionadas
    private Cambiodeescena cambiodeescena;
    private JPanelMisPasajes misPasajes;
    private JPanelComprar comprar;
    private CrearBoton crear;

    /**
     * Constructor
     * @param cambiodeescena Instancia de Cambiodeescena para gestionar el cambio de paneles.
     * @throws Exception Si ocurre un error durante la inicialización de JPanelComprar.
     */
    public JPanelMenú(Cambiodeescena cambiodeescena) throws Exception {
        this.cambiodeescena = cambiodeescena;
        misPasajes = new JPanelMisPasajes(cambiodeescena, this); // Pasando 'this' para volver al menú desde JPanelMisPasajes
        comprar = new JPanelComprar(cambiodeescena, this, misPasajes);
        crear = new CrearBoton(cambiodeescena);

        setLayout(null); // Layout absoluto para posicionar componentes manualmente
        this.setBackground(Color.BLACK);

        // Botones para navegar a las secciones de Comprar y Mis Pasajes
        add(crear.botonsimplecrear("Comprar", 250, 200, 150, 50, this, comprar));
        add(crear.botonsimplecrear("Mis pasajes", 500, 200, 150, 50, this, misPasajes));
    }
}