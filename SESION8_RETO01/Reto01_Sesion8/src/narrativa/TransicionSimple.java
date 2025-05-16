package narrativa;

public class TransicionSimple implements TransicionHistoria {
    @Override
    public void avanzar(int decision) {
        switch (decision) {
            case 1 -> System.out.println("La historia avanza hacia un camino de valor.");
            case 2 -> System.out.println("La historia toma un rumbo cauteloso y reflexivo.");
            default -> System.out.println("La historia se queda en pausa, esperando una decisión válida.");
        }
    }
}
