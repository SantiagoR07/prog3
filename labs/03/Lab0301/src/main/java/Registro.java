
import java.util.LinkedList;

/**
 *
 * @author Estudiante
 */
public class Registro {
    Estudiante estudiante;
    LinkedList<Asignatura> ListAsignatura;
    
    Registro(Estudiante estudiante){
        this.estudiante = estudiante;
        ListAsignatura = new LinkedList<>();
    }
}
