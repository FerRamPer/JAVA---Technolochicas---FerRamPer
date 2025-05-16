
import java.util.Scanner;

public class CajaRegistradora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE PAGOS ===");
        System.out.println("Seleccione el método de pago:");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. Transferencia");

        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        System.out.print("Ingrese el monto a pagar: ");
        double monto = scanner.nextDouble();

        MetodoPago pago = null;

        switch (opcion) {
            case 1:
                pago = new PagoEfectivo(monto);
                break;

            case 2:
                System.out.print("Ingrese el saldo disponible en la tarjeta: ");
                double saldo = scanner.nextDouble();
                System.out.print("Ingrese su CVV: ");
                String CVV = scanner.next();
                pago = new PagoTarjeta(monto, saldo, CVV);
                break;

            case 3:
                System.out.print("Ingrese la cuenta destino: ");
                String cuenta = scanner.next();
                System.out.print("Ingrese el código de verificación para transferir que aparece en su teléfono ");
                String codigo = scanner.next();
                pago = new PagoTransferencia(monto, cuenta, codigo);
                break;

            default:
                System.out.println("❌ Opción inválida.");
                scanner.close();
                return;
        }

        procesarPago(pago);
        scanner.close();
    }

    private static void procesarPago(MetodoPago pago) {
        if (pago instanceof Autenticable) {
            Autenticable metodo = (Autenticable) pago;
            if (metodo.autenticar()) {
                System.out.println("✅ Autenticación exitosa.");
                pago.procesarPago();
                pago.mostrarResumen();
            } else {
                System.out.println("❌ Fallo de autenticación. " + pago.getClass().getSimpleName() + " no válido.");
            }
        }
        System.out.println(); // separador visual
    }
}

