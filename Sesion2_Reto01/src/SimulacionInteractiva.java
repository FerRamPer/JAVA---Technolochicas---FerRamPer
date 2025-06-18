import java.util.Scanner;
import java.util.concurrent.*;

public class SimulacionInteractiva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("🚀 Simulación de misión espacial iniciada...");

        while (true) {
            System.out.println("\nSelecciona un subsistema:");
            System.out.println("1. Navegación");
            System.out.println("2. Soporte vital");
            System.out.println("3. Control térmico");
            System.out.println("4. Comunicaciones");
            System.out.println("5. Ejecutar todos simultáneamente");
            System.out.println("0. Salir");

            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        System.out.println(executor.submit(new SistemaNavegacion()).get());
                        break;
                    case 2:
                        System.out.println(executor.submit(new SistemaSoporteVital()).get());
                        break;
                    case 3:
                        System.out.println(executor.submit(new SistemaControlTermico()).get());
                        break;
                    case 4:
                        System.out.println(executor.submit(new SistemaComunicaciones()).get());
                        break;
                    case 5:
                        Future<String> nav = executor.submit(new SistemaNavegacion());
                        Future<String> vital = executor.submit(new SistemaSoporteVital());
                        Future<String> termico = executor.submit(new SistemaControlTermico());
                        Future<String> comunicaciones = executor.submit(new SistemaComunicaciones());

                        System.out.println(comunicaciones.get());
                        System.out.println(vital.get());
                        System.out.println(termico.get());
                        System.out.println(nav.get());
                        System.out.println("✅ Todos los sistemas reportan estado operativo.");
                        break;
                    case 0:
                        executor.shutdown();
                        System.out.println("🚨 Simulación finalizada. Hasta pronto, comandante.");
                        return;
                    default:
                        System.out.println("❌ Opción inválida. Intenta de nuevo.");
                }
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error en el sistema: " + e.getMessage());
            }
        }
    }
}
