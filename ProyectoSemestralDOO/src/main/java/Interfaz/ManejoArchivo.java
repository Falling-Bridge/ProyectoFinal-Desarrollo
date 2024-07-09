package Interfaz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para manejar operaciones relacionadas con archivos.
 * Permite copiar contenido de un archivo a otro, eliminar contenido de un archivo,
 * y realizar operaciones específicas como eliminar líneas según criterios definidos.
 */
public class    ManejoArchivo {

    /**
     * Método para copiar el contenido del archivo 'selecciones.txt' al archivo 'tickets.txt'.
     * Se omite cualquier línea que contenga "Resumen".
     * Si el archivo de origen no existe, muestra un mensaje de error.
     */
    public void copiarContenidoA() {
        File archivoOrigen = new File("selecciones.txt");
        File archivoNuevo = new File("tickets.txt");

        if (!archivoOrigen.exists()) {
            System.out.println("El archivo de origen no existe.");
            return;
        }

        try {
            List<String> lineas = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(archivoOrigen));
            String linea;

            // Leer todas las líneas del archivo de origen y almacenarlas en una lista
            while ((linea = reader.readLine()) != null) {
                if (!linea.contains("Resumen")) { // Ignorar líneas que contienen "Resumen"
                    lineas.add(linea);
                }
            }
            reader.close();

            // Verificar si el archivo nuevo tiene contenido
            boolean tieneContenido = archivoNuevo.exists() && archivoNuevo.length() > 0;

            // Escribir las líneas en el archivo nuevo, agregando una línea de separación si
            // tiene contenido
            PrintWriter writer = new PrintWriter(new FileWriter(archivoNuevo, true));
            if (tieneContenido) {
                writer.println("----------------------------");
            }
            for (String line : lineas) {
                writer.println(line);
            }
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace(); // Manejo de excepciones, puedes personalizar esto según tus necesidades
        }
    }

    /**
     * Método para eliminar todo el contenido de un archivo especificado por su nombre.
     *
     * @param nombre Nombre del archivo del cual se eliminará el contenido.
     */
    public void eliminarContenidoArchivo(String nombre) {
        File archivo = new File(nombre);

        if (!archivo.exists()) {
            return; // Si el archivo no existe, no hay contenido que eliminar
        }

        try {
            // Abrir el archivo para borrar el contenido
            PrintWriter writer = new PrintWriter(new FileWriter(archivo, false));
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace(); // Manejo de excepciones, puedes personalizar esto según tus necesidades
        }
    }

    /**
     * Método para eliminar líneas específicas de un archivo basado en el contenido.
     * Elimina las líneas que contienen alguna de las compañías (Eme bus, Las galaxia y Turbus)
     *
     * @param compañías Arreglo de compañías cuyas líneas se eliminarán del archivo.
     */
    public void eliminarLineaConcreta(String... compañías) {
        File archivo = new File("selecciones.txt");

        if (!archivo.exists()) {
            return; // Si el archivo no existe, no hay nada que eliminar
        }

        try {
            List<String> lineas = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;

            // Leer todas las líneas del archivo y almacenarlas en una lista
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
            reader.close();

            // Eliminar las líneas que contienen cualquiera de las compañías
            lineas.removeIf(line -> {
                for (String compañía : compañías) {
                    if (line.contains(compañía)) {
                        return true;
                    }
                }
                return false;
            });

            // Escribir las líneas restantes de vuelta al archivo
            PrintWriter writer = new PrintWriter(new FileWriter(archivo));
            for (String line : lineas) {
                writer.println(line);
            }
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace(); // Manejo de excepciones, puedes personalizar esto según tus necesidades
        }
    }

    /**
     * Método para eliminar líneas desde una línea específica hasta otra línea específica
     * en un archivo.
     *
     * @param desdeLinea Línea desde la cual comenzar a eliminar.
     * @param hastaLinea Línea hasta la cual dejar de eliminar incluyendola
     */
    public void eliminarLineasDesdeHasta(String desdeLinea, String hastaLinea) {
        File archivo = new File("selecciones.txt");

        if (!archivo.exists()) {
            return; // Si el archivo no existe, no hay nada que eliminar
        }

        try {
            List<String> lineas = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            boolean eliminar = false;

            // Leer todas las líneas del archivo y almacenarlas en una lista
            while ((linea = reader.readLine()) != null) {
                if (linea.contains(desdeLinea)) {
                    eliminar = true;
                }
                if (!eliminar) {
                    lineas.add(linea);
                }
                if (linea.contains(hastaLinea)) {
                    eliminar = false;
                }
            }
            reader.close();

            // Escribir las líneas restantes de vuelta al archivo
            PrintWriter writer = new PrintWriter(new FileWriter(archivo));
            for (String line : lineas) {
                writer.println(line);
            }
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace(); // Manejo de excepciones, puedes personalizar esto según tus necesidades
        }
    }

    /**
     * Método para eliminar líneas posteriores a una línea específica en un archivo,
     * hasta una cantidad determinada de líneas desde la línea de inicio.
     *
     * @param cantidad   Cantidad de líneas a eliminar después de la línea de inicio.
     * @param desdeLineas Líneas desde las cuales comenzar a eliminar.
     */
    public void eliminarLineasPosterioresYCantidad(int cantidad, String... desdeLineas) {
        File archivo = new File("selecciones.txt");

        if (!archivo.exists()) {
            System.out.println("El archivo no existe.");
            return; // Si el archivo no existe, no hay nada que eliminar
        }

        try {
            List<String> lineas = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;

            boolean eliminar = false;
            int contador = 0;

            // Leer todas las líneas del archivo y almacenarlas en una lista
            while ((linea = reader.readLine()) != null) {
                if (eliminar) {
                    contador++;
                    if (contador <= cantidad) {
                        continue; // Saltar líneas a eliminar
                    }
                    eliminar = false; // Dejar de eliminar después de la cantidad especificada
                    contador = 0; // Reiniciar el contador
                }

                lineas.add(linea);

                // Verificar si la línea actual contiene alguna de las líneas de inicio
                // especificadas
                for (String desdeLinea : desdeLineas) {
                    if (linea.contains(desdeLinea)) {
                        eliminar = true; // Activar eliminación después de encontrar la línea
                        break;
                    }
                }
            }
            reader.close();

            // Escribir las líneas restantes de vuelta al archivo
            PrintWriter writer = new PrintWriter(new FileWriter(archivo));
            for (String line : lineas) {
                writer.println(line);
            }
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace(); // Manejo de excepciones, puedes personalizar esto según tus necesidades
        }
    }
}