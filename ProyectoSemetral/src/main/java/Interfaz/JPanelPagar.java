package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Clase que representa el panel de pago en la interfaz gráfica.
 * Permite ver un resumen de selección desde 'selecciones.txt',
 * elimina el resumen al volver atrás y copiar la selección a 'tickets.txt' al confirmar la compra.
 */
public class JPanelPagar extends JPanel {

    // Instancias de otras clases relacionadas
    private Cambiodeescena cambiodeescena;
    private JPaneletapafinal etapafinal;
    private JPanelMisPasajes misPasajes;
    private JTextArea areaResumen;
    private JScrollPane scrollResumen;
    private CrearBoton crear;
    private CrearLabels labels;
    private ManejoArchivo manejoArchivo;

    /**
     * Constructor
     * @param cambiodeescena Instancia de Cambiodeescena para gestionar el cambio de paneles.
     * @param panelAsientos Instancia de JPanelAsientos para volver atrás al seleccionar 'Volver'.
     * @param panelMenú Instancia de JPanelMenú para manejar la navegación al menú principal.
     * @param misPasajes Instancia de JPanelMisPasajes para mostrar el resumen de selección.
     */
    public JPanelPagar(Cambiodeescena cambiodeescena, JPanelAsientos panelAsientos, JPanelMenú panelMenú, JPanelMisPasajes misPasajes) {
        this.cambiodeescena = cambiodeescena;
        this.etapafinal = new JPaneletapafinal(cambiodeescena, this, panelMenú);
        setLayout(null); // Layout absoluto para posicionar componentes manualmente
        this.setBackground(Color.LIGHT_GRAY);
        this.crear = new CrearBoton(cambiodeescena);
        this.labels = new CrearLabels();
        this.manejoArchivo = new ManejoArchivo();

        // Configuración del JTextArea para mostrar el resumen de selección
        areaResumen = new JTextArea();
        areaResumen.setEditable(false);
        scrollResumen = new JScrollPane(areaResumen);
        scrollResumen.setBounds(50, 50, 400, 300);
        scrollResumen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollResumen);

        // Botón para volver atrás al menú de selección de asientos
        JButton volverButton = crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, panelAsientos);
        volverButton.addActionListener(e -> manejoArchivo.eliminarLineasDesdeHasta("Resumen de selección:", "Precio"));
        add(volverButton);


        // Botón para confirmar la compra y copiar la selección a 'tickets.txt'
        JButton terminaButton = crear.botonsimplecrear("Comprar", 50, 450, 150, 50, this, etapafinal);
        terminaButton.addActionListener(e -> {
            manejoArchivo.copiarContenidoA();
            manejoArchivo.eliminarContenidoArchivo("selecciones.txt");
        });
        add(terminaButton);

        // Etiqueta de información adicional para el usuario
        add(labels.botonlabel("<html>Al presionar comprar<br>tu ticket quedará<br> registrado y podrás<br>verlo en 'Mis Pasajes'</html>",
                460, 50, 300, 300, 24));

        // Llama al método para mostrar la selección al inicializar el panel
        mostrarSeleccion();
    }

    /**
     * Método para leer el archivo 'selecciones.txt' y mostrar el contenido en el JTextArea.
     * Si el archivo no existe, muestra un mensaje indicando que está vacío.
     */
    public void mostrarSeleccion() {
        File archivo = new File("selecciones.txt");
        StringBuilder contenido = new StringBuilder();

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

            // Agrega la línea "Resumen de Selección:" al principio
            contenido.insert(0, "Resumen de Selección:\n");
            areaResumen.setText(contenido.toString());
        } catch (IOException e) {
            areaResumen.setText("Error al leer el archivo 'selecciones.txt'.");
            e.printStackTrace();
        }
    }

    /**
     * Método para agregar una nueva línea al archivo 'selecciones.txt'.
     *
     * @param nuevaSeleccion La línea a agregar al archivo.
     */
    public void agregarSeleccion(String nuevaSeleccion) {
        File archivo = new File("selecciones.txt");

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            pw.println(nuevaSeleccion);
            pw.flush(); // Flush para asegurar que los datos se escriban inmediatamente
        } catch (IOException e) {
            areaResumen.setText("Error al escribir en el archivo 'selecciones.txt'.");
            e.printStackTrace();
        }

        // Actualiza el contenido del JTextArea después de agregar una selección
        mostrarSeleccion();
    }

    /**
     * Sobrescribe el método setVisible para asegurar que al hacer visible el panel,
     * se cargue el contenido actualizado del archivo 'selecciones.txt' en el JTextArea.
     *
     * @param aFlag Booleano que indica si el panel debe ser visible o no.
     */
    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (aFlag) {
            mostrarSeleccion();
        }
    }
}
