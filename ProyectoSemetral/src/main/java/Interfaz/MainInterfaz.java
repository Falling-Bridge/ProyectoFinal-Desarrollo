package Interfaz;

import java.io.IOException;

import javax.swing.*;

//solamente se usa para correr el programa
public class MainInterfaz {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFramePrincipal().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}