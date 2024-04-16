package InformacionGenetica;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class OrganizacionDeDocumentos implements OrganizadorDeDocumentos {

    @Override
    public void organizeDocuments(String inputFile, String outputFile) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(inputFile));
            Collections.sort(lineas);
            Files.write(Paths.get(outputFile), lineas);
            System.out.println("Las notas han sido organizadas y guardadas en " + outputFile);
        } catch (Exception e) {
            System.err.println("Ocurrió un error al intentar organizar las notas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Este programa ordena el contenido de un archivo de texto y guarda el resultado en un nuevo archivo.");
        String archivoEntrada = "src/main/java/InformacionGenetica/notas.txt";
        String archivoSalida = "src/main/java/InformacionGenetica/notas_ordenadas.txt";
        OrganizadorDeDocumentos organizer = new OrganizacionDeDocumentos();
        organizer.organizeDocuments(archivoEntrada, archivoSalida);
    }
}
