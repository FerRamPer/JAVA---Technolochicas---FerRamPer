//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeneradorArchivo {
    public GeneradorArchivo() {
    }

    public static void main(String[] args) {
        try {
            generarArchivoErrores();
            System.out.println("Archivo 'errores.log' creado correctamente en la carpeta 'config/'.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }

    }

    private static void generarArchivoErrores() throws IOException {
        Path carpetaConfig = Paths.get("config");
        if (!Files.exists(carpetaConfig, new LinkOption[0])) {
            Files.createDirectories(carpetaConfig);
        }

        File archivo = carpetaConfig.resolve("errores.log").toFile();

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
            for(int i = 1; i <= 1000; ++i) {
                if (i % 15 == 0) {
                    escritor.write("ERROR: Error crítico detectado en la línea " + i);
                } else if (i % 5 == 0) {
                    escritor.write("WARNING: Advertencia en la línea " + i);
                } else if (i % 3 == 0) {
                    escritor.write("SUCCESS: Prueba pasada en la línea " + i);
                } else {
                    escritor.write("INFO: Línea informativa número " + i);
                }

                escritor.newLine();
            }
        }

    }
}



