package Interfaz;

import Logica.Buses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Clase que permite al usuario seleccionar destino, tipo de viaje, hora de salida y fecha para buscar disponibilidad de asientos.
 */
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
    public ModeloBus busbase;
    private String fecha1;
    private String fecha2;
    private String fecha3;

    /**
     * Constructor 
     * @param cambiodeescena Instancia de la clase Cambiodeescena para gestionar el cambio de paneles.
     * @param panelComprar   Panel de compra de pasajes desde el cual se accede al panel de destino.
     * @param panelMenú      Panel del menú principal.
     * @param misPasajes     Panel de pasajes comprados.
     * @throws Exception     Lanza excepción si ocurre un error durante la inicialización.
     */
    public JPanelDestino(Cambiodeescena cambiodeescena, JPanelComprar panelComprar, JPanelMenú panelMenú, JPanelMisPasajes misPasajes) throws Exception {
        // Inicialización de instancias
        this.cambiodeescena = cambiodeescena;
        this.comprarpanel = panelComprar;
        busbase = panelComprar.busbasec;
        panelasientos = new JPanelAsientos(cambiodeescena, this, panelMenú, misPasajes);
        crear = new CrearBoton(cambiodeescena);
        labels = new CrearLabels();
        manejoArchivo = new ManejoArchivo();
        this.setBackground(Color.YELLOW);
        setLayout(null); // Layout absoluto para posicionar componentes manualmente

        // Etiquetas para selección de destino, tipo de viaje, hora y fecha
        add(labels.botonlabel("Seleccionar destino", 250, 30, 300, 50, 25));
        add(labels.botonlabel("Destinos", 20, 100, 300, 50, 25));
        add(labels.botonlabel("Tipo de viaje", 220, 100, 300, 50, 25));
        add(labels.botonlabel("Horarios", 420, 100, 300, 50, 25));
        add(labels.botonlabel("Fechas", 620, 100, 300, 50, 25));

        // Botones complejos para selección de destinos, tipo de viaje, hora y fecha
        add(crear.botoncomplejocrear("Santiago", 20, 150, 150, 50, e -> { destinoSeleccionado = "Santiago"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("Talca", 20, 250, 150, 50, e -> { destinoSeleccionado = "Talca"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("Chillan", 20, 350, 150, 50, e -> { destinoSeleccionado = "Chillan"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("Ida y vuelta", 220, 200, 150, 50, e -> { tipoViajeSeleccionado = "Ida y vuelta"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("Ida", 220, 300, 150, 50, e -> { tipoViajeSeleccionado = "Ida"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("07:00 AM", 420, 150, 150, 50, e -> { horaSalidaSeleccionada = "07:00 AM"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("12:00 PM", 420, 250, 150, 50, e -> { horaSalidaSeleccionada = "12:00 PM"; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear("17:00 PM", 420, 350, 150, 50, e -> { horaSalidaSeleccionada = "17:00 PM"; actualizarEstadoBotonVerAsiento(); }));
        fecha1 = ObtenerFecha.getDateFormatted(0); // Fecha de hoy
        fecha2 = ObtenerFecha.getDateFormatted(1); // Fecha de mañana
        fecha3 = ObtenerFecha.getDateFormatted(2); // Fecha de pasado mañana
        add(crear.botoncomplejocrear(fecha1, 620, 150, 150, 50, e -> { fechaSeleccionada = fecha1; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear(fecha2, 620, 250, 150, 50, e -> { fechaSeleccionada = fecha2; actualizarEstadoBotonVerAsiento(); }));
        add(crear.botoncomplejocrear(fecha3, 620, 350, 150, 50, e -> { fechaSeleccionada = fecha3; actualizarEstadoBotonVerAsiento(); }));

        // Botón para deseleccionar todas las opciones seleccionadas
        add(crear.botoncomplejocrear("Deseleccionar", 100, 450, 150, 50, e -> deseleccionar()));

        // Botón para volver al panel de 'compra'
        JButton volverButton = crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, panelComprar);
        volverButton.addActionListener(e -> manejoArchivo.eliminarLineaConcreta("Las Galaxias","Sololda","Eme Bus")); // Eliminar la línea que contiene el nombre de la compañía
        add(volverButton);

        // Botón para ver los asientos (inicialmente deshabilitado hasta seleccionar destino, tipo de viaje, hora y fecha)
        verAsientos = crear.botonsimplecrear("Ver asiento", 500, 450, 150, 50, this, panelasientos);
        verAsientos.setEnabled(false);
        verAsientos.addActionListener(this::guardarSeleccion); // Agregar acción para guardar selecciones
        add(verAsientos);
    }

    /**
     * Método privado para actualizar el estado del botón "Ver asientos".
     * Habilita o deshabilita el botón dependiendo de si se han seleccionado destino, tipo de viaje, hora y fecha.
     */
    private void actualizarEstadoBotonVerAsiento() {
        verAsientos.setEnabled(!destinoSeleccionado.isEmpty() && !tipoViajeSeleccionado.isEmpty() && !horaSalidaSeleccionada.isEmpty() && !fechaSeleccionada.isEmpty());
    }

    /**
     * Método privado para aplicar decoradores al bus seleccionado según las selecciones de destino, hora y fecha.
     *
     * @throws Exception Lanza excepción si ocurre un error durante la aplicación de los decoradores.
     */
    private void busdecorator() throws Exception {
        if(destinoSeleccionado.equals("Santiago")){
            busbase = new BusDestinoSntg(busbase);
        }
        else if(destinoSeleccionado.equals("Talca")){
            busbase = new BusDestinoTalca(busbase);
        }
        else if(destinoSeleccionado.equals("Chillan")){
            busbase = new BusDestinoChillan(busbase);
        }
        if(horaSalidaSeleccionada.equals("07:00 AM")){
            busbase = new BusHoraSalida07AM(busbase);
        }
        else if(horaSalidaSeleccionada.equals("12:00 PM")){
            busbase = new BusHoraSalida12PM(busbase);
        }
        else if(horaSalidaSeleccionada.equals("17:00 PM")){
            busbase = new BusHoraSalida17PM(busbase);
        }
        if(fechaSeleccionada.equals(fecha1)){
            busbase = new BusFecha(busbase, fecha1, 1500);
        }
        else if(fechaSeleccionada.equals(fecha2)){
            busbase = new BusFecha(busbase, fecha2, 1000);
        }
        else if(fechaSeleccionada.equals(fecha3)){
            busbase = new BusFecha(busbase, fecha3, 500);
        }
    }

    /**
     * Método privado para guardar la selección actual de destino, tipo de viaje, hora y fecha al presionar el botón "Ver asientos".
     *
     * @param e Evento de acción que activa el guardado de selecciones.
     */
    private void guardarSeleccion(ActionEvent e) {
        crear.guardarseleccion(destinoSeleccionado, tipoViajeSeleccionado, horaSalidaSeleccionada, fechaSeleccionada);
        deseleccionar(); // Limpiar selecciones después de guardar
    }

    /**
     * Método privado para deseleccionar todas las opciones de destino, tipo de viaje, hora y fecha seleccionadas.
     */
    private void deseleccionar() {
        destinoSeleccionado = "";
        tipoViajeSeleccionado = "";
        horaSalidaSeleccionada = "";
        fechaSeleccionada = "";
        actualizarEstadoBotonVerAsiento();
    }
}