//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaProduccion {
    // Metodo genérico para mostrar órdenes
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        /*recibe la lista de cualquier subtipo (masa, prototipo o personalizada)
         y ocupa su propio metodo mostrarResumen como existe en la clase OrdenProduccion
         - List<T> : Lista de elementos Type (OrdenMasa, OrdenPersonalizada, OrdenPrototipo)
         - T=? extends OrdenProduccion : solo acepta tipos heredados de OrdenProduccion o de la misma clase
         extends me sirve porque solo quiero leer los tipos, no modificarlos
        */
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
        System.out.println();
    }

    // Procesar órdenes personalizadas
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("💰 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                ((OrdenPersonalizada) obj).procesarAjuste(costoAdicional);
            }
        }
        System.out.println(); // salto de línea
    }

    // Contar total de órdenes por tipo
    public static void contarOrdenes(List<OrdenProduccion> todas) {
        int masa = 0, personalizadas = 0, prototipos = 0;
        for (OrdenProduccion orden : todas) {
            if (orden instanceof OrdenMasa) masa++;
            else if (orden instanceof OrdenPersonalizada) personalizadas++;
            else if (orden instanceof OrdenPrototipo) prototipos++;
        }

        System.out.println("📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + masa);
        System.out.println("🛠️ Personalizadas: " + personalizadas);
        System.out.println("🧪 Prototipos: " + prototipos);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Crear listas por tipo
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();

        System.out.println("📥 Órdenes de producción");

        // Pide ingresar ordenes de produccion en masa
        System.out.println("\n🔧 Ingresa 2 órdenes de Producción en Masa:");
        for (int i = 0; i < 2; i++) {
            System.out.print("Código: ");
            String codigo = scanner.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            ordenesMasa.add(new OrdenMasa(codigo, cantidad));
        }
        // Pide ingresar ordenes personalizadas
        System.out.println("\n🛠️ Ingresar 2 órdenes Personalizadas:");
        for (int i = 0; i < 2; i++) {
            System.out.print("Código: ");
            String codigo = scanner.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            System.out.print("Cliente: ");
            String cliente = scanner.nextLine();
            ordenesPersonalizadas.add(new OrdenPersonalizada(codigo, cantidad, cliente));
        }

        // Pide ingresar ordenes prototipo
        System.out.println("\n🧪 Ingresar 2 órdenes Prototipo:");
        for (int i = 0; i < 2; i++) {
            System.out.print("Código: ");
            String codigo = scanner.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            System.out.print("Fase de desarrollo: ");
            String fase = scanner.nextLine();
            ordenesPrototipo.add(new OrdenPrototipo(codigo, cantidad, fase));
        }

        // Mostrar órdenes
        System.out.println("📋 Órdenes registradas:");
        mostrarOrdenes(ordenesMasa);
        mostrarOrdenes(ordenesPersonalizadas);
        mostrarOrdenes(ordenesPrototipo);

        // Procesar personalizadas
        procesarPersonalizadas(ordenesPersonalizadas, 200);

        // Contar total de órdenes
        List<OrdenProduccion> todas = new ArrayList<>();
        todas.addAll(ordenesMasa);
        todas.addAll(ordenesPersonalizadas);
        todas.addAll(ordenesPrototipo);

        contarOrdenes(todas);
    }
}

