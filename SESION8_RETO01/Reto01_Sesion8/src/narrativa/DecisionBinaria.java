package narrativa;

import java.util.Scanner;

public class DecisionBinaria implements LogicaDecision {

    private final Scanner scanner;

    public DecisionBinaria(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int tomarDecision() {
        System.out.println("¿Qué decides hacer?");
        System.out.println("1 - Avanzar con valentía");
        System.out.println("2 - Reflexionar y esperar");
        System.out.print("Ingresa tu decisión (1 o 2): ");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equals("1") || input.equals("2")) {
                return Integer.parseInt(input);
            } else {
                System.out.print("Opción inválida. Por favor ingresa 1 o 2: ");
            }
        }
    }
}
