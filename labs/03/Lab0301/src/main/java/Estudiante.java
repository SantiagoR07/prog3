/**
 *
 * @author Estudiante
 */
public class Estudiante {
        private String codigo;
        private String nombre;
        private String correo;
        private int semestre;

    public Estudiante(String codigo, String nombre, String correo, int semestre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.semestre = semestre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

}