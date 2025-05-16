package narrativa;

public class DialogoTexto implements GestorDialogo {
    @Override
    public void mostrarDialogo(int decision) {
        switch (decision) {
            case 1 -> System.out.println("\"No hay tiempo que perder.\"");
            case 2 -> System.out.println("\"Quizas debamos detenernos un segundo\"");
            default -> System.out.println("\"No entendí tu respuesta\"");
        }
    }
}
