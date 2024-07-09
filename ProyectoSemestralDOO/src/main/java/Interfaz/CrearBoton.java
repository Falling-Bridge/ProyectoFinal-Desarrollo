package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * Clase para crear botones que se usan múltiples veces en la mayoría de los archivos
 */
public class CrearBoton {

    private Cambiodeescena cambiodeescena;

    /**
     * Constructor
     *
     * @param cambiodeescena Se usa para botones que requieren cambiar paneles
     */
    public CrearBoton(Cambiodeescena cambiodeescena) {
        this.cambiodeescena = cambiodeescena;
    }

    /**
     * Crea un botón simple con el propósito de cambiar entre paneles
     *
     * @param nombre       Texto que muestra el botón.
     * @param x            Posición en x del botón.
     * @param y            Posición en y del botón.
     * @param width        Ancho del botón.
     * @param height       Alto del botón.
     * @param panelOrigen  Panel que se va a apagar
     * @param panelDestino panel que se va a prender
     * @return Boton que se usa para cambiar de escenas
     */
    public JButton botonsimplecrear(String nombre, int x, int y, int width, int height, JPanel panelOrigen, JPanel panelDestino) {
        JButton boton = new JButton(nombre);
        boton.setBounds(x, y, width, height);
        boton.setFont(new Font("Arial", Font.BOLD, 18));
        boton.addActionListener(e -> cambiodeescena.changeScene(panelOrigen, panelDestino));
        return boton;
    }

    /**
     * Crea un botón con nombre y acciones personalizadas mediante un Consumer para eventos complejos.
     *
     * 
     * @param nombre       Texto que muestra el botón.
     * @param x            Posición en x del botón.
     * @param y            Posición en y del botón.
     * @param width        Ancho del botón.
     * @param height       Alto del botón.
     * @param action       Acción que se realiza
     * @return Boton que se usa para 'recordar' eventos
     */
    public JButton botoncomplejocrear(String nombre, int x, int y, int width, int height, Consumer<ActionEvent> action) {
        JButton boton = new JButton(nombre);
        boton.setBounds(x, y, width, height);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.addActionListener(e -> action.accept(e));
        return boton;
    }

    /**
     * Guarda las selecciones en el archivo 'selecciones.txt' en los archivo jpanel (compañia, destino, asientos, pagar).
     *
     * @param selecciones Selecciones a guardar en el archivo.
     */
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
            ex.printStackTrace();
        }
    }

    /**
     * Crea un JRadioButton con texto, estado seleccionado y acción personalizada.
     *
     * @param text           Texto que muestra el boton.
     * @param selected       Estado inicial del radio button (true or false).
     * @param x              Posición en x del botón.
     * @param y              Posición en y del botón.
     * @param actionListener Acción que se realiza al presiona el botón
     * @return               Boton que se usa para crear pisos y que uno pueda estar activo a la vez
     */
    public JRadioButton crearRadioButton(String text, boolean selected, int x, int y, ActionListener actionListener) {
        JRadioButton radioButton = new JRadioButton(text, selected);
        radioButton.setBounds(x, y, 100, 30);
        radioButton.addActionListener(actionListener);
        return radioButton;
    }
}
