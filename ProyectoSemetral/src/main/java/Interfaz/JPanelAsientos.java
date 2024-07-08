package Interfaz;

import javax.swing.*;
import Logica.Buses.ModeloBus;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Esta clase permite seleccionar los asientos del primer o segundo piso del 'bus'
 * y muestra un resumen de la selección realizada.
 */
public class JPanelAsientos extends JPanel {

    private JPanelDestino paneldestino;
    private Cambiodeescena cambiodeescena;
    private JPanelPagar panelPagar;
    private CrearBoton crear;
    private CrearLabels crearLabels;
    private ManejoArchivo manejoArchivo;
    private JButton[] asientosPiso1;
    private JButton[] asientosPiso2;
    private boolean piso1 = true; // Por defecto, la opción 1 está seleccionada
    private boolean[] asientosSeleccionados; // Array para almacenar los asientos seleccionados
    private JTextArea areaResumen; // JTextArea para mostrar el resumen de selección
    private JScrollPane scrollResumen;
    private JButton botonIrAPagar;
    private JButton botonvolver;
    public ModeloBus busbasea;

    /**
     * Constructor de la clase JPanelAsientos.
     * 
     * @param cambiodeescena    Objeto que maneja el cambio de escenas.
     * @param paneldestino      Panel de destino que contiene la información del bus.
     * @param panelMenú         Panel del menú principal.
     * @param misPasajes        Panel que muestra los pasajes comprados.
     * @throws IOException      Si ocurre un error al manejar archivos.
     */
    public JPanelAsientos(Cambiodeescena cambiodeescena, JPanelDestino paneldestino, JPanelMenú panelMenú, JPanelMisPasajes misPasajes) throws IOException {
        this.cambiodeescena = cambiodeescena;
        this.paneldestino = paneldestino;
        busbasea = paneldestino.busbase;
        panelPagar = new JPanelPagar(cambiodeescena, this, panelMenú, misPasajes);
        crear = new CrearBoton(cambiodeescena);
        this.manejoArchivo = new ManejoArchivo();
        setLayout(null); // Layout absoluto para posicionar componentes manualmente
        this.setBackground(Color.GRAY);
        crearLabels = new CrearLabels();

        // Inicializar los arrays de botones de asientos
        asientosPiso1 = new JButton[20];
        asientosPiso2 = new JButton[20];

        // Inicializar JTextArea para el resumen de selección
        areaResumen = new JTextArea();
        areaResumen.setEditable(false);
        scrollResumen = new JScrollPane(areaResumen);
        scrollResumen.setBounds(555, 100, 230, 230);
        scrollResumen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollResumen);

        asientosSeleccionados = new boolean[40];
        crearBotonPiso("Piso 1", true, 50);
        crearBotonPiso("Piso 2", false, 200);
        
        botonIrAPagar = crear.botonsimplecrear("Ir a pagar", 500, 450, 150, 50, this, panelPagar);
        botonIrAPagar.setEnabled(false);
        botonIrAPagar.addActionListener(this::guardarSeleccion);
        actualizarEstadoBotonPagar();
        
        add(botonIrAPagar);
        actualizarPanel();
        botonvolver = crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, paneldestino);
        botonvolver.addActionListener(e -> {
            manejoArchivo.eliminarLineasPosterioresYCantidad(4, "Las Galaxias", "Sololda", "Eme Bus");                                                                               
        });
        add(botonvolver);
        revalidate();
        repaint();
    }

     /**
     * Crea un botón para seleccionar el piso del bus.
     * 
     * @param texto     Texto del botón.
     * @param selected  Indica si el botón está seleccionado.
     * @param x         Posición x del botón.
     */
    private void crearBotonPiso(String texto, boolean selected, int x) {
        JRadioButton botonpiso = crear.crearRadioButton(texto, selected, x, 50, e -> {
            piso1 = texto.equals("Piso 1");
            try {
                actualizarPanel();
            } catch (IOException e1) {
                e1.printStackTrace();
                // Aquí podrías manejar la excepción de manera adecuada según tu aplicación
            }
        });
        add(botonpiso);
    }     

