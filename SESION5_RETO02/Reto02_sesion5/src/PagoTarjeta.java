public class PagoTarjeta extends MetodoPago implements Autenticable {
    private double saldoDisponible;
    private String pinIngresado;
    private final String pinCorrecto = "1234"; // Simulación de PIN correcto

    public PagoTarjeta(double monto, double saldoDisponible, String pinIngresado) {
        super(monto);
        this.saldoDisponible = saldoDisponible;
        this.pinIngresado = pinIngresado;
    }

    @Override
    public boolean autenticar() {
        return saldoDisponible >= monto && pinIngresado.equals(pinCorrecto);
    }

    @Override
    public void procesarPago() {
        System.out.println("💳 Procesando pago con tarjeta por $" + monto);
    }
}
