package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que permite al usuario ver los pasajes adquiridos y eliminar todos los registros de pasajes almacenados en 'tickets.txt'.
 */
public class JPanelMisPasajes extends JPanel {

    // Instancias de otras clases relacionadas
    private Cambiodeescena cambiodeescena;
    private JPanelMenú panelMenu;
    private CrearBoton crear;
    private CrearLabels crearLabels;
    private JTextArea textArea;
    private ManejoArchivo manejoArchivo;

    /**
     * Constructor
     * @param cambiodeescena Instancia de Cambiodeescena para gestionar el cambio de paneles.
     * @param panelMenu Instancia de JPanelMenú para poder regresar al menú principal.
     */
    public JPanelMisPasajes(Cambiodeescena cambiodeescena, JPanelMenú panelMenu) {
        this.cambiodeescena = cambiodeescena;
        this.panelMenu = panelMenu;
        this.crear = new CrearBoton(cambiodeescena);
        manejoArchivo = new ManejoArchivo();
        this.crearLabels = new CrearLabels();
        this.setBackground(Color.RED);
        setLayout(null); // Layout absoluto para posicionar componentes manualmente

        // Configuración del JTextArea para mostrar los tickets
        this.textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setEditable(false); // Para que el usuario no pueda editar el texto
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(40, 40, 400, 400);
        add(scrollPane);

        // Botón para volver al menú principal
        add(crear.botonsimplecrear("Volver", 300, 500, 150, 50, this, panelMenu));

        // Botón para eliminar todos los tickets almacenados en 'tickets.txt'
        JButton eliminarTicketsButton = crear.botoncomplejocrear("Eliminar tickets", 100, 500, 170, 50, e -> {
            manejoArchivo.eliminarContenidoArchivo("tickets.txt");
            cargarContenidoTickets();
        });
        add(eliminarTicketsButton);
    }

    /**
     * Método privado para cargar el contenido del archivo 'tickets.txt' en el JTextArea.
     * Lee cada línea del archivo y las muestra en el JTextArea.
     */
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

    /**
     * Sobrescribe el método setVisible para asegurar que al hacer visible el panel,
     * se cargue el contenido actualizado del archivo 'tickets.txt' en el JTextArea.
     *
     * @param visible Booleano que indica si el panel debe ser visible o no.
     */
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            cargarContenidoTickets();
        }
    }
}