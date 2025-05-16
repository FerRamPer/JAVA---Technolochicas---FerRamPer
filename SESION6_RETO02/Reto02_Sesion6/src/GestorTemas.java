import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GestorTemas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CopyOnWriteArrayList<Tema> temasActivos = new CopyOnWriteArrayList<>();
        ConcurrentHashMap<String, String> recursos = new ConcurrentHashMap<>();

        // Agregar temas predefinidos
        temasActivos.add(new Tema("Lectura comprensiva", 2));
        temasActivos.add(new Tema("Matemáticas básicas", 1));
        temasActivos.add(new Tema("Cuidado del medio ambiente", 3));
        temasActivos.add(new Tema("Resolución de conflictos", 2));

        // Agregar recursos por tema
        recursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        recursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        recursos.put("Cuidado del medio ambiente", "https://recursos.edu/medioambiente");
        recursos.put("Resolución de conflictos", "https://recursos.edu/conflictos");

        // Preguntar al usuario cómo desea ordenar los temas
        System.out.println("📋 ¿Cómo desea ver los temas?");
        System.out.println("1. Orden alfabético");
        System.out.println("2. Orden por prioridad (1 = urgente → 3 = opcional)");
        System.out.print("Ingrese su opción (1 o 2): ");
        int opcion = Integer.parseInt(scanner.nextLine());

        CopyOnWriteArrayList<Tema> copiaTemas = new CopyOnWriteArrayList<>(temasActivos);

        switch (opcion) {
            case 1:
                Collections.sort(copiaTemas);
                System.out.println("\n📚 Temas ordenados alfabéticamente:");
                break;
            case 2:
                copiaTemas.sort(Comparator.comparingInt(Tema::getPrioridad));
                System.out.println("\n🔥 Temas ordenados por prioridad:");
                break;
            default:
                System.out.println("❌ Opción no válida. Mostrando orden por defecto.");
        }

        for (Tema tema : copiaTemas) {
            String recurso = recursos.getOrDefault(tema.getTitulo(), "Sin recurso asignado");
            System.out.println(tema + " → 📎 " + recurso);
        }

        scanner.close();
    }
}