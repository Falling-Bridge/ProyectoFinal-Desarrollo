package Interfaz;

import java.io.*;
import java.util.*;

public class ManejoArchivo {

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
                if (!linea.contains("Resumen")) {  // Ignorar líneas que contienen "Resumen"
                    lineas.add(linea);
                }
            }
            reader.close();

            // Verificar si el archivo nuevo tiene contenido
            boolean tieneContenido = archivoNuevo.exists() && archivoNuevo.length() > 0;

            // Escribir las líneas en el archivo nuevo, agregando una línea de separación si tiene contenido
            PrintWriter writer = new PrintWriter(new FileWriter(archivoNuevo, true)); // true para modo append
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

    public void eliminarContenidoArchivo() {
        File archivo = new File("selecciones.txt");

        if (!archivo.exists()) {
            return; // Si el archivo no existe, no hay contenido que eliminar
        }

        try {
            // Abrir el archivo para escribir sobre él (esto borrará su contenido)
            PrintWriter writer = new PrintWriter(new FileWriter(archivo, false));
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace(); // Manejo de excepciones, puedes personalizar esto según tus necesidades
        }
    }

    public void eliminarLineaConcreta(String lineaAEliminar) {
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

            // Eliminar la línea concreta si se encuentra
            lineas.removeIf(line -> line.contains(lineaAEliminar));

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

    public void eliminarLineasPosterioresYCantidad(String desdeLinea, int cantidad) {
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
                }

                lineas.add(linea);

                if (linea.contains(desdeLinea)) {
                    eliminar = true; // Activar eliminación después de encontrar la línea
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