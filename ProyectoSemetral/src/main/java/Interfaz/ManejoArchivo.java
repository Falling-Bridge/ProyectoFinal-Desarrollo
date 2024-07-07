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

    public void eliminarContenidoArchivo(String nombre) {
        File archivo = new File(nombre);

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

    public String[] compararPrimeras5Lineas(String archivo1, String archivo2) throws IOException {
        // Leer las primeras 5 líneas de archivo1
        String[] primerasLineasArchivo1 = leerPrimeras5Lineas(archivo1);
        
        // Leer las primeras 5 líneas de archivo2
        String[] primerasLineasArchivo2 = leerPrimeras5Lineas(archivo2);
        
        // Comparar arrays de líneas
        for (int i = 0; i < 5; i++) {
            if (!primerasLineasArchivo1[i].equals(primerasLineasArchivo2[i])) {
                return primerasLineasArchivo1; // Retornar las líneas del archivo1 si no son idénticas
            }
        }
        
        return primerasLineasArchivo1; // Retornar null si son idénticas (no bloquear asientos)
    }    
    
    // Método para leer las primeras 5 líneas de un archivo
    private String[] leerPrimeras5Lineas(String archivo) throws IOException {
        String[] primerasLineas = new String[5];
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            for (int i = 0; i < 5; i++) {
                String linea = br.readLine();
                if (linea != null) {
                    primerasLineas[i] = linea.trim(); // Guardar la línea sin espacios al inicio y final
                } else {
                    primerasLineas[i] = ""; // Línea vacía si el archivo tiene menos de 5 líneas
                }
            }
        }
        return primerasLineas;
    }
}