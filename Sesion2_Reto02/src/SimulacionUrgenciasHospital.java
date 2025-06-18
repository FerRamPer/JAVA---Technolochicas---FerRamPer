import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;


public class SimulacionUrgenciasHospital {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("🏥 Simulación hospitalaria con espera y tiempo de uso...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");
        PriorityBlockingQueue<ProfesionalMedico> cola = new PriorityBlockingQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        cola.add(new ProfesionalMedico("Dra. Ortega", Urgencia.ALTA, salaCirugia));
        cola.add(new ProfesionalMedico("Dr. Gómez", Urgencia.MEDIA, salaCirugia));
        cola.add(new ProfesionalMedico("Enfermero Ramírez", Urgencia.BAJA, salaCirugia));
        cola.add(new ProfesionalMedico("Dra. Luna", Urgencia.ALTA, salaCirugia));
        cola.add(new ProfesionalMedico("Dr. Silva", Urgencia.MEDIA, salaCirugia));

        while (!cola.isEmpty()) {
            executor.execute(cola.poll());
            Thread.sleep(200); // Simula llegada escalonada
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("📊 Todos los accesos fueron registrados con tiempos de espera y entrada y salida.");
    }
}

