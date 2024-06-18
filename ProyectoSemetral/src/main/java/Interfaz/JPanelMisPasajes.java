package Interfaz;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelMisPasajes extends JPanel {
    private Cambiodeescena cambiodeescena;
    private JPanelMenú panelMenu;

    public JPanelMisPasajes(Cambiodeescena cambiodeescena, JPanelMenú panelMenu) {
        this.cambiodeescena = cambiodeescena;
        this.panelMenu = panelMenu;
        this.setBackground(Color.RED);

        // Configurar el layout del panel
        setLayout(null); // Usar layout absoluto para posicionar el botón

        // Crear y configurar el botón
        JButton botonVolver = new JButton("Volver");
        botonVolver.setBounds(350, 50, 100, 50); // Ajustar la posición y el tamaño del botón
        add(botonVolver); // Añadir el botón al panel

        // Añadir un ActionListener al botón
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cambiar de escena
                cambiodeescena.changeScene(JPanelMisPasajes.this, panelMenu);
            }
        });
    }
}