package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

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

    public JPanelAsientos(Cambiodeescena cambiodeescena, JPanelDestino paneldestino, JPanelMenú panelMenú, JPanelMisPasajes misPasajes) {
        this.cambiodeescena = cambiodeescena;
        this.paneldestino = paneldestino;
        panelPagar = new JPanelPagar(cambiodeescena, this, panelMenú, misPasajes);
        crear = new CrearBoton(cambiodeescena);
        setLayout(null); // Layout absoluto para posicionar componentes manualmente
        this.setBackground(Color.GRAY);
        crearLabels = new CrearLabels();

        // Inicializar JTextArea para el resumen de selección
        areaResumen = new JTextArea();
        areaResumen.setEditable(false);
        scrollResumen = new JScrollPane(areaResumen);
        scrollResumen.setBounds(560, 100, 250, 200);
        scrollResumen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollResumen);
        
        asientosSeleccionados = new boolean[40];

        crearBotonPiso("Piso 1", true, 50);
        crearBotonPiso("Piso 2", false, 200);
        add(crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, paneldestino));
        botonIrAPagar = crear.botonsimplecrear("Ir a pagar", 500, 450, 150, 50, this, panelPagar);
        botonIrAPagar.setEnabled(false);
        botonIrAPagar.addActionListener(this::guardarSeleccion);
        add(botonIrAPagar);

        actualizarPanel();
        
        // Agregar ActionListener al botón 'Volver'
        JButton volverButton = crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, paneldestino);
        volverButton.addActionListener(e -> {
            manejoArchivo.eliminarLineasPosterioresYCantidad("Compañia", 4); // Ajusta el número de líneas a eliminar según tu necesidad
            cambiodeescena.changeScene(this, paneldestino);
        });
        add(volverButton);
    }

    private void crearBotonPiso(String texto, boolean selected, int x) {
        JRadioButton botonpiso = crear.crearRadioButton(texto, selected, x, 50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piso1 = texto.equals("Piso 1");
                actualizarPanel();
            }
        });
        add(botonpiso);
    }

    private void actualizarPanel() {
        removeAll();

        crearBotonPiso("Piso 1", piso1, 50);
        crearBotonPiso("Piso 2", !piso1, 200);
        JButton volverButton = crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, paneldestino);
        volverButton.addActionListener(e -> {
            manejoArchivo.eliminarLineasPosterioresYCantidad("Compañia", 4); // Ajusta el número de líneas a eliminar según tu necesidad
            cambiodeescena.changeScene(this, paneldestino);
        });
        add(volverButton);
        add(botonIrAPagar);
        crearAsientos(piso1 ? asientosPiso1 : asientosPiso2, piso1 ? 0 : 20, piso1 ? 20 : 40);
        ResumenSelección();
        add(scrollResumen);
        revalidate();
        repaint();
    }

    private void crearAsientos(JButton[] asientos, int inicio, int fin) {
        if (asientos == null) {
            asientos = new JButton[fin - inicio]; // Crear array de botones de asientos
        }

        int x = 10, y = 100;
        int index = 0;
        for (int i = inicio; i < fin; i++) {
            if (asientos[index] == null) {
                asientos[index] = new JButton("Asiento " + (i + 1));
            }
            String tipoAsiento = determinarTipoAsiento(i);
            asientos[index].setText(tipoAsiento); // Texto del botón como tipo de asiento
            asientos[index].setBounds(x, y, 100, 30); // Tamaño y posición de cada botón de asiento
            asientos[index].setBackground(asientosSeleccionados[i] ? Color.GREEN : Color.RED); // Color inicial del
                                                                                               // asiento basado en el
                                                                                               // estado seleccionado
            final int asientoIndex = i;
            asientos[index].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    asientosSeleccionados[asientoIndex] = !asientosSeleccionados[asientoIndex]; // Cambiar el estado del
                                                                                                // asiento seleccionado
                    JButton boton = (JButton) e.getSource();
                    boton.setBackground(asientosSeleccionados[asientoIndex] ? Color.GREEN : Color.RED); // Cambiar el color del botón según
                                                                                                        // el estado seleccionado
                    // Actualizar el resumen de selección
                    ResumenSelección();
                    actualizarEstadoBotonPagar();
                }
            });

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

        // Asignar los botones creados al arreglo correspondiente según el piso
        if (piso1) {
            asientosPiso1 = asientos;
        } else {
            asientosPiso2 = asientos;
        }
    }

    private int contarAsientosSeleccionados() {
        int seleccionados = 0;
        for (boolean seleccionado : asientosSeleccionados) {
            if (seleccionado) {
                seleccionados++;
            }
        }
        return seleccionados;
    }

    private String determinarTipoAsiento(int index) {
        // Ejemplo de lógica para determinar el tipo de asiento basado en el índice
        if (index % 3 == 0) {
            return "Saloncama";
        } else if (index % 3 == 1) {
            return "Semicama";
        } else {
            return "Normal";
        }
    }

    private String ResumenSelección() {
        int totalAsientos = asientosSeleccionados.length;
        int saloncama = 0, semicama = 0, normal = 0;
        StringBuilder asientosDetalle = new StringBuilder();

        for (int i = 0; i < totalAsientos; i++) {
            if (asientosSeleccionados[i]) {
                String tipoAsiento = determinarTipoAsiento(i);
                asientosDetalle.append("Asiento ").append(i + 1).append(": ").append(tipoAsiento).append("\n");
                switch (tipoAsiento) {
                    case "Saloncama":
                        saloncama++;
                        break;
                    case "Semicama":
                        semicama++;
                        break;
                    case "Normal":
                        normal++;
                        break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Resumen de Selección:\n");
        sb.append(asientosDetalle.toString());
        sb.append("Total de Asientos Ocupados: ").append(contarAsientosSeleccionados()).append("\n");
        if (saloncama != 0){
            sb.append("Saloncama: ").append(saloncama).append("\n");
        } if (semicama != 0){
            sb.append("Semicama: ").append(semicama).append("\n");
        } if (normal != 0){
            sb.append("Normal: ").append(normal).append("\n");
        }
        sb.append("Precio: ").append(saloncama * 100 + semicama * 200 + normal * 300);

        areaResumen.setText(sb.toString());

        return sb.toString(); // Devuelve el resumen como String
    }

    private void guardarSeleccion(ActionEvent e) {
        if (botonIrAPagar.isEnabled()) {
            crear.guardarseleccion(ResumenSelección());
        }
    }
    
    private void deseleccionarTodosAsientos() {
        for (int i = 0; i < asientosSeleccionados.length; i++) {
            asientosSeleccionados[i] = false;
            // Actualizar visualmente el color de los botones de asientos
            if (piso1) {
                asientosPiso1[i].setBackground(Color.RED);
            } else {
                asientosPiso2[i - 20].setBackground(Color.RED);
            }
        }
        // Actualizar el resumen de selección
        ResumenSelección();
    }

    private void actualizarEstadoBotonPagar() {
        botonIrAPagar.setEnabled(contarAsientosSeleccionados() > 0);
    }
}