package narrativa;

public class DialogoEmocional implements GestorDialogo {
    @Override
    public void mostrarDialogo(int decision) {
        switch (decision) {
            case 1 -> System.out.println("\"VAMOS! No hay tiempo que perder!\"");
            case 2 -> System.out.println("\"ESPERA! Lo pensaré un poco mejor...\"");
            default -> System.out.println("\"¿QUÉ? No comprendo qué quieres hacer\"");
        }
    }
}
