package Interfaz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.event.*;

public class JFramePrincipal extends JFrame {

    //aquí se configura el formato que siguen todos los demás paneles, por eso el nombre de jframe

    public JFramePrincipal() {
        // Configurar el JFrame
        setTitle("Programa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear una instancia de Cambiodeescena
        Cambiodeescena cambio = new Cambiodeescena(this);

        // Al correr el código lo primero que aparece es el menú principal
        JPanelMenú panelMenu = new JPanelMenú(cambio);

        // Inicialmente mostrar el panelMenú
        cambio.changeScene(null, panelMenu);

        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("tickets.txt"))) {
                    writer.write("");
                } catch (IOException t) {
                    t.printStackTrace();
                }
            }
        });
    }
}