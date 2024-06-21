package Interfaz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ObtenerFecha {

    // Método para obtener la fecha actual en el formato dd/MM/yyyy
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