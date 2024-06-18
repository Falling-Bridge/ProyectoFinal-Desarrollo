package Interfaz;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelPrincipal extends JPanel {

    private Color colorOriginal; // Variable para almacenar el color original del panel
    private JPanelMisPasajes panelMisPasajes; // Panel de Mis Pasajes

    public JPanelPrincipal() {
        colorOriginal = new Color(48, 118, 184); // Color original
        setBackground(colorOriginal); // Establece el color de fondo inicial del panel

        // Layout manager para centrar componentes
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1.0; // Aumenta el peso en x para que ocupe todo el ancho

        // Configuración para el texto (1/3 de la altura)
        gbc.gridy = 0;
        gbc.weighty = 0.30; // Peso en y para el texto
        gbc.insets = new Insets(20, 20, 10, 20); // Márgenes (arriba, izquierda, abajo, derecha)
        gbc.anchor = GridBagConstraints.CENTER; // Centrado horizontal

        JLabel etiqueta = new JLabel("Bienvenido a Compra de pasajes totalmente real");
        etiqueta.setFont(new Font("Arial", Font.BOLD, 20)); // Configura la fuente y tamaño
        etiqueta.setForeground(Color.WHITE); // Color blanco para el texto
        etiqueta.setHorizontalAlignment(JLabel.CENTER); // Alinea el texto al centro
        add(etiqueta, gbc);

        // Configuración para los botones (2/3 de la altura)
        gbc.gridy = 1;
        gbc.weighty = 0.60; // Peso en y para los botones
        gbc.insets = new Insets(10, 20, 20, 20); // Márgenes (arriba, izquierda, abajo, derecha)

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.setOpaque(false); // Hace que el panel sea transparente

        // Estilo común para los botones
        Dimension buttonSize = new Dimension(120, 40);
        Font buttonFont = new Font("Arial", Font.PLAIN, 14);
        Color buttonBackground = UIManager.getColor("Button.background");
        Color buttonForeground = UIManager.getColor("Button.foreground");
        Border buttonBorder = UIManager.getBorder("Button.border");

        // Botón Mis pasajes
        JButton botonMisPasajes = crearBoton("Mis pasajes", buttonSize, buttonFont, buttonBackground, buttonForeground,
                buttonBorder);
        botonMisPasajes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al presionar "Mis pasajes"
                mostrarPanelMisPasajes();
            }
        });

        // Botón Cerrar ventana
        JButton botonCerrarVentana = crearBoton("Cerrar ventana", buttonSize, buttonFont, buttonBackground,
                buttonForeground, buttonBorder);
        botonCerrarVentana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción al presionar "Cerrar ventana"
                System.exit(0);
            }
        });

        // Agregar botones al panel
        panelBotones.add(botonMisPasajes);
        panelBotones.add(botonCerrarVentana);
        add(panelBotones, gbc);

        // Inicializar el panel de Mis Pasajes
        panelMisPasajes = new JPanelMisPasajes();
    }

    private void mostrarPanelMisPasajes() {
        removeAll(); // Elimina todos los componentes actuales del panel principal
        setLayout(new BorderLayout()); // Establece un nuevo layout para el panel principal
        add(panelMisPasajes, BorderLayout.CENTER); // Agrega el panel de Mis Pasajes al centro
        revalidate(); // Revalida el panel para reflejar los cambios
        repaint(); // Vuelve a pintar el panel
    }

    // Método utilitario para crear botones con un estilo común
    private JButton crearBoton(String texto, Dimension dimension, Font fuente, Color colorFondo, Color colorTexto,
            Border borde) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(dimension);
        boton.setFont(fuente);
        boton.setBackground(colorFondo);
        boton.setForeground(colorTexto);
        boton.setBorder(borde);
        return boton;
    }
}
