package Interfaz;

import javax.swing.*;
import java.awt.*;

public class JPanelDestino extends JPanel {

    //Instancias de clases relacionadas con la etapa de 'destino'
    private JPanelComprar comprarpanel;  
    private JPanelAsientos panelasientos; 
    private Cambiodeescena cambiodeescena;  
    private CrearBoton crear;   
    private CrearLabels labels; 

    // Variables de estado para indicar la selección
    private boolean destinoSeleccionado = false;
    private boolean tipoViajeSeleccionado = false;
    private boolean horaSalidaSeleccionada = false;
    private boolean fechaSeleccionada = false;

    //constructor
    public JPanelDestino(Cambiodeescena cambiodeescena, JPanelComprar panelComprar) {

        //inicilización de instancias
        this.cambiodeescena = cambiodeescena;
        this.comprarpanel = panelComprar;
        panelasientos = new JPanelAsientos(cambiodeescena, this);
        crear = new CrearBoton(cambiodeescena);
        labels = new CrearLabels();
        this.setBackground(Color.YELLOW);
        setLayout(null); // Layout absoluto para posicionar componentes manualmente

        //labels
        add(labels.botonlabel("Seleccionar destino", 250, 30, 300, 50, 25));
        add(labels.botonlabel("Destinos", 20, 100, 300, 50, 25));
        add(labels.botonlabel("Tipo de viaje", 220, 100, 300, 50, 25));
        add(labels.botonlabel("Horarios", 420, 100, 300, 50, 25));
        add(labels.botonlabel("Fechas", 620, 100, 300, 50, 25));

        // Agregar acciones a los botones complejos de destinos y tipo de viaje
        agregarAccionBoton(crear.botoncomplejocrear("Destino 1", 20, 150, 150, 50), () -> destinoSeleccionado = true);
        agregarAccionBoton(crear.botoncomplejocrear("Destino 2", 20, 250, 150, 50), () -> destinoSeleccionado = true);
        agregarAccionBoton(crear.botoncomplejocrear("Destino 3", 20, 350, 150, 50), () -> destinoSeleccionado = true);
        agregarAccionBoton(crear.botoncomplejocrear("Ida y vuelta", 220, 200, 150, 50), () -> tipoViajeSeleccionado = true);
        agregarAccionBoton(crear.botoncomplejocrear("Ida", 220, 300, 150, 50), () -> tipoViajeSeleccionado = true);
        agregarAccionBoton(crear.botoncomplejocrear("07:00 AM", 420, 150, 150, 50), () -> horaSalidaSeleccionada = true);
        agregarAccionBoton(crear.botoncomplejocrear("12:00 PM", 420, 250, 150, 50), () -> horaSalidaSeleccionada = true);
        agregarAccionBoton(crear.botoncomplejocrear("17:00 PM", 420, 350, 150, 50), () -> horaSalidaSeleccionada = true);

        // Crear fechas formateadas
        String fecha1 = ObtenerFecha.getDateFormatted(0); // Fecha de hoy
        String fecha2 = ObtenerFecha.getDateFormatted(1); // Fecha de mañana
        String fecha3 = ObtenerFecha.getDateFormatted(2); // Fecha de pasado mañana

        // Agregar botones de fecha
        agregarAccionBoton(crear.botoncomplejocrear(fecha1, 620, 150, 150, 50), () -> fechaSeleccionada = true);
        agregarAccionBoton(crear.botoncomplejocrear(fecha2, 620, 250, 150, 50), () -> fechaSeleccionada = true);
        agregarAccionBoton(crear.botoncomplejocrear(fecha3, 620, 350, 150, 50), () -> fechaSeleccionada = true);

        // Botón para deseleccionar todo
        JButton deseleccionarBoton = crear.botoncomplejocrear("Deseleccionar", 100, 450, 150, 50);
        deseleccionarBoton.addActionListener(e -> deseleccionar());
        add(deseleccionarBoton);

        // Botón para volver al panel de 'compra'
        add(crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, panelComprar));

        // Botón para ver los asientos (inicialmente deshabilitado hasta seleccionar un destino, tipo de viaje, hora)
        // por el momento no existe una destinación después de este punto, por eso el 2do parametro de jpanel es null
        JButton verAsientos = crear.botonsimplecrear("Ver asiento", 500, 450, 150, 50, this, panelasientos);
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
        if (destinoSeleccionado && tipoViajeSeleccionado && horaSalidaSeleccionada && fechaSeleccionada) {
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
        fechaSeleccionada = false; // Asegurarse de restablecer también la selección de fecha
        actualizarEstadoBotonVerAsiento(); 
    }
}