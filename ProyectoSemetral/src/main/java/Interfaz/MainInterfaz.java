package Interfaz;

import javax.swing.*;

//solamente se usa para correr el programa
public class MainInterfaz {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }
}