import java.util.concurrent.*;
import java.util.concurrent.ThreadLocalRandom;

public class MovilidadApp {

    // Simula el cálculo de ruta con latencia de 2-3 segundos
    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦 Calculando ruta...");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3001));
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular la ruta");
            }
            return "Ruta: Centro -> Norte";
        });
    }

    // Simula la estimación de tarifa con latencia de 1-2 segundos
    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("💰 Estimando tarifa...");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2001));
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al estimar la tarifa");
            }

            // Simula posible error
            if (Math.random() < 0.1) { // 10% chance de falla
                throw new RuntimeException("No se pudo calcular la tarifa");
            }

            return 75.50;
        });
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> ruta = calcularRuta();
        CompletableFuture<Double> tarifa = estimarTarifa();

        ruta.thenCombine(tarifa, (r, t) -> {
                    return "✅ 🚗 " + r + " | Tarifa estimada: $" + String.format("%.2f", t);
                })
                .exceptionally(e -> "❌ Error al procesar el viaje: " + e.getMessage())
                .thenAccept(System.out::println);

        // Simula otras tareas mientras se resuelven las async
        System.out.println("📲 Procesando otras solicitudes en paralelo...\n");

        // Espera lo suficiente para ver la salida
        Thread.sleep(4000);
    }
}
