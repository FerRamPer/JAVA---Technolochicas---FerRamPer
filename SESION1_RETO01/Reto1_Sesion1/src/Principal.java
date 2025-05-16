public class Principal {
    public static void main(String[] args) {
        //Crear objetos en java
        //1. Clase a la que pertenece el objeto
        //2. Identificador
        //3. New + constructor
        System.out.println("BIENVENIDO!!");
        //System.out.println("Introduzca el nombre (Enter) y la edad (Enter) del paciente");
        Paciente paciente1 = new Paciente(); //Inicializa objeto de clase Paciente - constructor

        String nombre1 = paciente1.pideNombre(); //Llama a metodo de clase paciente y asigna lo que regresa a var nombre1
        Integer edad1 = paciente1.pideEdad(); //Llama a metodo de clase paciente y asigna lo que regresa a var edad1

        paciente1.MostrarInformacion(nombre1,edad1); //Usa los return de metodos anteriores como args de entrada

    }
}
