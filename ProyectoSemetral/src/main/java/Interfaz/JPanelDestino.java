package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JPanelDestino extends JPanel {

    // Instancias de clases relacionadas con la etapa de 'destino'
    private JPanelComprar comprarpanel;
    private JPanelAsientos panelasientos;
    private Cambiodeescena cambiodeescena;
    private CrearBoton crear;
    private CrearLabels labels;
    private ManejoArchivo manejoArchivo;
    private String destinoSeleccionado = "";
    private String tipoViajeSeleccionado = "";
    private String horaSalidaSeleccionada = "";
    private String fechaSeleccionada = "";
    private JButton verAsientos;

    public JPanelDestino(Cambiodeescena cambiodeescena, JPanelComprar panelComprar, JPanelMenú panelMenú, JPanelMisPasajes misPasajes) {
        // Inicialización de instancias
        this.cambiodeescena = cambiodeescena;
        this.comprarpanel = panelComprar;
        panelasientos = new JPanelAsientos(cambiodeescena, this, panelMenú, misPasajes);
        crear = new CrearBoton(cambiodeescena);
        labels = new CrearLabels();
        manejoArchivo = new ManejoArchivo();
        this.setBackground(Color.YELLOW);
        setLayout(null); // Layout absoluto para posicionar componentes manualmente

        //labels
        add(labels.botonlabel("Seleccionar destino", 250, 30, 300, 50, 25));
        add(labels.botonlabel("Destinos", 20, 100, 300, 50, 25));
        add(labels.botonlabel("Tipo de viaje", 220, 100, 300, 50, 25));
        add(labels.botonlabel("Horarios", 420, 100, 300, 50, 25));
        add(labels.botonlabel("Fechas", 620, 100, 300, 50, 25));

        // Botones complejos para destinos, tipos de viaje, hora y fecha
        add(crear.botoncomplejocrear("Destino 1", 20, 150, 150, 50, e -> { destinoSeleccionado = "Destino 1"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("Destino 2", 20, 250, 150, 50, e -> { destinoSeleccionado = "Destino 2"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("Destino 3", 20, 350, 150, 50, e -> { destinoSeleccionado = "Destino 3"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("Ida y vuelta", 220, 200, 150, 50, e -> { tipoViajeSeleccionado = "Ida y vuelta"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("Ida", 220, 300, 150, 50, e -> { tipoViajeSeleccionado = "Ida"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("07:00 AM", 420, 150, 150, 50, e -> { horaSalidaSeleccionada = "07:00 AM"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("12:00 PM", 420, 250, 150, 50, e -> { horaSalidaSeleccionada = "12:00 PM"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("17:00 PM", 420, 350, 150, 50, e -> { horaSalidaSeleccionada = "17:00 PM"; actualizarEstadoBotonVerAsiento(); }));
        String fecha1 = ObtenerFecha.getDateFormatted(0); // Fecha de hoy
        String fecha2 = ObtenerFecha.getDateFormatted(1); // Fecha de mañana
        String fecha3 = ObtenerFecha.getDateFormatted(2); // Fecha de pasado mañana
        add(crear.botoncomplejocrear(fecha1, 620, 150, 150, 50, e -> { fechaSeleccionada = fecha1; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear(fecha2, 620, 250, 150, 50, e -> { fechaSeleccionada = fecha2; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear(fecha3, 620, 350, 150, 50, e -> { fechaSeleccionada = fecha3; actualizarEstadoBotonVerAsiento(); }));

        // Botón para deseleccionar todo
        add(crear.botoncomplejocrear("Deseleccionar", 100, 450, 150, 50, e -> deseleccionar()));

        // Botón para volver al panel de 'compra'
        JButton volverButton = crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, panelComprar);
        volverButton.addActionListener(e -> manejoArchivo.eliminarLineaConcreta("Compañia")); // Eliminar la línea que contiene "Compañia"
        add(volverButton);

        // Botón para ver los asientos (inicialmente deshabilitado hasta seleccionar un destino, tipo de viaje, hora)
        verAsientos = crear.botonsimplecrear("Ver asiento", 500, 450, 150, 50, this, panelasientos);
        verAsientos.setEnabled(false);
        verAsientos.addActionListener(this::guardarSeleccion); // Agregar acción para guardar selecciones
        add(verAsientos);
    }

    private void actualizarEstadoBotonVerAsiento() {
        verAsientos.setEnabled(!destinoSeleccionado.isEmpty() && !tipoViajeSeleccionado.isEmpty() && !horaSalidaSeleccionada.isEmpty() && !fechaSeleccionada.isEmpty());
    }

    private void guardarSeleccion(ActionEvent e) {
        crear.guardarseleccion(destinoSeleccionado, tipoViajeSeleccionado, horaSalidaSeleccionada, fechaSeleccionada);
    }

    private void deseleccionar() {
        destinoSeleccionado = "";
        tipoViajeSeleccionado = "";
        horaSalidaSeleccionada = "";
        fechaSeleccionada = "";
        actualizarEstadoBotonVerAsiento();
    }
}