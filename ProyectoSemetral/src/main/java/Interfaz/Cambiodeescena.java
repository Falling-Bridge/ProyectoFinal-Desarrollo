package Interfaz;

import javax.swing.*;

public class Cambiodeescena { //Es el código que me permite pasar de un panel a otro
    private JFrame frame;

    public Cambiodeescena(JFrame frame) {
        this.frame = frame;
    }

    public void changeScene(JPanel apagar, JPanel encender) {
        // Desactiva el panel actual
        if (apagar != null) {
            apagar.setVisible(false);
            frame.remove(apagar);
        }

        // Activa el nuevo panel
        if (encender != null) {
            encender.setVisible(true);
            frame.add(encender);
        }

        // Refresca el JFrame para aplicar los cambios
        frame.revalidate();
        frame.repaint();
    }
}