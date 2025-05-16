import java.util.Objects;

public class CuentaFiscal {
    private final String rfc;  // RFC no modificable una vez asignado
    private double saldoDisponible;  // Saldo disponible en la cuenta fiscal

    // Constructor con validación para que el saldo no sea negativo
    public CuentaFiscal(String rfc, double saldoDisponible) {
        if (saldoDisponible < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo.");
        }
        this.rfc = rfc;
        this.saldoDisponible = saldoDisponible;
    }

    // Getters para ambos atributos
    public String getRfc() {
        return rfc;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    // Metodo para validar el RFC con la declaración de impuestos
    public boolean validarRFC(DeclaracionImpuestos declaracion) {
        return Objects.equals(this.rfc, declaracion.rfcContribuyente());
    }
}
