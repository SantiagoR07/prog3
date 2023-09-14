import java.util.Random;

public class Datos {
    public static double[] MuestraAleatoria(int tamaño) {
        double[] datos = new double[tamaño];
        Random rand = new Random();
        for (int i = 0; i < tamaño; i++) {
            datos[i] = rand.nextDouble();
        }
        return datos;
    }
}