/**
     * Actualiza el panel con los asientos correspondientes al piso seleccionado.
     * 
     * @throws IOException  Si ocurre un error al manejar archivos.
     */
    private void actualizarPanel() throws IOException {
        removeAll();
        crearBotonPiso("Piso 1", piso1, 50);
        crearBotonPiso("Piso 2", !piso1, 200);
        crearAsientos(piso1 ? asientosPiso1 : asientosPiso2, piso1 ? 0 : 20, piso1 ? 20 : 40);
        JButton botonvolver = crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, paneldestino);
        botonvolver.addActionListener(e -> {
            manejoArchivo.eliminarLineasPosterioresYCantidad(4, "Las Galaxias", "Sololda", "Eme Bus");                                                                                            
        });
        add(botonvolver);
        add(botonIrAPagar);
        actualizarEstadoBotonPagar();
        ResumenSeleccion();
        add(scrollResumen);
        revalidate();
        repaint();
    }

    /**
     * Crea los botones de asientos para el piso seleccionado.
     * 
     * @param asientos  Array de botones de asientos.
     * @param inicio    Índice de inicio del array de asientos.
     * @param fin       Índice de fin del array de asientos.
     * @throws IOException  Si ocurre un error al manejar archivos.
     */
    private void crearAsientos(JButton[] asientos, int inicio, int fin) throws IOException {
        if (asientos == null || asientos.length != (fin - inicio)) {
            asientos = new JButton[fin - inicio]; // Crear array de botones de asientos
        }
    
        int x = 10, y = 100;
        int index = 0;
        for (int i = inicio; i < fin; i++) {
            if (index < asientos.length) {
                if (asientos[index] == null) {
                    asientos[index] = new JButton("Asiento " + (i + 1));
                }
                String tipoAsiento = determinarTipoAsiento(i);
                asientos[index].setText(tipoAsiento); // Texto del botón como tipo de asiento
                asientos[index].setBounds(x, y, 100, 30); // Tamaño y posición de cada botón de asiento
    
                // Configurar color y habilitación según el estado del asiento
                asientos[index].setBackground(asientosSeleccionados[i] ? Color.GREEN : Color.RED); // Color inicial del asiento basado en el estado seleccionado
    
                // Si es piso 1 y está ocupado o es piso 2 y está ocupado, hacer el botón blanco y no clickeable
                if (piso1 && busbasea.getestadoAsiento(i, inicio)) {
                    asientos[index].setBackground(Color.WHITE); // Color blanco
                    asientos[index].setEnabled(false); // No clickeable
                }
                else if(!piso1 && busbasea.getestadoAsiento(i - 20, inicio)){
                    asientos[index].setBackground(Color.WHITE); // Color blanco
                    asientos[index].setEnabled(false); // No clickeable
                }
    
                // Agregar ActionListener solo si el botón está habilitado (para asientos no ocupados del piso 1 o el 2)
                if (asientos[index].isEnabled()) {
                    final int asientoIndex = i;
                    asientos[index].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            asientosSeleccionados[asientoIndex] = !asientosSeleccionados[asientoIndex]; // Cambiar el estado del asiento seleccionado
                            JButton boton = (JButton) e.getSource();
                            boton.setBackground(asientosSeleccionados[asientoIndex] ? Color.GREEN : Color.RED); // Cambiar el color del botón según el estado seleccionado
                            // Actualizar el resumen de selección
                            ResumenSeleccion();
                            actualizarEstadoBotonPagar();
                        }
                    });
                }
    
                add(crearLabels.botonlabel(String.valueOf(i + 1), x, y - 20, 100, 20, 16)); // Agregar el label al panel
                add(asientos[index]); // Agregar el botón al panel
                x += 110; // Separación horizontal entre botones de asiento
                if ((index + 1) % 5 == 0) {
                    if (y == 150) {
                        y += 50;
                    }
                    x = 10;
                    y += 50; // Avanzar a la siguiente fila
                }
                index++;
            }
        }
    }     

     /**
     * Cuenta el número de asientos seleccionados.
     * 
     * @return Número de asientos seleccionados.
     */
    private int contarAsientosSeleccionados() {
        int contador = 0;
        for (boolean seleccionado : asientosSeleccionados) {
            if (seleccionado) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Determina el tipo de asiento basado en el índice proporcionado.
     *
     * @param index Índice del asiento a determinar
     * @return Tipo de asiento ("Semi cama", "Salón cama" o "Normal")
     */
    private String determinarTipoAsiento(int index) {
        if (index < 10) {
            return "Semi cama";
        } else if (index < 30) {
            return "Salón cama";
        } else {
            return "Normal";
        }
    }

    /**
     * Actualiza el estado del botón "Ir a pagar" según la cantidad de asientos seleccionados.
     */
    private void actualizarEstadoBotonPagar() {
        int seleccionados = contarAsientosSeleccionados();
        botonIrAPagar.setEnabled(seleccionados > 0); // Habilitar el botón "Ir a pagar" si hay asientos seleccionados
    }

    /**
     * Genera y muestra un resumen de la selección de asientos en un JTextArea.
     * Incluye el tipo de asiento, el número de asientos la cantidad de cada tipo de asiento seleccionado y el precio total.
     */
    private void ResumenSeleccion() {
        // Generar el resumen de selección
        StringBuilder resumen = new StringBuilder();
        resumen.append("Resumen de selección:\n");

        int semiCamaCount = 0;
        int salonCamaCount = 0;
        int normalCount = 0;

        for (int i = 0; i < asientosSeleccionados.length; i++) {
            if (asientosSeleccionados[i]) {
                String tipoAsiento = determinarTipoAsiento(i);
                resumen.append(tipoAsiento).append(" - Asiento ").append(i + 1).append("\n");

                switch (tipoAsiento) {
                    case "Semi cama":
                        semiCamaCount++;
                        break;
                    case "Salón cama":
                        salonCamaCount++;
                        break;
                    case "Normal":
                        normalCount++;
                        break;
                }
            }
        }
        resumen.append("Cantidad de asientos seleccionados: " +  contarAsientosSeleccionados() + "\n");
        resumen.append("Total semi cama: ").append(semiCamaCount).append("\n");
        resumen.append("Total salón cama: ").append(salonCamaCount).append("\n");
        resumen.append("Total normal: ").append(normalCount).append("\n");
        resumen.append("Precio: $").append(semiCamaCount * 15000 + salonCamaCount * 20000 + normalCount * 12000);

        areaResumen.setText(resumen.toString()); // Mostrar el resumen en el JTextArea
    }

    /**
     * Guarda un resumen de la selección de asientos en el archivo "selecciones.txt".
     * Además de guardar el resumen, actualiza visualmente los botones de los asientos y deselecciona los asientos seleccionados.
     * dado a que este método se usa al cambiar de panel
     * @param e El evento de acción que desencadenó la llamada al método.
     */
    private void guardarSeleccion(ActionEvent e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("selecciones.txt", true))) {
            // Generar el resumen de selección
            StringBuilder resumen = new StringBuilder();
            resumen.append("Resumen de selección:\n");
    
            int semiCamaCount = 0;
            int salonCamaCount = 0;
            int normalCount = 0;
    
            for (int i = 0; i < asientosSeleccionados.length; i++) {
                if (asientosSeleccionados[i]) {
                    String tipoAsiento = determinarTipoAsiento(i);
                    resumen.append(tipoAsiento).append(" - Asiento ").append(i + 1).append("\n");
    
                    switch (tipoAsiento) {
                        case "Semi cama":
                            semiCamaCount++;
                            break;
                        case "Salón cama":
                            salonCamaCount++;
                            break;
                        case "Normal":
                            normalCount++;
                            break;
                    }
    
                    // Deseleccionar el asiento
                    asientosSeleccionados[i] = false;
                }
            }
            resumen.append("Cantidad de asientos seleccionados: ").append(contarAsientosSeleccionados()).append("\n");
            resumen.append("Total semi cama: ").append(semiCamaCount).append("\n");
            resumen.append("Total salón cama: ").append(salonCamaCount).append("\n");
            resumen.append("Total normal: ").append(normalCount).append("\n");
            resumen.append("Precio: $").append(semiCamaCount * 15000 + salonCamaCount * 20000 + normalCount * 12000);
    
            areaResumen.setText(resumen.toString()); // Actualizar el JTextArea con el resumen
    
            // Actualizar visualmente los botones de asientos
            actualizarPanel();
    
            writer.println(resumen.toString()); // Guardar el resumen en el archivo
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
}