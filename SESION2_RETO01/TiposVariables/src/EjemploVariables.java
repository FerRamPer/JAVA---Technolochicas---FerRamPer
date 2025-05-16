//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EjemploVariables {
    public static void main(String[] args) {
        int edad = 28;
        double salario = 15499.50;
        boolean activo = true;
        char inicial = 'M';
        var ciudad = "Guadalajara";

        // Imprimir los valores almacenados en las variables
        System.out.println("Edad: " + edad);
        System.out.println("Salario: $" + salario);
        System.out.println("Activo: " + activo);
        System.out.println("Inicial: " + inicial);
        System.out.println("Ciudad: " + ciudad);

        // Conversiónes -- casting
        double precio = 199.99;
        int precioRedondeado = (int) precio;
        System.out.println("Precio original: " + precio);
        System.out.println("Precio redondeado: " + precioRedondeado);

        //ceil y floor van a redondear hacia arriba o hacia abajo
        //No sirve para convertir datos
    }
}

