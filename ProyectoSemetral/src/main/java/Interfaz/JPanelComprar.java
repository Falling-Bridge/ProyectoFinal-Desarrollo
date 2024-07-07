package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JPanelComprar extends JPanel {

    //instancias de otras clases
    private Cambiodeescena cambiodeescena;
    private JPanelDestino paneldestino;
    private JPanelMenú panelMenu;
    private CrearBoton crear;
    private CrearLabels labels;

    public JPanelComprar(Cambiodeescena cambiodeescena, JPanelMenú panelMenu, JPanelMisPasajes misPasajes) {
        this.cambiodeescena = cambiodeescena;
        this.panelMenu = panelMenu;
        this.crear = new CrearBoton(cambiodeescena);
        this.labels = new CrearLabels();
        this.paneldestino = new JPanelDestino(cambiodeescena, this, panelMenu, misPasajes);
        setLayout(null);
        this.setBackground(Color.GREEN);

        // Adición de botones
        add(labels.botonlabel("Seleccionar compañía", 250, 50, 300, 50, 25));
        add(crear.botonsimplecrear("Volver", 300, 500, 150, 50, this, panelMenu));
        add(crear.botoncomplejocrear("Eme Bus", 100, 360, 150, 50, (ActionEvent e) -> {
            crear.guardarseleccion("Eme Bus");
            cambiodeescena.changeScene(this, paneldestino); // Cambiar al panel de destino después de seleccionar la compañía
        }));
        add(crear.botoncomplejocrear("Las Galaxias", 300, 360, 150, 50, (ActionEvent e) -> {
            crear.guardarseleccion("Las Galaxias");
            cambiodeescena.changeScene(this, paneldestino); // Cambiar al panel de destino después de seleccionar la compañía
        }));
        add(crear.botoncomplejocrear("Turbus", 500, 360, 150, 50, (ActionEvent e) -> {
            crear.guardarseleccion("Turbus");
            cambiodeescena.changeScene(this, paneldestino); // Cambiar al panel de destino después de seleccionar la compañía
        }));
    }
}