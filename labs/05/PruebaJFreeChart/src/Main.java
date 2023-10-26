/* Tomado de https://www.adictosaltrabajo.com/2011/11/10/grafica-series-jfreechart/
   Adaptado por Santiago Rubiano Garzón
   26-Oct-2023 2:11 pm
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;

public class Main {
    public static final int ANCHO_GRAFICA = 400;
    public static final int ALTO_GRAFICA = 300;

    public static void main(String args[]) {
        String archivoCSV = "datos.csv"; // Ruta y nombre del archivo
        File archivoData = new File(archivoCSV);
        final XYSeriesCollection collection = new XYSeriesCollection();

        try {
            Scanner lectorArchivo = new Scanner(archivoData);
            String valor1 = null;
            String valor3 = null;
            int secuencia = 1;
            while (lectorArchivo.hasNextLine()) {
                String[] valores = lectorArchivo.nextLine().split(","); 

                if (valores.length >= 5) {
                    valor1 = valores[0];
                    valor3 = valores[2];

                    if (esNumero(valor1) && esNumero(valor3)) {
                        final XYSeries serie = new XYSeries("Serie " + secuencia++);
                        serie.add(1, Double.parseDouble(valor1));
                        serie.add(2, Double.parseDouble(valor3));

                        collection.addSeries(serie);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error -> " + ex.getMessage());
        }

        try {
            final PruebaJFreeChart prueba = new PruebaJFreeChart();
            final JFreeChart grafica = prueba.crearGrafica(collection);
            ChartUtilities.saveChartAsPNG(new File("grafica.png"), grafica, ANCHO_GRAFICA, ALTO_GRAFICA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean esNumero(String strNum) {
        if (strNum == null) {
            return false;
        }
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(strNum).matches();
    }
}