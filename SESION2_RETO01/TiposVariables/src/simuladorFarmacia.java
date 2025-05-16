import java.util.Scanner;

public class simuladorFarmacia {
    public static void main(String[] args) {
        //Crear objetos en java
        //1. Clase a la que pertenece el objeto
        //2. Identificador
        //3. New + constructor
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hola, bienvenido a la aplicacion de farmacia");
        System.out.println("Nombre del medicamento");
        String nombre = scanner.nextLine();

        //System.out.println("Precio unitario");
        var n = 1000;
        double precio = (Math.random() * n) + 1;
        //double precio = scanner.nextDouble();
        System.out.println("Precio unitario: $"+precio);


        System.out.println("Número de piezas");
        int cantidad = scanner.nextInt();

        var total1 = precio*cantidad;

        boolean aplicaDesc = total1 > 500; // true o false
        // ? es operador ternario
        double descuento = aplicaDesc ? total1*0.15 : 0;

        double totalDesc = total1 - descuento;

        System.out.println("RESUMEN");
        System.out.println("Nombre del medicamento: "+nombre);
        System.out.println("Número de piezas "+cantidad);
        System.out.println("Total (sin descuento): $"+total1);
        System.out.println("¿Aplica descuento?  "+aplicaDesc);
        System.out.println("Descuento aplicado: $"+ descuento);
        System.out.println("Total (con descuento): $"+totalDesc);
    }
}

