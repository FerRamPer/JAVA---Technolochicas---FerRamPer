//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    public static <string> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int service;
        do {
            System.out.println("Hola, bienvenido a tu sistema de facturacion");
            System.out.println("Ingrese su RFC, si no cuenta con él, solo oprima enter");
            String rfc= scanner.nextLine();
            System.out.println("Por favor elige un servicio a facturar ");
            System.out.println("1. Reparación de equipo");
            System.out.println("2. Servicio de consultoría");
            System.out.println("3. Cambio de pieza");
            System.out.println("4. Servicios complementarios");
            System.out.println("5. Salir");
            service = scanner.nextInt();



            Factura factura;

            // La descripción cambia según el servicio a facturar
            switch (service){
                case 1:
                    rfc = rfc.isEmpty() ? null : rfc;
                    factura = new Factura(1800.0,"Reparación de equipo", rfc);
                    break;
                case 2:
                    rfc = rfc.isEmpty() ? null : rfc;
                    factura = new Factura(2500.0,"Servicio de consultoría", rfc);
                    break;
                case 3:
                    rfc = rfc.isEmpty() ? null : rfc;
                    factura = new Factura(3000.0,"Cambio de pieza", rfc);
                case 4:
                    rfc = rfc.isEmpty() ? null : rfc;
                    factura = new Factura(3000.0,"Servicios complementarios", rfc);
                    break;
                default:
                    throw new IllegalStateException("Por favor elige una opción válida de servicio");
            }
            // Imprimir resumen de la factura
            System.out.println("📄 Factura generada:");
            System.out.println(factura.getResumen());

            System.out.println("Gracias por usar el servicio de facturación\n ---------------- \n");

        } while (service != 5); //Repetir hasta que el usuario decida salir

    }
}