/**
 *
 * @author Santiago Rubiano - 7004147 / Valentina Cardenas Mercado - 7004255
**/


import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
import java.util.HashMap;

public class Temporizador extends TimerTask {
    private String mensaje;
    private Timer timer;

    public Temporizador(String mensaje, Timer timer) {
        this.mensaje = mensaje;
        this.timer = timer;
    }

    @Override
    public void run() {
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Temporizador> temporizadores = new HashMap<>();
        int contador = 1;

        while (true) {
            System.out.println("Opciones:");
            System.out.println("1. Crear temporizador");
            System.out.println("2. Detener temporizador");
            System.out.println("3. Reiniciar temporizador");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: \n");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el mensaje del temporizador: ");
                    String mensaje = scanner.nextLine();
                    System.out.print("Ingrese el tiempo de espera en milisegundos: ");
                    long tiempoEspera = scanner.nextLong();

                    Temporizador tarea = new Temporizador(mensaje, timer);
                    temporizadores.put(contador, tarea);
                    timer.schedule(tarea, tiempoEspera);
                    contador++;
                    break;
                case 2:
                    System.out.print("Ingrese el número del temporizador a detener: ");
                    int numeroDetener = scanner.nextInt();
                    Temporizador tareaDetener = temporizadores.get(numeroDetener);

                    if (tareaDetener != null) {
                        tareaDetener.cancel();
                        temporizadores.remove(numeroDetener);
                        System.out.println("Temporizador detenido con éxito.");
                    } else {
                        System.out.println("Temporizador no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el número del temporizador a reiniciar: ");
                    int numeroReiniciar = scanner.nextInt();
                    Temporizador tareaReiniciar = temporizadores.get(numeroReiniciar);

                    if (tareaReiniciar != null) {
                        tareaReiniciar.cancel();
                        System.out.print("Ingrese el nuevo tiempo de espera en milisegundos: ");
                        long nuevoTiempoEspera = scanner.nextLong();
                       
                        Temporizador nuevoTarea = new Temporizador(tareaReiniciar.mensaje, timer);
                        temporizadores.put(numeroReiniciar, nuevoTarea);
                        timer.schedule(nuevoTarea, nuevoTiempoEspera);

                        System.out.println("Temporizador reiniciado con éxito.");
                    } else {
                        System.out.println("Temporizador no encontrado.");
                    }
                    break;
                case 4:
                    timer.cancel();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}