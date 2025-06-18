package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;
import reactor.util.function.Tuple5;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    // Estado de semáforo por cruce (para detectar repeticiones de rojo)
    public static class SemaforoState {
        String cruce;
        int rojosSeguidos;

        SemaforoState(String cruce) {
            this.cruce = cruce;
            this.rojosSeguidos = 0;
        }
    }

    public static void main(String[] args) {

        AtomicInteger eventosCriticos = new AtomicInteger(0);

        // 🚗 Sensores de tráfico
        Flux<String> flujoTrafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> ThreadLocalRandom.current().nextInt(0, 101))
                .onBackpressureBuffer()
                .filter(nivel -> nivel > 70)
                .map(nivel -> {
                    eventosCriticos.incrementAndGet();
                    return "🚗 Alerta: Congestión del " + nivel + "% en Avenida Solar";
                });

        // 🌫️ Contaminación del aire
        Flux<String> flujoContaminacion = Flux.interval(Duration.ofMillis(600))
                .map(i -> ThreadLocalRandom.current().nextInt(10, 100))
                .filter(pm -> pm > 50)
                .map(pm -> {
                    eventosCriticos.incrementAndGet();
                    return "🌫️ Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)";
                });

        // 🚑 Accidentes viales
        Flux<String> flujoAccidentes = Flux.interval(Duration.ofMillis(800))
                .map(i -> randomPrioridad())
                .filter(prioridad -> prioridad.equals("Alta"))
                .map(p -> {
                    eventosCriticos.incrementAndGet();
                    return "🚑 Emergencia vial: Accidente con prioridad Alta";
                });

        // 🚝 Trenes maglev
        Flux<String> flujoTrenes = Flux.interval(Duration.ofMillis(700))
                .map(i -> ThreadLocalRandom.current().nextInt(0, 11))
                .delayElements(Duration.ofMillis(300)) // Simula backpressure
                .filter(minutos -> minutos > 5)
                .map(minutos -> {
                    eventosCriticos.incrementAndGet();
                    return "🚝 Tren maglev con retraso crítico: " + minutos + " minutos";
                });

        // 🚦 Semáforos inteligentes
        Flux<String> flujoSemaforos = Flux.interval(Duration.ofMillis(400))
                .scan(new SemaforoState("Cruce Norte"), (state, tick) -> {
                    String color = randomSemaforo();
                    if (color.equals("Rojo")) {
                        state.rojosSeguidos++;
                    } else {
                        state.rojosSeguidos = 0;
                    }
                    return state;
                })
                .filter(state -> state.rojosSeguidos >= 3)
                .map(state -> {
                    eventosCriticos.incrementAndGet();
                    return "🚦 Semáforo en Rojo detectado " + state.rojosSeguidos + " veces seguidas en " + state.cruce;
                });

        // 🔔 Alerta global si 3 o más eventos críticos ocurren casi simultáneamente
        Flux.interval(Duration.ofSeconds(2))
                .map(i -> eventosCriticos.getAndSet(0))
                .filter(contador -> contador >= 3)
                .map(c -> "\n🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime\n")
                .subscribe(System.out::println);

        // Subscripciones paralelas
        flujoTrafico.subscribe(System.out::println);
        flujoContaminacion.subscribe(System.out::println);
        flujoAccidentes.subscribe(System.out::println);
        flujoTrenes.subscribe(System.out::println);
        flujoSemaforos.subscribe(System.out::println);

        // Mantiene el sistema encendido
        try {
            Thread.sleep(20000); // Simula 20 segundos de monitoreo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Simula prioridades aleatorias
    private static String randomPrioridad() {
        int n = ThreadLocalRandom.current().nextInt(0, 100);
        if (n < 10) return "Alta";
        if (n < 50) return "Media";
        return "Baja";
    }

    // Simula colores de semáforo
    private static String randomSemaforo() {
        int n = ThreadLocalRandom.current().nextInt(0, 100);
        if (n < 50) return "Verde";
        if (n < 80) return "Amarillo";
        return "Rojo";
    }
}
