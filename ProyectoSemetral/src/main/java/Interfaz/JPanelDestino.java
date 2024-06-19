package Interfaz;

import javax.swing.*;
import java.awt.Color;

public class JPanelDestino extends JPanel {  // Extender JPanel
    private JPanelComprar comprarpanel;
    private JPanelMenú volveralmenú;
    private Cambiodeescena cambiodeescena;
    private CrearBoton crear;
    private CrearLabels labels;

    public JPanelDestino(Cambiodeescena cambiodeescena, JPanelComprar panelComprar){
        this.cambiodeescena = cambiodeescena;
        this.comprarpanel = panelComprar;
        crear = new CrearBoton(cambiodeescena);
        labels = new CrearLabels();
        this.setBackground(Color.YELLOW);

        add(labels.botonlabel("Seleccionar destino", 250, 50, 300, 50));
        add(crear.botoncrear("Destino 1", 100, 360, 150, 50, this, null));
        add(crear.botoncrear("Destino 2", 300, 360, 150, 50, this, null));
        add(crear.botoncrear("Destino 3", 500, 360, 150, 50, this, null));
    }
}