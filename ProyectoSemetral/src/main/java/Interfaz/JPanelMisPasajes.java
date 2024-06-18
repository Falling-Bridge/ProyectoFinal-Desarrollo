package Interfaz;

import java.awt.*;
import javax.swing.*;

public class JPanelMisPasajes extends JPanel {

    public JPanelMisPasajes() {
        Color colorOriginal = new Color(48, 118, 184); // Color original
        setBackground(colorOriginal); // Establece el color de fondo inicial del panel
        // Layout manager para centrar componentes
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1.0; // Aumenta el peso en x para que ocupe todo el ancho

        JLabel etiqueta = new JLabel("Mis pasajes");
        etiqueta.setFont(new Font("Arial", Font.BOLD, 20)); // Configura la fuente y tamaño
        etiqueta.setForeground(Color.WHITE); // Color blanco para el texto
        etiqueta.setHorizontalAlignment(JLabel.CENTER); // Alinea el texto al centro
        add(etiqueta, gbc);
    }
}
