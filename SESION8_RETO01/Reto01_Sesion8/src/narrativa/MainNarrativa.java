package narrativa;

import java.util.Scanner;

public class MainNarrativa {

    private final TransicionHistoria transicion;
    private final GestorDialogo gestorDialogo;
    private final LogicaDecision logicaDecision;

    public MainNarrativa(TransicionHistoria transicion, GestorDialogo gestorDialogo, LogicaDecision logicaDecision) {
        this.transicion = transicion;
        this.gestorDialogo = gestorDialogo;
        this.logicaDecision = logicaDecision;
    }

    public void ejecutarEscena() {
        int decision = logicaDecision.tomarDecision();
        gestorDialogo.mostrarDialogo(decision);
        transicion.avanzar(decision);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige tipo de transición: 1 - Simple, 2 - Compleja");
        int tipoTransicion = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Elige tipo de diálogo: 1 - Texto, 2 - Emocional");
        int tipoDialogo = Integer.parseInt(scanner.nextLine().trim());

        TransicionHistoria transicion = (tipoTransicion == 2) ? new TransicionCompleja() : new TransicionSimple();
        GestorDialogo dialogo = (tipoDialogo == 2) ? new DialogoEmocional() : new DialogoTexto();
        LogicaDecision decision = new DecisionBinaria(scanner);

        MainNarrativa escena = new MainNarrativa(transicion, dialogo, decision);
        escena.ejecutarEscena();

        scanner.close();
    }
}
