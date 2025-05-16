public record Entrada_record(String nombre, double precio) {
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombre + "|  Precio: $" + precio);
    }
}
