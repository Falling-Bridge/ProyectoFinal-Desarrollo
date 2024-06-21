package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CrearBoton { // es el creador de botones por defecto, hay excepciones que es cuando se requiere 'recordar'
                          // una acción del mouse
    
    private Cambiodeescena cambiodeescena;

    public CrearBoton(Cambiodeescena cambiodeescena) {
        this.cambiodeescena = cambiodeescena;
    }

    // Método para crear botones simples como "Volver", proximamente 'cancelar compra' y demases
    public JButton botonsimplecrear(String nombre, int x, int y, int width, int height, JPanel panelComprar, JPanel panelMenu) {
        JButton boton = new JButton(nombre);
        boton.setBounds(x, y, width, height); // Ajustar la posición y el tamaño del botón
        boton.setFont(new Font("Arial", Font.BOLD, 18));
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiodeescena.changeScene(panelComprar, panelMenu);
            }
        });
        return boton;
    }

    // Método para crear JRadioButton
    public JRadioButton crearRadioButton(String text, boolean selected, int x, int y, ActionListener actionListener) {
        JRadioButton radioButton = new JRadioButton(text, selected);
        radioButton.setBounds(x, y, 100, 30);
        radioButton.addActionListener(actionListener);
        return radioButton;
    }

    // Método para crear botones complejos que recuerdan eventos
    public JButton botoncomplejocrear(String nombre, int x, int y, int width, int height) {
        JButton boton = new JButton(nombre);
        boton.setBounds(x, y, width, height);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        return boton;
    }
}