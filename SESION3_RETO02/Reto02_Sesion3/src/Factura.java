import java.util.Optional;

public class Factura {
    // Atributos privados
    private double monto;
    private String descripcion;
    private Optional<String> rfc;

    // Constructor de la clase Factura
    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        // Para cuando el RFC es null, se utiliza Optional-nullable
        this.rfc = Optional.ofNullable(rfc);
    }

    // Metodo obtener resumen
    public String getResumen() {
        // Si el RFC está presente, se muestra; si no, se muestra un mensaje por defecto
        String rfcInfo = rfc.isPresent() ? rfc.get() : "[No proporcionado]";
        return "Descripción: " + descripcion + "\n" +
                "Monto: $" + monto + "\n" +
                "RFC: " + rfcInfo;
    }
}
