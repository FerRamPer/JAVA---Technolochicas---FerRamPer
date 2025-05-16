import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Crear dos facturas con el mismo folio pero diferentes clientes y totales
        System.out.println("Bienvenido, seleccione la opción de la operación");

        System.out.println("Ingrese el RFC del contribuyente");
        String rfcContribuyente= scanner.nextLine();

        System.out.println("Ingrese el monto a declarar");
        double monto= scanner.nextDouble();
        System.out.println("Ingrese el RFC de la cuenta");
        String rfc= scanner.nextLine();

        System.out.println("Ingrese el saldo disponible");
        double saldo= scanner.nextDouble();
        // Crear una declaración de impuestos
        DeclaracionImpuestos declaracion = new DeclaracionImpuestos(rfcContribuyente, monto);

        // Crear una cuenta fiscal
        CuentaFiscal cuenta = new CuentaFiscal(rfc, saldo);

        // Mostrar la información de la declaración de impuestos y la cuenta fiscal
        System.out.println("📄 Declaración enviada por RFC: " + declaracion.rfcContribuyente() + " por $" + declaracion.montoDeclarado());
        System.out.println("🏦 Cuenta fiscal registrada con RFC: " + cuenta.getRfc() + ", saldo disponible: $" + cuenta.getSaldoDisponible());

        // Validar si el RFC de la cuenta fiscal coincide con el RFC de la declaración de impuestos
        boolean esValido = cuenta.validarRFC(declaracion);
        System.out.println("✅ ¿RFC válido para esta cuenta?: " + esValido);
    }
}