/**
 * Asignación de Programa: PSP 3A
 * Nombre: [Emma Hernández Mendoza]
 * Fecha: [2025-11-23]
 * Descripción: Módulo encargado de la lectura de archivos desde el disco.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase utilitaria para operaciones de lectura.
 */
public class Input {

    /**
     * Extrae el texto completo de un archivo en la ruta indicada.
     * @param inFile Ruta o nombre del archivo objetivo.
     * @return El contenido textual del archivo o vacío si falla.
     */
    public String readData(String inFile) {
        // StringBuilder es más eficiente para concatenar múltiples líneas
        StringBuilder contentBuilder = new StringBuilder();
        
        // Bloque try-with-resources para garantizar cierre de flujos
        try (BufferedReader reader = new BufferedReader(new FileReader(inFile))) {
            String currentLine;
            
            // Iteramos mientras existan líneas por leer
            while ((currentLine = reader.readLine()) != null) {
                // Anexamos la línea actual y restauramos el salto de línea
                contentBuilder.append(currentLine).append("\n");
            }
        } catch (IOException ex) {
            // Reportamos cualquier error de I/O en la consola
            ex.printStackTrace();
            return ""; 
        }
        
        // Retornamos la cadena completa construida
        return contentBuilder.toString();
    }
}