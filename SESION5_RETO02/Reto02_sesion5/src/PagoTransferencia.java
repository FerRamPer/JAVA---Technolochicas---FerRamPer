import java.util.List;
public class PagoTransferencia extends MetodoPago implements Autenticable {
    private String cuentaDestino;
    private String codigoIngresado;

    private static final List<String> cuentasAutorizadas = List.of("ABC123", "XYZ789", "CUENTA01");
    private static final String codigoCorrecto = "TRANS456";

    public PagoTransferencia(double monto, String cuentaDestino, String codigoIngresado) {
        super(monto);
        this.cuentaDestino = cuentaDestino;
        this.codigoIngresado = codigoIngresado;
    }

    @Override
    public boolean autenticar() {
        return cuentasAutorizadas.contains(cuentaDestino) && codigoIngresado.equals(codigoCorrecto);
    }

    @Override
    public void procesarPago() {
        System.out.println("🏦 Procesando transferencia bancaria por $" + monto);
    }
}