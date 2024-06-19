package Interfaz;

import javax.swing.*;
import java.awt.*;

public class JPanelComprar extends JPanel {

    //instancias de otras clases
    private Cambiodeescena cambiodeescena;
    private JPanelDestino paneldestino;
    private JPanelMenú panelMenu;
    private CrearBoton crear;
    private CrearLabels labels;

    public JPanelComprar(Cambiodeescena cambiodeescena, JPanelMenú panelMenu) {

        //inicialización de las instancias
        this.cambiodeescena = cambiodeescena;
        this.panelMenu = panelMenu;
        this.crear = new CrearBoton(cambiodeescena);
        this.labels = new CrearLabels();
        this.paneldestino = new JPanelDestino(cambiodeescena, this);
        this.setBackground(Color.GREEN);
        setLayout(null);

        //adición de botones
        add(labels.botonlabel("Seleccionar compañía", 250, 50, 300, 50));
        add(crear.botonsimplecrear("Comprañia A", 100, 360, 150, 50, this, paneldestino));
        add(crear.botonsimplecrear("Comprañia B", 300, 360, 150, 50, this, paneldestino));
        add(crear.botonsimplecrear("Comprañia C", 500, 360, 150, 50, this, paneldestino));
        add(crear.botonsimplecrear("Volver", 300, 500, 150, 50, this, panelMenu));
    }
}