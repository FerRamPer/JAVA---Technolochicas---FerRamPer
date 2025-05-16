import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Cajero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = 30000.0; // Saldo inicial
        int opcion;

        // Menú interactivo
        do {
            System.out.println("Hola, bienvenido a tu cajero automático");
            System.out.print("Por favor elige una opción: ");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");



            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Consultar saldo
                    System.out.println("El saldo actual es: $" + saldo);
                    break;

                case 2:
                    // Depositar dinero
                    System.out.print("Ingrese el monto a depositar: $");
                    double montoDepositar = scanner.nextDouble();
                    if (montoDepositar > 0) {
                        saldo += montoDepositar;
                        System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    } else {
                        System.out.println("El monto a depositar debe ser mayor que cero.");
                    }
                    break;

                case 3:
                    // Retirar dinero
                    System.out.print("Ingrese el monto a retirar: $");
                    double montoRetirar = scanner.nextDouble();
                    if (montoRetirar > saldo) {
                        System.out.println("No hay suficiente saldo para realizar la operación.");
                        continue;  // Vuelve al menú sin realizar el retiro
                    } else if (montoRetirar <= 0) {
                        System.out.println("El monto a retirar debe ser mayor que cero.");
                        continue;  // Vuelve al menú sin realizar el retiro
                    }
                    saldo -= montoRetirar;
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                    break;

                case 4:
                    // Salir
                    System.out.println("Gracias por usar el cajero automático. ¡Hasta luego!");
                    break;

                default:
                    // Opción inválida
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                    break;
            }

        } while (opcion != 4); // Repetir hasta seleccionar la opción salir
        scanner.close();
    }
}