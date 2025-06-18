import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.ThreadLocalRandom;

public class AeropuertoControl {

    private static final ExecutorService executor = Executors.newFixedThreadPool(4);

    // Cola de vuelos en espera
    private static final List<String> vuelos = List.of("AC102", "MX341", "IB890", "UA525");

    public static void main(String[] args) {
        System.out.println("🛫 Procesando cola de aterrizajes...\n");

        vuelos.forEach(vuelo -> procesarVuelo(vuelo));

        executor.shutdown();
    }

    private static void procesarVuelo(String vuelo) {
        System.out.println("✈️ Iniciando verificación para vuelo " + vuelo + "...");

        CompletableFuture<Boolean> pista = verificar("🛣️ Pista", 0.80);
        CompletableFuture<Boolean> clima = verificar("🌦️ Clima", 0.85);
        CompletableFuture<Boolean> trafico = verificar("🚦 Tráfico aéreo", 0.90);
        CompletableFuture<Boolean> personal = verificar("👷‍♂️ Personal de tierra", 0.95);

        CompletableFuture.allOf(pista, clima, trafico, personal)
                .thenApply(v -> {
                    try {
                        return pista.get() && clima.get() && trafico.get() && personal.get();
                    } catch (Exception e) {
                        throw new RuntimeException("Error al verificar vuelo " + vuelo + ": " + e.getMessage());
                    }
                })
                .thenAccept(autorizado -> {
                    if (autorizado) {
                        System.out.println("🛬 Aterrizaje autorizado para vuelo " + vuelo + ": condiciones óptimas.\n");
                    } else {
                        System.out.println("🚫 Aterrizaje denegado para vuelo " + vuelo + ": condiciones no óptimas.\n");
                    }
                })
                .exceptionally(e -> {
                    System.out.println("⚠️ Fallo en proceso de vuelo " + vuelo + ": " + e.getMessage());
                    return null;
                });
    }

    private static CompletableFuture<Boolean> verificar(String etiqueta, double probabilidadExito) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(etiqueta + " – verificando...");
            dormir(2000, 3000);
            boolean resultado = Math.random() < probabilidadExito;
            System.out.println(etiqueta + " disponible: " + resultado);
            return resultado;
        }, executor);
    }

    private static void dormir(int minMs, int maxMs) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(minMs, maxMs + 1));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
