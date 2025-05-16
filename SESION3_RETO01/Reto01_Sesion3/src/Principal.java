//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // Crear un pasajero y un vuelo
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("Nombre del Pasajero");
        String nombre1 = scanner.nextLine();
        System.out.println("Numero de pasaporte");
        String pasaporte1 = scanner.nextLine();

        Pasajero pasajero1 = new Pasajero(nombre1, pasaporte1);

        Vuelo vuelo = new Vuelo("UX123", "París", "14:30");
        do {
            System.out.println("Hola, bienvenido a tu sistema de reservas de vuelos");
            System.out.print("Por favor elige una opción: ");
            System.out.println("1. Realizar reserva de vuelo");
            System.out.println("2. Cancelar reserva de vuelo");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Reservar asiento en el vuelo para el primer pasajero
                    vuelo.reservarAsiento(pasajero1);

                    // Mostrar el itinerario del vuelo
                    System.out.println(vuelo.obtenerItinerario());
                    break;
                case 2:
                    // Cancelar la reserva
                    vuelo.cancelarReserva();

                    // Mostrar nuevamente el itinerario después de cancelar la reserva
                    System.out.println(vuelo.obtenerItinerario());
                    break;
                case 3:
                    // Salir
                    System.out.println("Gracias por usar el sistema de reservas. ¡Hasta luego!");
                    break;

                default:
                    // Opción inválida
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
                    break;
        }
        }   while (opcion != 3); // Repetir hasta seleccionar la opción salir

        scanner.close();
        // Reservar asiento usando nombre y pasaporte
        //vuelo.reservarAsiento("Mario Gonzalez", "M7654321");

        // Mostrar el itinerario del vuelo con el nuevo pasajero
        //System.out.println(vuelo.obtenerItinerario());

    }
}