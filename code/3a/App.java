/**
 * Asignación de Programa: PSP 3A
 * Nombre: [Emma Hernández Mendoza]
 * Fecha: [2025-11-23]
 * Descripción: Driver principal para la ejecución del programa de regresión.
 */

/**
 * Punto de entrada del sistema.
 */
public class App {

    /**
     * Inicia el flujo de control de la aplicación.
     * @param args Argumentos de consola (sin uso en esta implementación).
     */
    public static void main(String[] args) {
        // Instanciamos la clase que contiene la lógica de negocio
        Logic3a mainLogic = new Logic3a();
        // Disparamos el proceso de cálculo de regresión
        mainLogic.logic3a();
    }
}