package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JPanelAsientos extends JPanel {

    private JPanelDestino paneldestino;
    private Cambiodeescena cambiodeescena;
    private CrearBoton crear;
    private CrearLabels crearLabels;
    private JButton[] asientosPiso1;
    private JButton[] asientosPiso2;
    private boolean piso1 = true; // Por defecto, la opción 1 está seleccionada
    private boolean[] asientosSeleccionados; // Array para almacenar los asientos seleccionados
    private JTextArea areaResumen; // JTextArea para mostrar el resumen de selección
    

    public JPanelAsientos(Cambiodeescena cambiodeescena, JPanelDestino paneldestino) {
        this.cambiodeescena = cambiodeescena;
        this.paneldestino = paneldestino;
        crear = new CrearBoton(cambiodeescena);
        setLayout(null); // Layout absoluto para posicionar componentes manualmente
        this.setBackground(Color.GRAY);
        crearLabels = new CrearLabels();

        // Inicializar JTextArea para el resumen de selección
        areaResumen = new JTextArea();
        areaResumen.setBounds(600, 100, 400, 100); // Ajusta las coordenadas y el tamaño según sea necesario
        areaResumen.setEditable(false); // Para evitar que se pueda editar manualmente
        add(areaResumen); // Agrega el JTextArea al panel

        // Inicializar array de asientos seleccionados
        asientosSeleccionados = new boolean[40]; // Total de asientos en ambos pisos

        // Crear los botones de opción usando CrearBoton
        crearBotonPiso("Piso 1", true, 50);
        crearBotonPiso("Piso 2", false, 200);

        // Botón para volver
        add(crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, paneldestino));

        // Inicialmente, mostrar los componentes correspondientes a la opción 1
        actualizarPanel();
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

        // Volver a crear los botones de opción
        crearBotonPiso("Piso 1", piso1, 50);
        crearBotonPiso("Piso 2", !piso1, 200);

        // Botón para volver
        add(crear.botonsimplecrear("Volver", 300, 450, 150, 50, this, paneldestino));

        // Crear los asientos según el piso seleccionado
        crearAsientos(piso1 ? asientosPiso1 : asientosPiso2, piso1 ? 0 : 20, piso1 ? 20 : 40);

        // Actualizar el resumen de selección
        ResumenSelección();

        add(areaResumen); // Agrega el JTextArea al panel

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

    private void ResumenSelección() {
        int totalAsientos = asientosSeleccionados.length;
        int saloncama = 0, semicama = 0, normal = 0;

        for (int i = 0; i < totalAsientos; i++) {
            if (asientosSeleccionados[i]) {
                String tipoAsiento = determinarTipoAsiento(i);
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

        // Actualizar el JTextArea con el resumen de selección
        StringBuilder sb = new StringBuilder();
        sb.append("Resumen de Selección:\n");
        sb.append("Total de Asientos Ocupados: ").append(contarAsientosSeleccionados()).append("\n");
        sb.append("Saloncama: ").append(saloncama).append("\n");
        sb.append("Semicama: ").append(semicama).append("\n");
        sb.append("Normal: ").append(normal).append("\n");
        sb.append("Precio: ").append(saloncama *100 + semicama *200 + normal*300).append("\n");

        areaResumen.setText(sb.toString());
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
}