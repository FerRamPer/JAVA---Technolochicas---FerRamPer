//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Crear dos facturas con el mismo folio pero diferentes clientes y totales
        System.out.println("Bienvenido al sistema para comparar facturas");
        System.out.println("Datos de la factura a comparar");
        System.out.println("Ingrese el nombre");
        String nombre1= scanner.nextLine();
        System.out.println("Ingrese el folio");
        String folio1= scanner.nextLine();
        System.out.println("Ingrese el total");
        double total1= scanner.nextDouble();

        System.out.println("----------------------------------");
/*
        System.out.println("Datos de la segunda factura");
        System.out.println("Ingrese el nombre");
        String nombre2= scanner.nextLine();
        System.out.println("Ingrese el folio");
        String folio2= scanner.nextLine();
        System.out.println("Ingrese el total");
        double total2= scanner.nextDouble();
*/

        Factura factura1 = new Factura("AXXX25", "Ana Gonzalez", 2000);
        Factura factura2 = new Factura(folio1, nombre1, total1);

        // Mostrar las facturas usando toString()
        System.out.println(factura1.toString());
        System.out.println(factura2.toString());

        // Comparar las facturas usando equals()
        if (factura1.equals(factura2)) {
            System.out.println("Las facturas son iguales.");
        } else {
            System.out.println("Las facturas son diferentes.");
        }

        // hashCodes de las facturas
        //System.out.println("HashCode de la factura 1: " + factura1.hashCode());
        //System.out.println("HashCode de la factura 2: " + factura2.hashCode());
    }
}