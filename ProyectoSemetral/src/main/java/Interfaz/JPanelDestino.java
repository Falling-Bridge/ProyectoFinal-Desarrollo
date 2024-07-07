package Interfaz;

import Logica.Buses.*;
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
    private ModeloBus busbase;
    private String fecha1;
    private String fecha2;
    private String fecha3;

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

        //se crea el bus
        busbase = new Bus();
        //labels
        add(labels.botonlabel("Seleccionar destino", 250, 30, 300, 50, 25));
        add(labels.botonlabel("Destinos", 20, 100, 300, 50, 25));
        add(labels.botonlabel("Tipo de viaje", 220, 100, 300, 50, 25));
        add(labels.botonlabel("Horarios", 420, 100, 300, 50, 25));
        add(labels.botonlabel("Fechas", 620, 100, 300, 50, 25));

        // Botones complejos para destinos, tipos de viaje, hora y fecha
        add(crear.botoncomplejocrear("Santiago", 20, 150, 150, 50, e -> { destinoSeleccionado = "Santiago"; actualizarEstadoBotonVerAsiento(); }));//aqui hay q cambiar la wea, para q se añadan las cosas, tengo q crear un metodo q esto me guarde un selector, y me modifi el selector segun el boton, y al apretar el ver asientosse añadan los decoradores al bus
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

        // Botón para deseleccionar todo
        add(crear.botoncomplejocrear("Deseleccionar", 100, 450, 150, 50, e -> deseleccionar()));

        // Botón para volver al panel de 'compra'
        JButton volverButton = crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, panelComprar);
        volverButton.addActionListener(e -> manejoArchivo.eliminarLineaConcreta("Las Galaxias","Sololda","Eme Bus")); // Eliminar la línea que contiene el nombre de la compañía
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

    private void busdecorator(){
        if(destinoSeleccionado == "Santiago"){
            busbase = new BusDestinoSntg(busbase);
        }
        else if(destinoSeleccionado == "Talca"){
            busbase = new BusDestinoTalca(busbase);
        }
        else if(destinoSeleccionado == "Chillan"){
            busbase = new BusDestinoChillan(busbase);
        }
        if(horaSalidaSeleccionada == "07:00 AM"){
            busbase = new BusHoraSalida07AM(busbase);
        }
        else if(horaSalidaSeleccionada == "12:00 PM"){
            busbase = new BusHoraSalida12PM(busbase);
        }
        else if(horaSalidaSeleccionada == "17:00 PM"){
            busbase = new BusHoraSalida17PM(busbase);
        }
        if(fechaSeleccionada == fecha1){
            busbase = new BusFecha(busbase, fecha1, 1500);
        }
        else if(fechaSeleccionada == fecha2){
            busbase = new BusFecha(busbase, fecha2, 1000);
        }
        else if(fechaSeleccionada ==fecha3){
            busbase = new BusFecha(busbase, fecha3, 500);
        }
    }

    private void guardarSeleccion(ActionEvent e) {
        crear.guardarseleccion(destinoSeleccionado, tipoViajeSeleccionado, horaSalidaSeleccionada, fechaSeleccionada);
        busdecorator();
        deseleccionar(); // Llamar al método deseleccionar después de guardar la selección
    }
    
    private void deseleccionar() {
        destinoSeleccionado = "";
        tipoViajeSeleccionado = "";
        horaSalidaSeleccionada = "";
        fechaSeleccionada = "";
        actualizarEstadoBotonVerAsiento();
    }
}