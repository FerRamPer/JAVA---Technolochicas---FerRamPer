import java.util.Scanner;

public class Paciente {
    //Atributos - todos son publicos si la clase es publica

    //Metodos
    // 1. Tipo de regreso, void cuando no devuelve nada
    // 2. Nombre
    // 3.Parametros con su tipo de dato

    Scanner datos = new Scanner(System.in);  // El objeto datos es de la clase Scanner, system in es para input de usuario

    //Se declaran las variables para uso comun y almacenar lo que lee

    //public String Nombre; //Solo inicializa la variable con ese tipo
    //public Integer Edad; //Solo inicializa la variable con ese tipo
    //constructores
    //SE UTILIZAN METODOS PARA DECLARAR ATRIBUTOS DE CLASE PACIENTE - pedirNombre y pedirEdad

    //Metodo para pedir nombre
    //Se debe declarar como String porque regresa una cadena de texto - Nombre
    public String pideNombre (){
        System.out.println("Introduzca el nombre del paciente");
        //leer Nombre
        //String nombre1 = Nombre;
        return datos.nextLine();
    }
    //Metodo para pedir Edad
    //Se debe declarar como int porque regresa un número entero - Edad

    public int pideEdad (){
        System.out.println("Introduzca la edad del paciente");
        //leer Edad como string y convierte a entero
        //int edad = Edad;
        return Integer.parseInt(datos.nextLine());
    }

    public void MostrarInformacion(String Nombre,Integer Edad){
        System.out.println("Nombre: "+ Nombre);
        System.out.println("Edad: "+ Edad);
    }

}

