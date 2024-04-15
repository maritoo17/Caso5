package InformacionGenetica;

import java.util.List;

public interface BusquedaDePalabras {
    int busquedaLineal(List<String> words, String searchWord);
    int busquedaBinaria(List<String> words, String searchWord);
}
