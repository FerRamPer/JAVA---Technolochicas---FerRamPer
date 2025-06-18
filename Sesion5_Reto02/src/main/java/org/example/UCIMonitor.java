import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class UCIMonitor {

    record Signos(int paciente, int fc, int paSistolica, int paDiastolica, int spo2) {}

    public static void main(String[] args) {

        // Crear flujo para cada paciente
        Flux<Signos> paciente1 = generarFlujoPaciente(1);
        Flux<Signos> paciente2 = generarFlujoPaciente(2);
        Flux<Signos> paciente3 = generarFlujoPaciente(3);

        // Fusionar los 3 flujos y aplicar procesamiento
        Flux.merge(paciente1, paciente2, paciente3)
                .filter(UCIMonitor::esCritico)
                .delayElements(Duration.ofSeconds(1)) // Backpressure
                .publishOn(Schedulers.boundedElastic())
                .subscribe(UCIMonitor::mostrarAlerta);

        // Mantener la aplicación encendida
        try {
            Thread.sleep(30000); // Simula 30 segundos de monitoreo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Flux<Signos> generarFlujoPaciente(int id) {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> new Signos(
                        id,
                        valorAleatorio(40, 130),     // FC
                        valorAleatorio(80, 160),     // PA Sistólica
                        valorAleatorio(50, 100),     // PA Diastólica
                        valorAleatorio(80, 100)      // SpO2
                ));
    }

    static int valorAleatorio(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    static boolean esCritico(Signos s) {
        return s.fc < 50 || s.fc > 120 ||
                s.paSistolica < 90 || s.paSistolica > 140 ||
                s.paDiastolica < 60 || s.paDiastolica > 90 ||
                s.spo2 < 90;
    }

    static void mostrarAlerta(Signos s) {
        if (s.fc < 50 || s.fc > 120)
            System.out.println("⚠️ Paciente " + s.paciente + " - FC crítica: " + s.fc + " bpm");
        if (s.paSistolica < 90 || s.paSistolica > 140 || s.paDiastolica < 60 || s.paDiastolica > 90)
            System.out.println("⚠️ Paciente " + s.paciente + " - PA crítica: " + s.paSistolica + "/" + s.paDiastolica + " mmHg");
        if (s.spo2 < 90)
            System.out.println("⚠️ Paciente " + s.paciente + " - SpO2 baja: " + s.spo2 + "%");
    }
}
