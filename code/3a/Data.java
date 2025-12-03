/**
 * Asignación de Programa: PSP 3A
 * Nombre: [Emma Hernández Mendoza]
 * Fecha: [2025-11-23]
 * Descripción: Utilidad para la manipulación y estructuración de datos brutos.
 */

/**
 * Gestor de transformación de datos.
 */
public class Data {

    /**
     * Fragmenta un bloque de texto en un arreglo de cadenas individuales.
     * @param data El texto completo a procesar.
     * @return Arreglo conteniendo cada línea por separado.
     */
    public String[] saveData(String data) {
        // Utilizamos el salto de línea como delimitador para el split
        return data.split("\n");
    }
}