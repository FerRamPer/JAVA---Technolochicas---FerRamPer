import java.util.*;
import java.util.stream.*;

public class ResumenPorSucursal {
    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Ana", "El tiempo de espera fue largo", 2),
                        new Encuesta("Luis", null, 5),
                        new Encuesta("Carla", "Faltaban insumos", 3)
                )),
                new Sucursal("Norte", List.of(
                        new Encuesta("Roberto", "La atención fue buena, pero la limpieza puede mejorar", 3),
                        new Encuesta("Elena", null, 2),
                        new Encuesta("Mario", null, 4)
                ))
        );

        System.out.println("📊 Resumen por sucursal:");
        System.out.println("--------------------------");

        sucursales.forEach(sucursal -> {
            long encuestasBajas = sucursal.getEncuestas().stream()
                    .filter(e -> e.getCalificacion() <= 3)
                    .count();

            long conComentario = sucursal.getEncuestas().stream()
                    .filter(e -> e.getCalificacion() <= 3)
                    .map(Encuesta::getComentario)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .filter(c -> !c.isBlank())
                    .count();

            System.out.println("📍 Sucursal " + sucursal.getNombre());
            System.out.println("   - Encuestas con calificación ≤ 3: " + encuestasBajas);
            System.out.println("   - Comentarios disponibles: " + conComentario);
        });
    }
}
