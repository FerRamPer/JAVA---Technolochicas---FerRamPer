import java.util.*;

public class RegistroMuestras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> muestrasOrdenLlegada = new ArrayList<>();
        HashMap<String, String> muestraInvestigador = new HashMap<>();

        System.out.println("=== REGISTRO DE MUESTRAS GENÉTICAS ===");

        // Ingreso de muestras genéticas
        System.out.print("¿Cuántas muestras deseas registrar? ");
        int cantidadMuestras = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= cantidadMuestras; i++) {
            System.out.println("\nMuestra #" + i);
            System.out.print("Especie: ");
            String especie = scanner.nextLine();
            muestrasOrdenLlegada.add(especie);

            System.out.print("ID de muestra (ej. M-001): ");
            String id = scanner.nextLine();

            System.out.print("Nombre del investigador: ");
            String investigador = scanner.nextLine();

            muestraInvestigador.put(id, investigador);
        }

        // Crear conjunto de especies únicas
        HashSet<String> especiesUnicas = new HashSet<>(muestrasOrdenLlegada);

        // Mostrar resultados
        System.out.println("\n📦 Lista completa y ordenada de especies registradas:");
        for (String especie : muestrasOrdenLlegada) {
            System.out.println("- " + especie);
        }

        System.out.println("\n🧬 Especies únicas procesadas:");
        for (String especie : especiesUnicas) {
            System.out.println("- " + especie);
        }

        System.out.println("\n👩‍🔬 Relación ID de muestra → Investigador:");
        for (String id : muestraInvestigador.keySet()) {
            System.out.println(id + " → " + muestraInvestigador.get(id));
        }

        // Búsqueda por ID
        System.out.print("\n🔍 Ingresa un ID de muestra para buscar: ");
        String idBusqueda = scanner.nextLine();

        if (muestraInvestigador.containsKey(idBusqueda)) {
            System.out.println("✅ Investigador responsable: " + muestraInvestigador.get(idBusqueda));
        } else {
            System.out.println("❌ ID de muestra no encontrado.");
        }

        scanner.close();
    }
}