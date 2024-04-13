package InformacionGenetica;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BusquedaEficiente {

    public static void main(String[] args) {
        try {
            List<String> words = Files.readAllLines(Paths.get("notas.txt"));
            String searchWord = "palabra";
            int linearResult = busquedaLineal(words, searchWord);
            System.out.println("Resultado de Búsqueda Lineal: " + linearResult);

            words.sort(String::compareTo);
            int binaryResult = busquedaBinaria(words, searchWord);
            System.out.println("Resultado de Búsqueda Binaria: " + binaryResult);
        } catch (Exception e) {
            System.err.println("Error al leer el archivo o procesar las búsquedas:");
            e.printStackTrace();
        }
    }

    public static int busquedaLineal(List<String> words, String searchWord) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(searchWord)) {
                return i;
            }
        }
        return -1;
    }

    public static int busquedaBinaria(List<String> words, String searchWord) {
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
}
