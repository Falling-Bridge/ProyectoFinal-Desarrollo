package Interfaz;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JFramePrincipal extends JFrame {

    private ManejoArchivo manejoArchivo;

    /**
     * Configura el JFrame principal con título, tamaño y panel inicial.
     *
     * @throws Exception Si ocurre algún error durante la configuración inicial.
     */
    public JFramePrincipal() throws Exception {
        // Inicializar ManejoArchivo
        manejoArchivo = new ManejoArchivo();

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

        // Agregar WindowListener para borrar el contenido del archivo al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                manejoArchivo.eliminarContenidoArchivo("selecciones.txt");
            }
        });
    }
}