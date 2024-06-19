package Interfaz;

import javax.swing.*;
import java.awt.*;

public class JPanelDestino extends JPanel {

    //Instancias de clases relacionadas con la etapa de 'destino'
    private JPanelComprar comprarpanel;  
    private JPanelMenú volveralmenú;    
    private Cambiodeescena cambiodeescena;  
    private CrearBoton crear;   
    private CrearLabels labels; 

    // Variables de estado para indicar la selección
    private boolean destinoSeleccionado = false;
    private boolean tipoViajeSeleccionado = false;
    private boolean horaSalidaSeleccionada = false;

    //constructor
    public JPanelDestino(Cambiodeescena cambiodeescena, JPanelComprar panelComprar) {

        //inicilización de instancias
        this.cambiodeescena = cambiodeescena;
        this.comprarpanel = panelComprar;
        crear = new CrearBoton(cambiodeescena);
        labels = new CrearLabels();
        this.setBackground(Color.YELLOW);
        setLayout(null); // Layout absoluto para posicionar componentes manualmente

        //labels
        add(labels.botonlabel("Seleccionar destino", 250, 30, 300, 50));
        add(labels.botonlabel("Destinos", 100, 100, 300, 50));
        add(labels.botonlabel("Tipo de viaje", 300, 100, 300, 50));
        add(labels.botonlabel("Horarios", 500, 100, 300, 50));

        // Agregar acciones a los botones complejos de destinos y tipo de viaje
        agregarAccionBoton(crear.botoncomplejocrear("Destino 1", 100, 150, 150, 50), () -> destinoSeleccionado = true);
        agregarAccionBoton(crear.botoncomplejocrear("Destino 2", 100, 250, 150, 50), () -> destinoSeleccionado = true);
        agregarAccionBoton(crear.botoncomplejocrear("Destino 3", 100, 350, 150, 50), () -> destinoSeleccionado = true);
        agregarAccionBoton(crear.botoncomplejocrear("Ida y vuelta", 300, 200, 150, 50), () -> tipoViajeSeleccionado = true);
        agregarAccionBoton(crear.botoncomplejocrear("Ida", 300, 300, 150, 50), () -> tipoViajeSeleccionado = true);
        agregarAccionBoton(crear.botoncomplejocrear("Hora de salida", 500, 250, 150, 50), () -> horaSalidaSeleccionada = true);

        // Botón para deseleccionar todo
        JButton deseleccionarBoton = crear.botoncomplejocrear("Deseleccionar", 100, 450, 150, 50);
        deseleccionarBoton.addActionListener(e -> deseleccionar());
        add(deseleccionarBoton);

        // Botón para volver al panel de 'compra'
        add(crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, panelComprar));

        // Botón para ver los asientos (inicialmente deshabilitado hasta seleccionar un destino, tipo de viaje, hora)
        // por el momento no existe una destinación después de este punto, por eso el 2do parametro de jpanel es null
        JButton verAsientos = crear.botonsimplecrear("Ver asiento", 500, 450, 150, 50, this, null);
        verAsientos.setEnabled(false);
        add(verAsientos);

        // Actualizar estado inicial del botón "Ver asiento"
        actualizarEstadoBotonVerAsiento();
    }

    // Método para agregar acción a un botón y actualizar estado del botón "Ver asiento"
    private void agregarAccionBoton(JButton boton, Runnable action) {
        boton.addActionListener(e -> {
            action.run();  // Ejecutar la acción específica del botón
            actualizarEstadoBotonVerAsiento();  // Actualizar el estado del botón "Ver asiento"
        });
        add(boton);  // Agregar el botón al panel
    }

    // Método para actualizar el estado del botón "Ver asiento"
    private void actualizarEstadoBotonVerAsiento() {
        JButton verAsientos = (JButton) getComponent(getComponentCount() - 1); // Obtener el botón "Ver asiento"

        // Habilitar el botón si todas las condiciones están seleccionadas, deshabilitar si no
        if (destinoSeleccionado && tipoViajeSeleccionado && horaSalidaSeleccionada) {
            verAsientos.setEnabled(true);
        } else {
            verAsientos.setEnabled(false);
        }
    }

    // Método para deseleccionar todo y actualizar el estado del botón "Ver asiento"
    private void deseleccionar() {
        destinoSeleccionado = false;
        tipoViajeSeleccionado = false;
        horaSalidaSeleccionada = false;
        actualizarEstadoBotonVerAsiento(); 
    }
}