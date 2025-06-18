// Clase que representa una tarea médica con prioridad
public class ProfesionalMedico implements Runnable, Comparable<ProfesionalMedico> {
    private final String nombre;
    private final Urgencia urgencia;
    private final RecursoMedico recurso;
    private final long momentoSolicitud;

    public ProfesionalMedico(String nombre, Urgencia urgencia, RecursoMedico recurso) {
        this.nombre = nombre;
        this.urgencia = urgencia;
        this.recurso = recurso;
        this.momentoSolicitud = System.nanoTime();
    }

    @Override
    public void run() {
        recurso.usar(nombre + " (" + urgencia.name() + ")", momentoSolicitud);
    }

    @Override
    public int compareTo(ProfesionalMedico otro) {
        return Integer.compare(this.urgencia.ordinal(), otro.urgencia.ordinal());
    }
}
