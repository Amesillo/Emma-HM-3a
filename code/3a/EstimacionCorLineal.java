/**
 * Asignación de Programa: PSP 3A
 * Nombre: [Emma Hernández Mendoza]
 * Fecha: [2025-11-23]
 * Descripción: Motor matemático para cálculos estadísticos y de correlación.
 */

/**
 * Entidad encargada de las operaciones aritméticas de la regresión.
 */
public class EstimacionCorLineal {

    // Variables de estado para almacenar sumatorias y resultados parciales
    private double dblSumX;
    private double dblSumY;
    private double dblSumXY;
    private double dblSumXX;
    private double dblSumYY;
    private double dblAvgX;
    private double dblAvgY;
    private int intN;          // Número de muestras
    private double dblB1;      // Pendiente
    private double dblRXY;     // Correlación
    private double dblB0;      // Intersección
    private double dblXk;      // Valor proyectado X
    private double dblYk;      // Resultado estimado Y

    // --- Setters y Getters ---

    /** Asigna valor a la sumatoria de X */
    public void setDblSumX(double newVar) { dblSumX = newVar; }
    /** Retorna la sumatoria de X */
    public double getDblSumX() { return dblSumX; }

    /** Asigna valor a la sumatoria de Y */
    public void setDblSumY(double newVar) { dblSumY = newVar; }
    /** Retorna la sumatoria de Y */
    public double getDblSumY() { return dblSumY; }

    /** Asigna valor a la sumatoria de productos XY */
    public void setDblSumXY(double newVar) { dblSumXY = newVar; }
    /** Retorna la sumatoria de productos XY */
    public double getDblSumXY() { return dblSumXY; }

    /** Asigna valor a la sumatoria de cuadrados X */
    public void setDblSumXX(double newVar) { dblSumXX = newVar; }
    /** Retorna la sumatoria de cuadrados X */
    public double getDblSumXX() { return dblSumXX; }

    /** Asigna valor a la sumatoria de cuadrados Y */
    public void setDblSumYY(double newVar) { dblSumYY = newVar; }
    /** Retorna la sumatoria de cuadrados Y */
    public double getDblSumYY() { return dblSumYY; }

    /** Asigna el promedio de X */
    public void setDblAvgX(double newVar) { dblAvgX = newVar; }
    /** Retorna el promedio de X */
    public double getDblAvgX() { return dblAvgX; }

    /** Asigna el promedio de Y */
    public void setDblAvgY(double newVar) { dblAvgY = newVar; }
    /** Retorna el promedio de Y */
    public double getDblAvgY() { return dblAvgY; }

    /** Define el tamaño de la muestra N */
    public void setIntN(int newVar) { intN = newVar; }
    /** Retorna el tamaño de la muestra N */
    public int getIntN() { return intN; }

    /** Asigna el coeficiente Beta 1 */
    public void setDblB1(double newVar) { dblB1 = newVar; }
    /** Retorna el coeficiente Beta 1 */
    public double getDblB1() { return dblB1; }

    /** Asigna el coeficiente de correlación r */
    public void setDblRXY(double newVar) { dblRXY = newVar; }
    /** Retorna el coeficiente de correlación r */
    public double getDblRXY() { return dblRXY; }

    /** Asigna el coeficiente Beta 0 */
    public void setDblB0(double newVar) { dblB0 = newVar; }
    /** Retorna el coeficiente Beta 0 */
    public double getDblB0() { return dblB0; }

    /** Asigna el valor X para la proyección */
    public void setDblXk(double newVar) { dblXk = newVar; }
    /** Retorna el valor X de proyección */
    public double getDblXk() { return dblXk; }

    /** Asigna el valor estimado Y */
    public void setDblYk(double newVar) { dblYk = newVar; }
    /** Retorna el valor estimado Y */
    public double getDblYk() { return dblYk; }


    // --- Lógica de Cálculo ---

    /**
     * Realiza la sumatoria de todos los elementos en el conjunto X.
     * @param datosX Arreglo de valores X.
     */
    public void sumX(double[] datosX) {
        double total = 0;
        for (double val : datosX) {
            total += val;
        }
        this.dblSumX = total;
    }

    /**
     * Realiza la sumatoria de todos los elementos en el conjunto Y.
     * @param datosY Arreglo de valores Y.
     */
    public void sumY(double[] datosY) {
        double total = 0;
        for (double val : datosY) {
            total += val;
        }
        this.dblSumY = total;
    }

    /**
     * Calcula la suma de los productos de cada par (x * y).
     * @param datosX Valores X.
     * @param datosY Valores Y correspondientes.
     */
    public void sumXY(double[] datosX, double[] datosY) {
        double total = 0;
        for (int i = 0; i < datosX.length; i++) {
            total += datosX[i] * datosY[i];
        }
        this.dblSumXY = total;
    }

    /**
     * Calcula la suma de los cuadrados de cada valor X (x^2).
     * @param datosX Valores X.
     */
    public void sumXX(double[] datosX) {
        double total = 0;
        for (double val : datosX) {
            total += val * val;
        }
        this.dblSumXX = total;
    }

    /**
     * Calcula la suma de los cuadrados de cada valor Y (y^2).
     * @param datosY Valores Y.
     */
    public void sumYY(double[] datosY) {
        double total = 0;
        for (double val : datosY) {
            total += val * val;
        }
        this.dblSumYY = total;
    }

    /**
     * Determina la media aritmética del conjunto X y establece N.
     * @param datosX Valores X.
     */
    public void getAvgX(double[] datosX) {
        double total = 0;
        for (double val : datosX) {
            total += val;
        }
        this.dblAvgX = total / datosX.length;
        this.intN = datosX.length; // Aprovechamos para fijar N
    }

    /**
     * Determina la media aritmética del conjunto Y.
     * @param datosY Valores Y.
     */
    public void getAvgY(double[] datosY) {
        double total = 0;
        for (double val : datosY) {
            total += val;
        }
        this.dblAvgY = total / datosY.length;
    }

    /**
     * Calcula la pendiente (B1) utilizando la fórmula de mínimos cuadrados.
     */
    public void getB1() {
        double numerador = this.dblSumXY - (this.intN * this.dblAvgX * this.dblAvgY);
        double denominador = this.dblSumXX - (this.intN * this.dblAvgX * this.dblAvgX);
        this.dblB1 = numerador / denominador;
    }

    /**
     * Obtiene el coeficiente de correlación de Pearson (r).
     */
    public void getRXY() {
        double num = (this.intN * this.dblSumXY) - (this.dblSumX * this.dblSumY);
        double denParte1 = (this.intN * this.dblSumXX) - (this.dblSumX * this.dblSumX);
        double denParte2 = (this.intN * this.dblSumYY) - (this.dblSumY * this.dblSumY);
        
        double denFinal = Math.sqrt(denParte1 * denParte2);
        this.dblRXY = num / denFinal;
    }

    /**
     * Calcula la intersección en el eje Y (B0).
     */
    public void getB0() {
        // B0 = PromedioY - (B1 * PromedioX)
        this.dblB0 = this.dblAvgY - (this.dblB1 * this.dblAvgX);
    }

    /**
     * Realiza la predicción Yk basada en el valor Xk ingresado.
     */
    public void getYk() {
        // Ecuación de la recta: y = mx + b  ->  Yk = B1*Xk + B0
        this.dblYk = this.dblB0 + (this.dblB1 * this.dblXk);
    }
}