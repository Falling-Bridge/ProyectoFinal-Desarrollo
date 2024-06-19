package Interfaz;

import javax.swing.*;
import java.awt.*;

public class JPanelMenú extends JPanel {
    private Cambiodeescena cambiodeescena;
    private JPanelMisPasajes misPasajes;
    private JPanelComprar comprar;
    private JPanelDestino destino;
    private CrearBoton crear;

    public JPanelMenú(Cambiodeescena cambiodeescena) {
        this.cambiodeescena = cambiodeescena;
        misPasajes = new JPanelMisPasajes(cambiodeescena, this); // Pasa this para volver al menú
        comprar = new JPanelComprar(cambiodeescena, this);
        crear = new CrearBoton(cambiodeescena);

        this.setBackground(Color.BLACK);
        // Configurar el layout del panel
        setLayout(null); // Usar layout absoluto para posicionar el botón

        // Crear y configurar el botón

        add(crear.botoncrear("Comprar", 50, 150, 150, 50, JPanelMenú.this, comprar));
        add(crear.botoncrear("Mis pasajes", 50, 50, 150, 50, JPanelMenú.this, misPasajes));

    }
}