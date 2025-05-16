// Clase principal
public class CentralEmergencias {
    public static void main(String[] args) {
        Ambulancia ambulancia = new Ambulancia("Ambulancia", new Operador("Juan"));
        Patrulla patrulla = new Patrulla("Patrulla", new Operador("Laura"));
        UnidadBomberos bomberos = new UnidadBomberos("UnidadBomberos", new Operador("Marco").toString());

        ambulancia.iniciarOperacion();
        patrulla.iniciarOperacion();
        bomberos.iniciarOperacion();
    }
}
