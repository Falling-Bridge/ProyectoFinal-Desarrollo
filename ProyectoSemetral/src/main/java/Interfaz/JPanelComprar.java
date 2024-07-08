package Interfaz;

import javax.swing.*;
import Logica.Buses.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class JPanelComprar extends JPanel {

    //instancias de otras clases
    private Cambiodeescena cambiodeescena;
    private JPanelDestino paneldestino;
    private JPanelMenú panelMenu;
    private CrearBoton crear;
    private CrearLabels labels;
    public ModeloBus busbasec;

    public JPanelComprar(Cambiodeescena cambiodeescena, JPanelMenú panelMenu, JPanelMisPasajes misPasajes) throws Exception {
        busbasec = new Bus();
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
            try {
                busbasec = new BusEme(busbasec);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            cambiodeescena.changeScene(this, paneldestino); // Cambiar al panel de destino después de seleccionar la compañía
        }));
        add(crear.botoncomplejocrear("Las Galaxias", 300, 360, 150, 50, (ActionEvent e) -> {
            crear.guardarseleccion("Las Galaxias");
            try {
                busbasec = new BusLasGalaxias(busbasec);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            cambiodeescena.changeScene(this, paneldestino); // Cambiar al panel de destino después de seleccionar la compañía
        }));
        add(crear.botoncomplejocrear("Turbus", 500, 360, 150, 50, (ActionEvent e) -> {
            try {
                busbasec = new BusTurbus(busbasec);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            crear.guardarseleccion("Turbus");
            cambiodeescena.changeScene(this, paneldestino); // Cambiar al panel de destino después de seleccionar la compañía
        }));
    }
}