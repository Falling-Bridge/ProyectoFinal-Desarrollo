package Interfaz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clase para obtener la fecha actual y formatearla según el formato dd/MM/yyyy.
 */
public class ObtenerFecha {

    /**
     * Método para obtener la fecha y desplazar la misma
     *
     * @param daysOffset Número de días para desplazar la fecha actual.
     * @return Fecha formateada en formato dd/MM/yyyy.
     */
    public static String getDateFormatted(int daysOffset) {
        // Obtener la fecha actual
        LocalDate currentDate = LocalDate.now();

        // Aplicar el desplazamiento en días
        LocalDate targetDate = currentDate.plusDays(daysOffset);

        // Definir el formato
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Formatear la fecha
        return targetDate.format(formatter);  
    }
}