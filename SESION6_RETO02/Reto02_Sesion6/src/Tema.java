// Clase Tema que implementa Comparable para orden alfabético
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Clase Tema que implementa Comparable para orden alfabético
class Tema implements Comparable<Tema> {
    private String titulo;
    private int prioridad; // 1 = urgente, 2 = importante, 3 = opcional

    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Tema otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }

    @Override
    public String toString() {
        return "📘 " + titulo + " (Prioridad: " + prioridad + ")";
    }
}
