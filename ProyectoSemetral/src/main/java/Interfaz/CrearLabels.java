package Interfaz;

import javax.swing.*;
import java.awt.*;

public class CrearLabels {

    //Es simplemente un creador de JLabes para no tener que usar 3, 4 líneas de código

    public CrearLabels(){}      

    public JLabel botonlabel(String Nombre, int x, int y, int width, int height) {
        JLabel label = new JLabel(Nombre);
        label.setBounds(x, y, width, height); // Ajustar la posición y el tamaño del botón
        label.setFont(new Font("Arial", Font.BOLD, 25));
        return label;
    }
}