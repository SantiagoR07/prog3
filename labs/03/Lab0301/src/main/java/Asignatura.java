class Asignatura {
    private int codigo;
    private String nombre;
    private int semestre;
    private int numCreditos;
    private List<Horario> horarios;

    public Asignatura(int codigo, String nombre, int semestre, int numCreditos, List<Horario> horarios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.semestre = semestre;
        this.numCreditos = numCreditos;
        this.horarios = horarios;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }
}