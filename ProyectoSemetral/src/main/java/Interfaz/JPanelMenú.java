package Interfaz;

import javax.swing.*;
import java.awt.*;

public class JPanelMenú extends JPanel {

    //instancias de otras clases
    private Cambiodeescena cambiodeescena;
    private JPanelMisPasajes misPasajes;
    private JPanelComprar comprar;
    private JPanelDestino destino;
    private CrearBoton crear;

    public JPanelMenú(Cambiodeescena cambiodeescena) {

        // inicialización de otras clases
        this.cambiodeescena = cambiodeescena;
        misPasajes = new JPanelMisPasajes(cambiodeescena, this); // Pasa this para volver al menú
        comprar = new JPanelComprar(cambiodeescena, this);
        crear = new CrearBoton(cambiodeescena);
        this.setBackground(Color.BLACK);
        setLayout(null);

        //adición de botones
        add(crear.botonsimplecrear("Comprar", 250, 200, 150, 50, this, comprar));
        add(crear.botonsimplecrear("Mis pasajes", 500, 200, 150, 50, this, misPasajes));

    }
}