/**
 * Asignación de Programa: PSP 3A
 * Nombre: [Emma Hernández Mendoza]
 * Fecha: [2025-11-23]
 * Descripción: Coordinador lógico del cálculo de regresión y manejo de I/O.
 */

import java.util.Scanner;

/**
 * Núcleo lógico del proceso de regresión lineal.
 */
public class Logic3a {

    /**
     * Ejecuta el flujo completo: lectura, cálculo y reporte.
     */
    public void logic3a() {
        // Inicializamos el lector de consola
        Scanner consoleScanner = new Scanner(System.in);
        
        // Interacción inicial con el usuario
        System.out.print("Ingrese el nombre del archivo a analizar: ");
        String targetFile = consoleScanner.nextLine();
        
        // Instanciación de componentes auxiliares
        Input fileReader = new Input();
        Data dataProcessor = new Data();
        EstimacionCorLineal mathEngine = new EstimacionCorLineal();
        Output fileWriter = new Output();
        
        // Obtención de datos crudos
        String rawContent = fileReader.readData(targetFile);
        
        // Validación de lectura exitosa
        if (rawContent.isEmpty()) {
            System.out.println("Error: No se pudo leer el archivo " + targetFile);
            consoleScanner.close();
            return;
        }
        
        // Conversión a estructura manejable (array)
        String[] dataLines = dataProcessor.saveData(rawContent);
        
        // Estructuras para almacenar las coordenadas numéricas
        double[] xValues = new double[dataLines.length];
        double[] yValues = new double[dataLines.length];
        
        // Parseo de líneas
        for (int i = 0; i < dataLines.length; i++) {
            String cleanLine = dataLines[i].trim();
            
            // Ignorar líneas en blanco
            if (cleanLine.isEmpty()) {
                continue;
            }
            
            // Separación por espacios en blanco (regex \\s+)
            String[] tokens = cleanLine.split("\\s+");
            
            // Validación de formato par (X, Y)
            if (tokens.length == 2) {
                try {
                    // Conversión de texto a numérico
                    xValues[i] = Double.parseDouble(tokens[0]);
                    yValues[i] = Double.parseDouble(tokens[1]);
                } catch (NumberFormatException e) {
                    // Notificación de datos corruptos o inválidos
                    System.out.println("Error en línea " + (i+1) + ": " + cleanLine);
                }
            }
        }
        
        // Ejecución secuencial de fórmulas matemáticas
        mathEngine.sumX(xValues);        // Sumatoria X
        mathEngine.sumY(yValues);        // Sumatoria Y
        mathEngine.sumXY(xValues, yValues); // Sumatoria productos
        mathEngine.sumXX(xValues);       // Sumatoria cuadrados X
        mathEngine.sumYY(yValues);       // Sumatoria cuadrados Y
        mathEngine.getAvgX(xValues);     // Media X
        mathEngine.getAvgY(yValues);     // Media Y
        mathEngine.getB1();              // Pendiente (Beta 1)
        mathEngine.getB0();              // Intersección (Beta 0)
        mathEngine.setDblXk(386);        // Parámetro de proyección (Xk)
        mathEngine.getYk();              // Predicción (Yk)
        mathEngine.getRXY();             // Correlación (r)
        
        // Cálculo manual del Coeficiente de Determinación (r^2)
        double rSquared = mathEngine.getDblRXY() * mathEngine.getDblRXY();
        
        // Construcción del reporte final formateado
        final String finalReport = "Resultados del análisis de regresión lineal:\n" +
                       "B1: " + String.format("%.6f", mathEngine.getDblB1()) + "\n" +
                       "B0: " + String.format("%.6f", mathEngine.getDblB0()) + "\n" +
                        "Yk estimado: " + String.format("%.2f", mathEngine.getDblYk()) + "\n" +
                       "r: " + String.format("%.6f", mathEngine.getDblRXY()) + "\n" +
                       "r^2: " + String.format("%.6f", rSquared) + "\n";

        // Persistencia y visualización
        fileWriter.writeData("Out3.txt", finalReport);
        System.out.println("\n" + finalReport);
        
        // Limpieza
        consoleScanner.close();
    }
}