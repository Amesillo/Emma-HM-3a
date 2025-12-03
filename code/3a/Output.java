/**
 * Asignación de Programa: PSP 3A
 * Nombre: [Emma Hernández Mendoza]
 * Fecha: [2025-11-23]
 * Descripción: Manejador para la persistencia de resultados en archivos.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Controlador de salida de datos.
 */
public class Output {

    /**
     * Guarda una cadena de texto en un archivo físico.
     * @param outFile Nombre del archivo de destino.
     * @param outText Contenido a guardar.
     */
    public void writeData(String outFile, String outText) {
        // Try-with-resources gestiona el cierre del buffer automáticamente
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
            writer.write(outText); // Vuelca el contenido al archivo
        } catch (IOException ex) {
            // Captura errores de escritura y muestra la traza
            ex.printStackTrace();
        }
    }
}