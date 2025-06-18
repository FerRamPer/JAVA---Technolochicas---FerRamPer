import java.util.ArrayList;
import java.util.List;

public class OrdenPersonalizada extends OrdenProduccion{
    public String cliente;
    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }
    public void procesarAjuste(int costoAdicional) {
        System.out.println("✅ Orden " + codigo + " ajustada con costo adicional de $" + costoAdicional);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🛠️ OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad + " - Cliente: " + cliente);
    }
}

