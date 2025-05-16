package consumo;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MonitorCPU {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Double> registros = new HashSet<>();
        List<Double> registrosFinales = new ArrayList<>();

        StringBuilder log = new StringBuilder();
        log.append("Registro de uso de CPU - ").append(LocalDateTime.now()).append("\n");

        System.out.println("🔍 Ingrese el consumo de CPU por servidor (porcentaje). Escriba 'salir' para terminar.\n");

        while (true) {
            System.out.print("Ingrese consumo de CPU: ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("salir")) {
                break;
            }

            try {
                double valor = Double.parseDouble(entrada);

                if (valor < 0 || valor > 100) {
                    throw new IllegalArgumentException("❌ El valor debe estar entre 0 y 100.");
                }

                if (!registros.add(valor)) {
                    System.out.println("⚠️ Valor duplicado, no será registrado.");
                    continue;
                }

                if (valor > 95) {
                    throw new ConsumoCriticoException("🚨 Consumo crítico detectado: " + valor + "%");
                }

                registrosFinales.add(valor);
                System.out.println("✅ Valor registrado correctamente.");

            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Debe ser un número.");
            } catch (ConsumoCriticoException e) {
                System.out.println(e.getMessage());
                log.append("CRÍTICO: ").append(e.getMessage()).append("\n");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                log.append("ERROR: ").append(e.getMessage()).append("\n");
            }
        }

        scanner.close();

        // Mostrar resumen en consola
        System.out.println("\n📊 Registros válidos:");
        registrosFinales.forEach(v -> System.out.println("- " + v + "%"));

        // Guardar en archivo
        String nombreArchivo = "registro_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".txt";
        File archivo = new File("config", nombreArchivo);

        try {
            if (!archivo.getParentFile().exists()) {
                archivo.getParentFile().mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                for (Double valor : registrosFinales) {
                    writer.write("CPU: " + valor + "%\n");
                }
                writer.write("\n" + log.toString());
                System.out.println("\n📝 Archivo guardado en: " + archivo.getAbsolutePath());
            }

        } catch (IOException e) {
            System.out.println("❌ Error al guardar el archivo: " + e.getMessage());
        }
    }
}