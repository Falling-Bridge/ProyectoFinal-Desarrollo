package Interfaz;

import javax.swing.*;

/**
 * Clase que permite hacer 'cambios de escena' entre los paneles
 */
public class Cambiodeescena {

    private JFrame frame;

    /**
     *
     * @param frame JFrame que se usa en todo el proyecto
     */
    public Cambiodeescena(JFrame frame) {
        this.frame = frame;
    }

    /**
     * Cambia de un panel a otro en el JFrame especificado.
     *
     * @param apagar   panel que se apaga
     * @param encender panel que se enciende
     */
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

        frame.revalidate();
        frame.repaint();
    }
}
