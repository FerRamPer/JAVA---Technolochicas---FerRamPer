import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Métodos genéricos
public class UtilidadesCurso {
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("📚 Materiales del curso:");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video video : lista) {
            total += video.getDuracion();
        }
        System.out.println("\n🎥 Duración total de videos: " + total + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                Ejercicio ejercicio = (Ejercicio) obj;
                ejercicio.marcarRevisado();
                System.out.println("✅ Ejercicio '" + ejercicio.getTitulo() + "' marcado como revisado.");
            }
        }
    }

    public static List<MaterialCurso> filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> criterio) {
        List<MaterialCurso> filtrados = new ArrayList<>();
        for (MaterialCurso material : lista) {
            if (criterio.test(material)) {
                filtrados.add(material);
            }
        }
        return filtrados;
    }
}
