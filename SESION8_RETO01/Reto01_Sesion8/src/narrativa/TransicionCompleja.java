package narrativa;

public class TransicionCompleja implements TransicionHistoria {
    @Override
    public void avanzar(int decision) {
        if (decision == 1) {
            System.out.println("Eso! Vas con todo, a derrotar al peligro!");
        } else if (decision == 2) {
            System.out.println("Qué bien que has decidido reflexionar, hay que pensar en una buena estrategia");
        } else {
            System.out.println("No es una elección válida, la historia no puede avanzar");
        }
    }
}
