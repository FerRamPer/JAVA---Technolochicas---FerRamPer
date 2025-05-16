public class Vuelo {
    private final String codigoVuelo;  // Código único del vuelo
    private String destino;  // Ciudad destino
    private String horaSalida;  // Hora de salida
    private Pasajero asientoReservado;  // Referencia al pasajero que tiene el asiento reservado

    // Constructor de la clase Vuelo
    public Vuelo(String codigo, String destino, String horaSalida) {
        this.codigoVuelo = codigo;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.asientoReservado = null;  // Inicialmente, no hay asiento reservado
    }

    // Método para reservar un asiento con un objeto Pasajero
    public boolean reservarAsiento(Pasajero p) {
        if (asientoReservado == null) {
            asientoReservado = p;
            System.out.println("✅ Reserva realizada con éxito.");
            return true;
        } else {
            System.out.println("❌ El asiento ya está reservado.");
            return false;
        }
    }

    // Método sobrecargado para reservar un asiento usando nombre y pasaporte
    public boolean reservarAsiento(String nombre, String pasaporte) {
        if (asientoReservado == null) {
            asientoReservado = new Pasajero(nombre, pasaporte);
            System.out.println("✅ Reserva realizada con éxito.");
            return true;
        } else {
            System.out.println("❌ El asiento ya está reservado.");
            return false;
        }
    }

    // Método para cancelar la reserva
    public void cancelarReserva() {
        if (asientoReservado != null) {
            System.out.println("❌ Cancelando reserva...");
            asientoReservado = null;
        } else {
            System.out.println("❌ No hay reserva para cancelar.");
        }
    }

    // Método para obtener el itinerario
    public String obtenerItinerario() {
        String itinerario = "✈️ Itinerario del vuelo:\n";
        itinerario += "Código: " + codigoVuelo + "\n";
        itinerario += "Destino: " + destino + "\n";
        itinerario += "Salida: " + horaSalida + "\n";
        if (asientoReservado != null) {
            itinerario += "Pasajero: " + asientoReservado.getNombre() + "\n";
        } else {
            itinerario += "Pasajero: [Sin reserva]\n";
        }
        return itinerario;
    }
}
