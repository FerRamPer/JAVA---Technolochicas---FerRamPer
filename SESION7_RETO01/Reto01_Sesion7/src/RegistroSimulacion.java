//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class RegistroSimulacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pide nombre del archivo
        System.out.print("📁 Ingresa el nombre del archivo (sin extensión): ");
        String nombreArchivo = scanner.nextLine().trim() + ".txt";

        // Pide especificar parámetros al usuario
        System.out.print("⏱️ Tiempo de ciclo (segundos): ");
        String tiempoCiclo = scanner.nextLine();

        System.out.print("🚀 Velocidad de línea (m/s): ");
        String velocidadLinea = scanner.nextLine();

        System.out.print("🏭 Número de estaciones: ");
        String numeroEstaciones = scanner.nextLine();

        // Construir el contenido a guardar
        String parametros = String.format("""
                Tiempo de ciclo: %s segundos
                Velocidad de línea: %s m/s
                Número de estaciones: %s
                """, tiempoCiclo, velocidadLinea, numeroEstaciones);

        Path rutaDirectorio = Paths.get("config"); //el archivo se crea en la carpeta config del proyecto
        Path rutaArchivo = rutaDirectorio.resolve(nombreArchivo); //combina dos rutas - resolve (path+nombre)

        try {
            guardarParametros(rutaDirectorio, rutaArchivo, parametros);

            if (Files.exists(rutaArchivo)) {
                System.out.println("\n✅ Archivo creado correctamente.");

                String contenido = leerParametros(rutaArchivo);
                System.out.println("\n📄 Contenido del archivo:");
                System.out.println(contenido);
            } else {
                System.out.println("❌ No se pudo crear el archivo.");
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error en operaciones de archivo: " + e.getMessage());
        }

        scanner.close();
    }

    // Guardar parámetros en el archivo txt
    public static void guardarParametros(Path rutaDirectorio, Path rutaArchivo, String contenido) throws IOException {
        if (!Files.exists(rutaDirectorio)) {
            Files.createDirectories(rutaDirectorio);
            System.out.println("📂 Carpeta 'config' creada.");
        }

        Files.writeString(rutaArchivo, contenido, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("💾 Parámetros guardados en '" + rutaArchivo.getFileName() + "'.");
    }

    // Leer archivo
    public static String leerParametros(Path rutaArchivo) throws IOException {
        return Files.readString(rutaArchivo);
    }
}