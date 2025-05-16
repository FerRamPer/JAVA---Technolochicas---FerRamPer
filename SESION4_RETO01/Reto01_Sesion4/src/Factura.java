import java.util.Objects;

public class Factura {
    private String folio;      // Folio único de la factura
    private String cliente;    // Nombre del cliente
    private double total;      // Total de la factura

    // Constructor con parámetros
    public Factura(String folio, String cliente, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    // Metodo toString() para poner la factura como una cadena completa
    @Override
    public String toString() {
        return "🧾 Factura [folio=" + folio + ", cliente=" + cliente + ", total=$" + total + "]";
    }

    // Metodo equals() para comparar facturas por folio
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Factura factura = (Factura) obj;
        return folio.equals(factura.folio);
    }

    // Metodo hashCode() basado en el folio
    @Override
    public int hashCode() {
        return Objects.hash(folio);
    }

    // Métodos getters para acceder a los atributos
    public String getFolio() {
        return folio;
    }

    public String getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }
}
