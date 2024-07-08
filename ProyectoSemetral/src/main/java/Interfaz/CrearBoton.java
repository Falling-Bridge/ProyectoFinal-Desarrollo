package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.function.Consumer;

public class CrearBoton { // es el creador de botones por defecto, hay excepciones que es cuando se requiere 'recordar'
                          // una acción del mouse

    private Cambiodeescena cambiodeescena;

    public CrearBoton(Cambiodeescena cambiodeescena) {
        this.cambiodeescena = cambiodeescena;
    }

    // Método para viajar entre paneles
    public JButton botonsimplecrear(String nombre, int x, int y, int width, int height, JPanel panelOrigen, JPanel panelDestino) {
        JButton boton = new JButton(nombre);
        boton.setBounds(x, y, width, height);
        boton.setFont(new Font("Arial", Font.BOLD, 18));
        boton.addActionListener(e -> cambiodeescena.changeScene(panelOrigen, panelDestino));
        return boton;
    }

    // Método para botones que necesiten recordar eventos
    public JButton botoncomplejocrear(String nombre, int x, int y, int width, int height, Consumer<ActionEvent> action) {
        JButton boton = new JButton(nombre);
        boton.setBounds(x, y, width, height);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.addActionListener(e -> action.accept(e));
        return boton;
    }

    // Método para guardar la selección en el archivo 'selecciones.txt'
    public void guardarseleccion(String... selecciones) {
        File archivo = new File("selecciones.txt");

        try (FileWriter fw = new FileWriter(archivo, true)) {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            // Escribir las selecciones en el archivo
            for (String seleccion : selecciones) {
                fw.write(seleccion + "\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace(); // Manejo de excepciones, puedes personalizar esto según tus necesidades
        }
    }
    
    // Método para crear botones de panelasiento (puedes eliminarlo si no se usa
    // actualmente)
    public JRadioButton crearRadioButton(String text, boolean selected, int x, int y, ActionListener actionListener) {
        JRadioButton radioButton = new JRadioButton(text, selected);
        radioButton.setBounds(x, y, 100, 30);
        radioButton.addActionListener(actionListener);
        return radioButton;
    }
}