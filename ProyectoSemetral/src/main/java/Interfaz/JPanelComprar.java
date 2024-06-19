package Interfaz;

import javax.swing.*;
import java.awt.*;

public class JPanelComprar extends JPanel {
    private Cambiodeescena cambiodeescena;
    private JPanelDestino paneldestino;
    private JPanelMenú panelMenu;
    private CrearBoton crear;
    private CrearLabels labels;

    public JPanelComprar(Cambiodeescena cambiodeescena, JPanelMenú panelMenu) {
        this.cambiodeescena = cambiodeescena;
        this.panelMenu = panelMenu;
        this.crear = new CrearBoton(cambiodeescena);
        this.labels = new CrearLabels();
        this.paneldestino = new JPanelDestino(cambiodeescena, this);
        this.setBackground(Color.GREEN);

        // Configurar el layout del panel
        setLayout(null); // Usar layout absoluto para posicionar el botón

        add(labels.botonlabel("Seleccionar compañía", 250, 50, 300, 50));
        add(crear.botoncrear("Comprañia A", 100, 360, 150, 50, this, paneldestino));
        add(crear.botoncrear("Comprañia B", 300, 360, 150, 50, this, paneldestino));
        add(crear.botoncrear("Comprañia C", 500, 360, 150, 50, this, paneldestino));
        add(crear.botoncrear("Volver", 300, 500, 150, 50, this, panelMenu));
    }
}