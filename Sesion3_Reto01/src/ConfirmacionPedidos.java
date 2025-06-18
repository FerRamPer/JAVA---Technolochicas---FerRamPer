import java.util.*;
import java.util.stream.*;

public class ConfirmacionPedidos {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
                new Pedido("Ana", "domicilio", "55-12-34-56-78"),
                new Pedido("Luis", "local", "55-12-23-34-45"),
                new Pedido("Sofía", "domicilio", null),
                new Pedido("Carlos", "domicilio", "55-11-22-33-44"),
                new Pedido("Valeria", "domicilio", "")
        );

        System.out.println("📦 Confirmando pedidos a domicilio...\n");

        List<String> errores = new ArrayList<>();

        pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
                .forEach(p -> {
                    Optional<String> telefono = p.getTelefono();
                    if (telefono.isPresent() && !telefono.get().isBlank()) {
                        System.out.println("📞 Confirmación enviada al número: " + telefono.get());
                    } else {
                        errores.add("❌ Error: el pedido de " + p.getCliente() + " no tiene teléfono válido.");
                    }
                });

        if (!errores.isEmpty()) {
            System.out.println("\n🚨 Pedidos con error de contacto:");
            errores.forEach(System.out::println);
        }
    }
}
