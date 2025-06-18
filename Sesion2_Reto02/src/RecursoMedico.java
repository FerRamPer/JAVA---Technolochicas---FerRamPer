import java.util.concurrent.locks.ReentrantLock;

// Clase que representa un recurso médico compartido
public class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional, long solicitud) {
        System.out.println("🔄 " + profesional + " está esperando acceso a " + nombre);
        lock.lock();
        long ingreso = System.nanoTime();
        try {
            long espera = (ingreso - solicitud) / 1_000_000;
            System.out.println("👨‍⚕️ " + profesional + " ha ingresado a " + nombre + " después de esperar " + espera + " ms.");

            Thread.sleep(1000); // Simula uso del recurso

            long salida = System.nanoTime();
            long uso = (salida - ingreso) / 1_000_000;
            System.out.println("✅ " + profesional + " ha salido de " + nombre + " (uso: " + uso + " ms).");

        } catch (InterruptedException e) {
            System.err.println("⚠️ " + profesional + " fue interrumpido.");
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
