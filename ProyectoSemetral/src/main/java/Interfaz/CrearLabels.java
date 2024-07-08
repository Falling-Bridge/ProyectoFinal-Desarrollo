package Interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Clase para crear JLabels en una interfaz
 */
public class CrearLabels {

    /**
     * Permite la creación de JLabels con configuraciones definidas para el uso
     */
    public CrearLabels() {}

    /**
     * Crea un JLabel con texto, posición, tamaño y tamaño de fuente específicos.
     *
     * @param nombre       Texto que muestra el botón.
     * @param x            Posición en x del botón.
     * @param y            Posición en y del botón.
     * @param width        Ancho del botón.
     * @param height       Alto del botón.
     * @param tamañofont   Tamaño de la fuente a usar
     * @return             Retorna un label que aparece en pantalla
     */
    public JLabel botonlabel(String Nombre, int x, int y, int width, int height, int tamañofont) {
        JLabel label = new JLabel(Nombre);
        label.setBounds(x, y, width, height); // Ajustar la posición y el tamaño del JLabel
        label.setFont(new Font("Arial", Font.BOLD, tamañofont));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }
}
