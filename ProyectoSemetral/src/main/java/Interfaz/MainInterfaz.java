package Interfaz;

import javax.swing.*;

public class MainInterfaz {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Ventana con Controles"); // Crear el JFrame
                JPanelPrincipal panelPrincipal = new JPanelPrincipal(); // Crear una instancia de JPanelPrincipal

                // Configurar el JFrame
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

                // Agregar JPanelPrincipal al JFrame
                frame.add(panelPrincipal);

                // Mostrar el JFrame
                frame.setVisible(true);
            }
        });
    }
}
