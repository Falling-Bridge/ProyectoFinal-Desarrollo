package Interfaz;

import javax.swing.*;
import java.awt.*;

public class JPaneletapafinal extends JPanel {

    private JPanelPagar panelPagar;
    private JPanelMisPasajes misPasajes;
    private Cambiodeescena cambiodeescena;
    private CrearBoton crear;
    private CrearLabels labels;

    public JPaneletapafinal(Cambiodeescena cambiodeescena, JPanelPagar panelPagar, JPanelMenú panelMenú) {
        this.panelPagar = panelPagar;
        this.cambiodeescena = cambiodeescena;
        this.misPasajes = new JPanelMisPasajes(cambiodeescena, panelMenú);
        crear = new CrearBoton(cambiodeescena);
        labels = new CrearLabels();
        setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        add(labels.botonlabel("<html>Puedes ver tus pasajes<br>&nbsp;&nbsp;&nbsp;&nbsp;en 'Mis Pasajes' o<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ir al menú</html>", 
                                250, 100, 400, 300, 24));
        add(crear.botonsimplecrear("Menú", 400, 450, 150, 50, this, panelMenú));
        add(crear.botonsimplecrear("Mis pasajes", 200, 450, 150, 50, this, misPasajes));
    }
}