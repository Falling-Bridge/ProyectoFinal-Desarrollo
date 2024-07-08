package Interfaz;

import javax.swing.*;

/**
 * Clase principal que configura el JFrame principal y que ocupan todas las clases jpanel
 */
public class JFramePrincipal extends JFrame {

    /**
     * Configura el JFrame principal con título, tamaño y panel inicial.
     *
     * @throws Exception Si ocurre algún error durante la configuración inicial.
     */
    public JFramePrincipal() throws Exception {
        // Configurar el JFrame
        setTitle("Programa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear una instancia de Cambiodeescena para gestionar los cambios de panel
        Cambiodeescena cambio = new Cambiodeescena(this);

        // Panel inicial de la aplicación (menú principal)
        JPanelMenú panelMenu = new JPanelMenú(cambio);

        // Mostrar inicialmente el panelMenú
        cambio.changeScene(null, panelMenu);
    }
}
