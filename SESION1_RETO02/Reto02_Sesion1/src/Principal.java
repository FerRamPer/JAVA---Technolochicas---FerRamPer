public class Principal {
    public static void main(String[] args) {
        Entrada entrada1 = new Entrada("Reto 2.1 Sesion 1 BEDU",250.00);
        Entrada entrada2 = new Entrada("Reto 2.2 Sesion 1 BEDU", 350.50);
        entrada1.mostrarInformacion();
        entrada2.mostrarInformacion();

        Entrada_record entradaRecord = new Entrada_record("Reto adicional BEDU",375.05);

    }
}
