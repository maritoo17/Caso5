package InformacionGenetica;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class OrganizacionDeDocumentos {

    public static void main(String[] args) {
        String archivoEntrada = "src/main/java/InformacionGenetica/notas.txt";
        String archivoSalida = "src/main/java/InformacionGenetica/notas_ordenadas.txt";

        try {
            List<String> lineas = Files.readAllLines(Paths.get(archivoEntrada));

            Collections.sort(lineas);

            Files.write(Paths.get(archivoSalida), lineas);

            System.out.println("Las notas han sido organizadas y guardadas en " + archivoSalida);
        } catch (Exception e) {
            System.err.println("Ocurrió un error al intentar organizar las notas: " + e.getMessage());
        }
    }
}