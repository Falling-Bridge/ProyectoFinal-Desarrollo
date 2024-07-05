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
        addButtonWithSave("Compañia A", 100, 360, 150, 50, misPasajes);
        addButtonWithSave("Compañia B", 300, 360, 150, 50, misPasajes);
        addButtonWithSave("Compañia C", 500, 360, 150, 50, misPasajes);
        add(crear.botonsimplecrear("Volver", 300, 500, 150, 50, this, panelMenu));
    }

    // Método para agregar botones de compra con guardado de selección y cambio de escena
    private void addButtonWithSave(String nombre, int x, int y, int width, int height, JPanelMisPasajes misPasajes) {
        JButton boton = crear.botoncomplejocrear(nombre, x, y, width, height, (ActionEvent e) -> {
            crear.guardarseleccion(nombre);
            cambiodeescena.changeScene(this, paneldestino); // Cambiar al panel de destino después de seleccionar la compañía
        });
        add(boton);
    }
}