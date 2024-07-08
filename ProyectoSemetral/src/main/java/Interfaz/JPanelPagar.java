package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class JPanelPagar extends JPanel {

    private Cambiodeescena cambiodeescena;
    private JPanelAsientos panelAsientos;
    private JPaneletapafinal etapafinal;
    private JPanelMisPasajes misPasajes;
    private JTextArea areaResumen;
    private JScrollPane scrollResumen;
    private CrearBoton crear;
    private CrearLabels labels;
    private ManejoArchivo manejoArchivo;

    public JPanelPagar(Cambiodeescena cambiodeescena, JPanelAsientos panelAsientos, JPanelMenú panelMenú, JPanelMisPasajes misPasajes) {
        this.cambiodeescena = cambiodeescena;
        this.etapafinal = new JPaneletapafinal(cambiodeescena, this, panelMenú);
        setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.crear = new CrearBoton(cambiodeescena);
        this.labels = new CrearLabels();
        this.manejoArchivo = new ManejoArchivo();
        areaResumen = new JTextArea();
        areaResumen.setEditable(false);
        scrollResumen = new JScrollPane(areaResumen);
        scrollResumen.setBounds(50, 50, 400, 300);
        scrollResumen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollResumen);

        JButton volverButton = crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, panelAsientos);
        volverButton.addActionListener(e -> manejoArchivo.eliminarLineasDesdeHasta("Resumen de Selección:", "Precio"));
        add(volverButton);
        JButton terminaButton = crear.botonsimplecrear("Comprar", 50, 450, 150, 50, this, etapafinal);
        terminaButton.addActionListener(e -> {
            manejoArchivo.copiarContenidoA();
            manejoArchivo.eliminarContenidoArchivo("selecciones.txt");
        });
        add(terminaButton);
        add(labels.botonlabel("<html>Al presionar comprar<br>tu ticket quedará<br> registrado y podrás<br>verlo en 'Mis Pasajes'</html>",
                                     460, 50, 300, 300, 24));

        // Llama al método para mostrar la selección al inicializar el panel
        mostrarSeleccion();
    }

    // Método para leer el archivo 'selecciones.txt' y mostrar el contenido en el JTextArea
    public void mostrarSeleccion() {
        File archivo = new File("selecciones.txt");
        StringBuilder contenido = new StringBuilder();

        // Verifica si el archivo existe, si no existe, crea un mensaje indicando que está vacío
        if (!archivo.exists()) {
            areaResumen.setText("Archivo 'selecciones.txt' vacío.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean omitirPrimeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (omitirPrimeraLinea && linea.contains("Resumen de Selección:")) {
                    omitirPrimeraLinea = false;
                    continue;
                }

                contenido.append(linea).append("\n");
            }

            // Agrega "Resumen de Selección:" al principio
            contenido.insert(0, "Resumen de Selección:\n");
            areaResumen.setText(contenido.toString());
        } catch (IOException e) {
            areaResumen.setText("Error al leer el archivo 'selecciones.txt'.");
            e.printStackTrace();
        }
    }

    // Método para agregar una línea al archivo 'selecciones.txt'
    public void agregarSeleccion(String nuevaSeleccion) {
        File archivo = new File("selecciones.txt");

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(nuevaSeleccion);
            pw.flush(); // Mensaje de depuración
        } catch (IOException e) {
            areaResumen.setText("Error al escribir en el archivo 'selecciones.txt'.");
            e.printStackTrace();
        }

        // Actualiza el contenido del JTextArea después de agregar una selección
        mostrarSeleccion();
    }

    // Método para forzar la recarga del archivo al mostrar el panel
    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (aFlag) {
            mostrarSeleccion();
        }
    }
}