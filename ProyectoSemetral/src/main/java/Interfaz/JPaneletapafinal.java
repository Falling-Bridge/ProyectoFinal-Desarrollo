package Interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa el panel final de la interfaz gráfica, mostrando opciones para ir al menú principal o ver los pasajes comprados.
 */
public class JPaneletapafinal extends JPanel {

    private JPanelPagar panelPagar;
    private JPanelMisPasajes misPasajes;
    private Cambiodeescena cambiodeescena;
    private CrearBoton crear;
    private CrearLabels labels;

    /**
     * Constructor
     * @param cambiodeescena Instancia de la clase Cambiodeescena para gestionar el cambio de paneles.
     * @param panelPagar     Panel de pago desde el cual se accede al panel final.
     * @param panelMenú      Panel del menú principal.
     */
    public JPaneletapafinal(Cambiodeescena cambiodeescena, JPanelPagar panelPagar, JPanelMenú panelMenú) {
        this.cambiodeescena = cambiodeescena;
        this.panelPagar = panelPagar;
        this.misPasajes = new JPanelMisPasajes(cambiodeescena, panelMenú);
        crear = new CrearBoton(cambiodeescena);
        labels = new CrearLabels();
        
        setLayout(null); // Layout absoluto para posicionar componentes manualmente
        this.setBackground(Color.LIGHT_GRAY);
        
        // label con html para ofrecer las opciones disponibles
        add(labels.botonlabel("<html>Puedes ver tus pasajes<br>&nbsp;&nbsp;&nbsp;&nbsp;en 'Mis Pasajes' o<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ir al menú</html>", 
                                250, 100, 400, 300, 24));
        
        // Botones para navegar al menú principal o a la sección de mis pasajes
        add(crear.botonsimplecrear("Menú", 400, 450, 150, 50, this, panelMenú));
        add(crear.botonsimplecrear("Mis pasajes", 200, 450, 150, 50, this, misPasajes));
    }
}