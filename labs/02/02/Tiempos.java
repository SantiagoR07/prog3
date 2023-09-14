
/**
 *
 * @author Santiago Rubiano 7004147
 */
import java.util.Arrays;

public class Tiempos {
    public static void main(String[] argumentos) {
        int[] tamaños = { 100, 500, 1000, 5000, 10000 };

        System.out.println("Tabla de tiempos (en nanosegundos):");
        System.out.println("Tamaño de la Muestra\tBurbuja\tInserción\tSelección\tMerge Sort");

        for (int tamaño : tamaños) {
            double[] muestra = Datos.MuestraAleatoria(tamaño);
            double[] copiaMuestra1 = Arrays.copyOf(muestra, muestra.length);
            double[] copiaMuestra2 = Arrays.copyOf(muestra, muestra.length);
            double[] copiaMuestra3 = Arrays.copyOf(muestra, muestra.length);

            long tiempoInicio = System.nanoTime();
            ordenamiento.Burbuja(copiaMuestra1);
            long tiempoFinal = System.nanoTime();
            long tiempoBurbuja = tiempoFinal - tiempoInicio;

            tiempoInicio = System.nanoTime();
            ordenamiento.Insercion(copiaMuestra2);
            tiempoFinal = System.nanoTime();
            long tiempoInsercion = tiempoFinal - tiempoInicio;

            tiempoInicio = System.nanoTime();
            ordenamiento.Seleccion(copiaMuestra3);
            tiempoFinal = System.nanoTime();
            long tiempoSeleccion = tiempoFinal - tiempoInicio;

            tiempoInicio = System.nanoTime();
            ordenamiento.MergeSort(muestra);
            tiempoFinal = System.nanoTime();
            long tiempoMergeSort = tiempoFinal - tiempoInicio;

            System.out.println(tamaño + "\t\t\t" + tiempoBurbuja + "\t" + tiempoInsercion + "\t\t" + tiempoSeleccion
                    + "\t\t" + tiempoMergeSort);
        }
    }
}