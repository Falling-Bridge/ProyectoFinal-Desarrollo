package Interfaz;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelMenú extends JPanel {
    private Cambiodeescena cambiodeescena;
    private JPanelMisPasajes misPasajes;

    public JPanelMenú(Cambiodeescena cambiodeescena) {
        this.cambiodeescena = cambiodeescena;
        misPasajes = new JPanelMisPasajes(cambiodeescena, this); // Pasa this para volver al menú
        this.setBackground(Color.BLACK);
        // Configurar el layout del panel
        setLayout(null); // Usar layout absoluto para posicionar el botón

        // Crear y configurar el botón
        JButton botonMisPasajes = new JButton("Mis pasajes");
        botonMisPasajes.setBounds(50, 50, 150, 50); // Ajustar la posición y el tamaño del botón
        add(botonMisPasajes); // Añadir el botón al panel

        // Añadir un ActionListener al botón
        botonMisPasajes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cambiar de escena
                cambiodeescena.changeScene(JPanelMenú.this, misPasajes);
            }
        });
    }
}

