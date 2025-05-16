import java.util.Scanner;

public class Datos {
    Scanner datos = new Scanner(System.in);  // El objeto datos es de la clase Scanner, system in es para input de usuario


    //Metodo para pedir nombre
    //Se debe declarar como String porque regresa una cadena de texto - Nombre
    public String pideMedicamento (){
        System.out.println("Introduzca el nombre del medicamento");
        //leer Nombre
        //String nombre1 = Nombre;
        return datos.nextLine();
    }
    //Metodo para pedir Edad
    //Se debe declarar como int porque regresa un número entero - Edad

    public int pideCantidad (){
        System.out.println("Introduzca la cantidad");
        //leer Edad como string y convierte a entero
        //int edad = Edad;
        return Integer.parseInt(datos.nextLine());
    }

    public double pidePrecio (){
        System.out.println("Introduzca el precio original");
        //leer Edad como string y convierte a entero
        //int edad = Edad;
        return Integer.parseInt(datos.nextLine());
    }

    public void MostrarInformacion(String Nombre,Integer Cantidad,double precio){
        System.out.println("Nombre del medicamento: "+ Nombre);
        System.out.println("Numero de piezas: "+ Cantidad);
        System.out.println("Precio: "+ precio);
    }

}
