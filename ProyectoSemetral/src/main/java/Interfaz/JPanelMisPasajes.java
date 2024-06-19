package Interfaz;

import javax.swing.*;
import java.awt.Color;

public class JPanelMisPasajes extends JPanel {
    private Cambiodeescena cambiodeescena;
    private JPanelMenú panelMenu;
    private CrearBoton crear;

    public JPanelMisPasajes(Cambiodeescena cambiodeescena, JPanelMenú panelMenu) {
        this.cambiodeescena = cambiodeescena;
        this.panelMenu = panelMenu;
        crear = new CrearBoton(cambiodeescena);
        this.setBackground(Color.RED);

        // Configurar el layout del panel
        setLayout(null); // Usar layout absoluto para posicionar el botón

        add(crear.botoncrear("Volver", 350,500, 100, 50, JPanelMisPasajes.this, panelMenu));
    }
}