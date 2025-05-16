import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class AnalizadorDeLogs {
    public AnalizadorDeLogs() {
    }

    public static void main(String[] args) {
        File archivoSeleccionado = seleccionarArchivo();
        if (archivoSeleccionado == null) {
            System.out.println("\ud83d\udeab No se seleccionó ningún archivo. Terminando programa.");
        } else {
            analizarArchivo(archivoSeleccionado);
        }
    }

    private static File seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona el archivo de logs");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto", new String[]{"log", "txt"}));
        int resultado = fileChooser.showOpenDialog((Component)null);
        return resultado == 0 ? fileChooser.getSelectedFile() : null;
    }

    private static void analizarArchivo(File archivo) {
        int totalLineas = 0;
        int cantidadErrores = 0;
        int cantidadWarnings = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while((linea = lector.readLine()) != null) {
                ++totalLineas;
                if (linea.contains("ERROR")) {
                    ++cantidadErrores;
                }

                if (linea.contains("WARNING")) {
                    ++cantidadWarnings;
                }
            }

            double porcentajeErrores = totalLineas > 0 ? (double)cantidadErrores * (double)100.0F / (double)totalLineas : (double)0.0F;
            double porcentajeWarnings = totalLineas > 0 ? (double)cantidadWarnings * (double)100.0F / (double)totalLineas : (double)0.0F;
            System.out.println("\ud83d\udcca Análisis del archivo: " + archivo.getName());
            System.out.println("\ud83d\udd22 Total de líneas leídas: " + totalLineas);
            System.out.println("❌ Cantidad de errores: " + cantidadErrores);
            System.out.println("⚠️ Cantidad de advertencias: " + cantidadWarnings);
            System.out.printf("\ud83d\udcc8 Porcentaje de errores: %.2f%%\n", porcentajeErrores);
            System.out.printf("\ud83d\udcc8 Porcentaje de advertencias: %.2f%%\n", porcentajeWarnings);
        } catch (IOException e) {
            registrarFallo(e.getMessage());
            System.out.println("⚠️ Error al leer el archivo. Detalles guardados en 'registro_fallos.txt'.");
        }

    }

    private static void registrarFallo(String mensajeError) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("registro_fallos.txt", true))) {
            escritor.write("\ud83d\uded1 Error: " + mensajeError);
            escritor.newLine();
        } catch (IOException e) {
            System.out.println("⚠️ No se pudo escribir en registro_fallos.txt: " + e.getMessage());
        }

    }
}
