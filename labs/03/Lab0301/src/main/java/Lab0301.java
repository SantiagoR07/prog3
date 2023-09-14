
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Santiago Rubiano 7004147
 */
public class Lab0301 {
    static Queue<Integer> regis = new LinkedList <>();
    public static void main(String[] args) {
        registro_estudiante();
        registro_asignatura();
        registro_registro_final();
    }
    
    public static void registro_estudiante(){
        String codigo = Entrada.readText("Codigo estudiante: ");
        String nombre = Entrada.readText("Nombre estudiante: ") ;
        String correo = Entrada.readText("Correo estudiante: ");
        int semestre = Entrada.readInt("Semestre: ");
        Estudiante estud = new Estudiante(codigo,nombre,correo,semestre);
        // crear el registro con el codigo del estudiante (por ahora)
        // luego agregaremos las asignaturas 
        regis.add(new Registro(estud));
    }
    
    public static void registro_asignatura(){
        
    }
    
    public static void registro_registro_final(){
        
    }
}
