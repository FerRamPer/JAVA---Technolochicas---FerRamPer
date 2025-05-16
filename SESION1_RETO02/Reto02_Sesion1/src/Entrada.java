import java.util.Scanner;

public class Entrada {
    String nombre;
    double precio;

    public Entrada (String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

   public void mostrarInformacion(){
       System.out.println("Evento: " + nombre + "|  Precio: $" + precio);
   }
}

