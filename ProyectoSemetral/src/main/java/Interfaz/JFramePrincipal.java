package Interfaz;

import javax.swing.*;

public class JFramePrincipal extends JFrame {

    public JFramePrincipal() {
        // Configurar el JFrame
        setTitle("Programa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear una instancia de Cambiodeescena
        Cambiodeescena cambio = new Cambiodeescena(this);

        // Crear el panel inicial
        JPanelMenú panelMenu = new JPanelMenú(cambio);
        cambio.changeScene(null, panelMenu); // Mostrar el panel inicial
    }
}