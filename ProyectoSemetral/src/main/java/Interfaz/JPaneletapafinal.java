package Interfaz;

import javax.swing.*;
import java.awt.*;

public class JPaneletapafinal extends JPanel {

    private JPanelPagar panelPagar;
    private JPanelMisPasajes misPasajes;
    private Cambiodeescena cambiodeescena;
    private CrearBoton crear;

    public JPaneletapafinal(Cambiodeescena cambiodeescena, JPanelPagar panelPagar, JPanelMenú panelMenú) {
        this.panelPagar = panelPagar;
        this.cambiodeescena = cambiodeescena;
        this.misPasajes = new JPanelMisPasajes(cambiodeescena, panelMenú);
        crear = new CrearBoton(cambiodeescena);
        setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        add(crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, panelPagar));
        add(crear.botonsimplecrear("Mis pasajes", 100, 450, 150, 50, this, misPasajes));
    }
}