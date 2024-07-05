package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JPanelMisPasajes extends JPanel {

    //instancias de otras clases
    private Cambiodeescena cambiodeescena;
    private JPanelMenú panelMenu;
    private JPanelPagar panelPagar;
    private CrearBoton crear;
    private CrearLabels crearLabels;
    private JTextArea textArea;

    public JPanelMisPasajes(Cambiodeescena cambiodeescena, JPanelMenú panelMenu) {

        //incialización de las instancias
        this.cambiodeescena = cambiodeescena;
        this.panelMenu = panelMenu;
        this.crear = new CrearBoton(cambiodeescena);
        this.crearLabels = new CrearLabels();
        this.setBackground(Color.RED);
        setLayout(null);

        this.textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setEditable(false); // Para que el usuario no pueda editar el texto
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(40, 40, 400, 400);
        add(scrollPane);

        // Botón para volver al menú principal
        add(crearLabels.botonlabel("Hola", 500, 40, 100, 100, 30));
        add(crear.botonsimplecrear("Volver", 350, 500, 100, 50, this, panelMenu));
    }

    // Método para cargar el contenido del archivo tickets.txt
    private void cargarContenidoTickets() {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("tickets.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        textArea.setText(contenido.toString());
    }

    // Sobrescribir el método setVisible para cargar el contenido actualizado del archivo
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            cargarContenidoTickets();
        }
    }
}
