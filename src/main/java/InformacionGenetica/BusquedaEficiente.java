package InformacionGenetica;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BusquedaEficiente implements BusquedaDePalabras {

    @Override
    public int busquedaLineal(List<String> words, String searchWord) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(searchWord)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int busquedaBinaria(List<String> words, String searchWord) {
        int low = 0;
        int high = words.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = searchWord.compareTo(words.get(mid));

            if (result < 0) {
                high = mid - 1;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Este programa realiza búsquedas lineales y binarias en una lista de palabras cargadas desde un archivo.");
        try {
            ClassLoader classLoader = BusquedaEficiente.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("notas.txt");
            if (inputStream == null) {
                throw new IllegalArgumentException("file not found!");
            } else {
                try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                     BufferedReader reader = new BufferedReader(streamReader)) {
                    List<String> words = reader.lines().collect(Collectors.toList());
                    System.out.println("Palabras cargadas: " + words);

                    String searchWord = "palabra";
                    BusquedaDePalabras searcher = new BusquedaEficiente();
                    int linearResult = searcher.busquedaLineal(words, searchWord);
                    System.out.println("Resultado de Búsqueda Lineal: " + linearResult);

                    words.sort(String::compareTo);
                    System.out.println("Palabras ordenadas: " + words);

                    int binaryResult = searcher.busquedaBinaria(words, searchWord);
                    System.out.println("Resultado de Búsqueda Binaria: " + binaryResult);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo o procesar las búsquedas:");
            e.printStackTrace();
        }
    }
}

