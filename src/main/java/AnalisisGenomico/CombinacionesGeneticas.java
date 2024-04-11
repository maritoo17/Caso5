package AnalisisGenomico;

import java.util.HashSet;
import java.util.Set;

public class CombinacionesGeneticas {

    public static void main(String[] args) {
        String alelo1 = "ATGC";
        String alelo2 = "TACG";
        Set<String> combinaciones = generarCombinaciones(alelo1, alelo2, "", 0, new HashSet<>());
        System.out.println("Combinaciones genéticas posibles: " + combinaciones);
    }

    public static Set<String> generarCombinaciones(String alelo1, String alelo2, String combinacionActual, int indice, Set<String> combinaciones) {
        if (indice == alelo1.length()) {
            combinaciones.add(combinacionActual);
            return combinaciones;
        }

        generarCombinaciones(alelo1, alelo2, combinacionActual + alelo1.charAt(indice), indice + 1, combinaciones);

        generarCombinaciones(alelo1, alelo2, combinacionActual + alelo2.charAt(indice), indice + 1, combinaciones);

        return combinaciones;
    }
}
