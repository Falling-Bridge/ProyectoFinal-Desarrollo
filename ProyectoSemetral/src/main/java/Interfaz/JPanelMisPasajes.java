package Interfaz;

import javax.swing.*;
import java.awt.*;

public class JPanelMisPasajes extends JPanel {

    //instancias de otras clases
    private Cambiodeescena cambiodeescena;
    private JPanelMenú panelMenu;
    private CrearBoton crear;

    public JPanelMisPasajes(Cambiodeescena cambiodeescena, JPanelMenú panelMenu) {

        //incialización de las instancias
        this.cambiodeescena = cambiodeescena;
        this.panelMenu = panelMenu;
        crear = new CrearBoton(cambiodeescena);
        this.setBackground(Color.RED);
        setLayout(null);

        //adición de botón
        add(crear.botonsimplecrear("Volver", 350, 500, 100, 50, JPanelMisPasajes.this, panelMenu));
    }
}