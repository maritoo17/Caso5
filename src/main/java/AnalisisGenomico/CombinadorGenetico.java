package AnalisisGenomico;

import java.util.Set;

public interface CombinadorGenetico {
    Set<String> generarCombinaciones(String alelo1, String alelo2, String combinacionActual, int indice, Set<String> combinaciones);
}
