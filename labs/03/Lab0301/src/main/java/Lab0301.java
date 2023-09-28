import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lab0301 {
    static Queue<Registro> regis = new LinkedList<>();

    public static void main(String[] args) {
        registro_estudiante();
        registro_asignaturas();
        reporte_registro_final();
    }

    public static void registro_estudiante() {
        String codigo = Entrada.readText("Codigo estudiante");
        String nombre = Entrada.readText("Nombre estudiante");
        String correo = Entrada.readText("Correo estudiante");
        int semestre = Entrada.readInt("Semestre: ");
        Estudiante estud = new Estudiante(codigo, nombre, correo, semestre);
        regis.add(new Registro(estud));
    }

    public static void registro_asignaturas() {
        // Supongamos que tienes una lista de asignaturas cargadas desde un archivo de texto.
        List<Asignatura> asignaturasDisponibles = cargarAsignaturasDesdeArchivo();

        int totalCreditosSeleccionados = 0;
        Registro registroActual = regis.peek();

        while (totalCreditosSeleccionados < 5 || totalCreditosSeleccionados > 16) {
            System.out.println("Selecciona asignaturas (5 a 16 créditos en total):");
            for (int i = 0; i < asignaturasDisponibles.size(); i++) {
                Asignatura asignatura = asignaturasDisponibles.get(i);
                System.out.println(i + 1 + ". " + asignatura.getNombre() + " (" + asignatura.getNumCreditos() + " créditos)");
            }

            int opcion = Entrada.readInt("Ingrese el número de la asignatura a registrar (0 para finalizar): ");
            if (opcion == 0) {
                break;
            }

            if (opcion >= 1 && opcion <= asignaturasDisponibles.size()) {
                Asignatura seleccionada = asignaturasDisponibles.get(opcion - 1);

                if (!verificarCruceHorario(registroActual, seleccionada) && totalCreditosSeleccionados + seleccionada.getNumCreditos() <= 16) {
                    registroActual.agregarAsignatura(seleccionada);
                    totalCreditosSeleccionados += seleccionada.getNumCreditos();
                    System.out.println("Asignatura registrada correctamente.");
                } else if (verificarCruceHorario(registroActual, seleccionada)) {
                    System.out.println("Cruce de horario con otra asignatura. Por favor, elija otra.");
                } else if (totalCreditosSeleccionados + seleccionada.getNumCreditos() > 16) {
                    System.out.println("La suma de créditos excede el límite permitido (16 créditos).");
                }
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static boolean verificarCruceHorario(Registro registro, Asignatura asignatura) {
        for (Asignatura asignaturaRegistrada : registro.getListaAsignaturas()) {
            for (Horario horarioRegistrado : asignaturaRegistrada.getHorarios()) {
                for (Horario horarioAsignatura : asignatura.getHorarios()) {
                    if (horarioRegistrado.getDia().equals(horarioAsignatura.getDia())
                            && horarioRegistrado.getHora().equals(horarioAsignatura.getHora())) {
                        return true; // Hay un cruce de horario.
                    }
                }
            }
        }
        return false; // No hay cruces de horario.
    }

    public static List<Asignatura> cargarAsignaturasDesdeArchivo() {
        // Aquí deberías implementar la lógica para cargar las asignaturas desde el archivo "asignaturas.txt".
        // Puedes leer el archivo, analizar su contenido y crear instancias de Asignatura para cada una de ellas.
        // Luego, devuelve la lista de asignaturas cargadas.
        // Si tienes problemas con esta parte, por favor indícame más detalles sobre el formato del archivo.
        return new LinkedList<>(); // Devuelve una lista vacía por ahora.
    }

    public static void reporte_registro_final() {
        for (Registro registro : regis) {
            Estudiante estudiante = registro.getEstudiante();
            List<Asignatura> asignaturas = registro.getListaAsignaturas();

            System.out.println("Estudiante: " + estudiante.getNombre() + " (" + estudiante.getCodigo() + ")");
            System.out.println("Semestre: " + estudiante.getSemestre());
            System.out.println("Asignaturas registradas:");

            for (Asignatura asignatura : asignaturas) {
                System.out.println("- " + asignatura.getNombre() + " (" + asignatura.getNumCreditos() + " créditos)");
            }

            System.out.println("Total de créditos registrados: " + calcularTotalCreditos(asignaturas));
            System.out.println();
        }
    }

    public static int calcularTotalCreditos(List<Asignatura> asignaturas) {
        int total = 0;
        for (Asignatura asignatura : asignaturas) {
            total += asignatura.getNumCreditos();
        }
        return total;
    }
}