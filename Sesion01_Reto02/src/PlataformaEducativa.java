import java.util.*;
import java.util.function.Predicate;

// Clase principal
public class PlataformaEducativa {
    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>();
        materiales.add(new Video("Introducción a Java", "Mario", 15));
        materiales.add(new Video("POO en Java", "Carlos", 20));
        materiales.add(new Articulo("Historia de Java", "Ana", 1200));
        materiales.add(new Articulo("Tipos de datos", "Luis", 800));
        materiales.add(new Ejercicio("Variables y tipos", "Luis"));
        materiales.add(new Ejercicio("Condicionales", "Mario"));

        UtilidadesCurso.mostrarMateriales(materiales);

        // Filtrar solo videos para contar duración
        List<Video> videos = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            }
        }
        UtilidadesCurso.contarDuracionVideos(videos);

        // Marcar ejercicios como revisados
        UtilidadesCurso.marcarEjerciciosRevisados(materiales);

        // Filtrar por autor
        System.out.println("\n🔍 Filtrando materiales por autor:");
        List<MaterialCurso> filtrados = UtilidadesCurso.filtrarPorAutor(materiales, m -> m.getAutor().equals("Mario"));
        for (MaterialCurso material : filtrados) {
            material.mostrarDetalle();
        }
    }
}