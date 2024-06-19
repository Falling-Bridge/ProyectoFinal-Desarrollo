package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CrearBoton {
    private Cambiodeescena cambiodeescena;

    public CrearBoton(Cambiodeescena cambiodeescena) {
        this.cambiodeescena = cambiodeescena;
    }

    public JButton botoncrear(String Nombre, int x, int y, int width, int height, JPanel panelComprar,
            JPanel panelMenu) {
        JButton boton = new JButton(Nombre);
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
}