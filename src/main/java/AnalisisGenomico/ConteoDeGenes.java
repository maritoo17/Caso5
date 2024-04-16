package AnalisisGenomico;

import java.util.Random;
import java.util.Scanner;

public class ConteoDeGenes implements ContadorDeGenes {
    private Scanner scanner;

    public ConteoDeGenes(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int contarGenes(String dna) {
        return contarGenesAux(dna, 0);
    }

    private int contarGenesAux(String dna, int index) {
        if (dna.length() - index < 3) {
            return 0;
        }
        int startIndex = dna.indexOf("ATG", index);
        if (startIndex == -1) {
            return 0;
        }
        int endIndex = encontrarFinalGen(dna, startIndex + 3);
        if (endIndex != -1) {
            return 1 + contarGenesAux(dna, endIndex + 3);
        } else {
            return contarGenesAux(dna, startIndex + 3);
        }
    }

    private int encontrarFinalGen(String dna, int startIndex) {
        for (int i = startIndex; i < dna.length() - 2; i += 3) {
            String codon = dna.substring(i, i + 3);
            if (codon.equals("TAG") || codon.equals("TAA") || codon.equals("TGA")) {
                return i;
            }
        }
        return -1;
    }

    private static String generarSecuenciaAleatoria(int longitud) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        String bases = "ATGC";
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(bases.length());
            sb.append(bases.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConteoDeGenes app = new ConteoDeGenes(scanner);

        System.out.println("Seleccione una opción:");
        System.out.println("1. Ingresar una secuencia de ADN.");
        System.out.println("2. Generar una secuencia de ADN aleatoria.");
        System.out.println("Ingrese 1 para analizar una secuencia específica de ADN o 2 para generar y analizar una secuencia aleatoria.");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        String dna;
        if (opcion == 1) {
            System.out.println("Usted ha elegido ingresar una secuencia de ADN. Por favor, introduzca la secuencia de ADN para su análisis:");
            dna = scanner.nextLine();
        } else {
            int longitud = 50;
            dna = generarSecuenciaAleatoria(longitud);
            System.out.println("Se ha generado una secuencia de ADN aleatoria. A continuación, se analizará la secuencia generada:");
            System.out.println(dna);
        }

        System.out.println("Análisis en progreso... Calculando el número de genes en la secuencia de ADN proporcionada.");
        int count = app.contarGenes(dna);
        System.out.println("Total de genes encontrados: " + count);
    }
}
